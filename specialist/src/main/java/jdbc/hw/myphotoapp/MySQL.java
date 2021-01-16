package jdbc.hw.myphotoapp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class MySQL {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root&useLegacyDateTimeCode=false&serverTimezone=UTC";

    public static void putPhoto(String name, String path) {

        try (Connection conn = DriverManager.getConnection(CONN_STRING)) {
            File file = new File(path);
            if (!file.exists()) {
                return;
            }
            int size = (int) file.length();
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));

            Statement st = conn.createStatement();
            st.executeUpdate("USE db");
            st.executeUpdate("CREATE TABLE pictures (name VARCHAR(32), photo MEDIUMBLOB)");
//            st.executeUpdate("DROP TABLE pictures");

            String sql = "INSERT INTO pictures (name, photo) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setBinaryStream(2, fis, size);
            pst.executeUpdate();

        } catch (SQLException | FileNotFoundException ex) {
            System.out.println("Cannot open connection! " + ex.getMessage());
        }

    }

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL driver not found!");
            return;
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection! " + ex.getMessage());
        }

        putPhoto("zamok_art_vektor_solnce", "D:" + File.separator + "Chrom Downloads" +
                File.separator + "51611-zamok_art_vektor_solnce.jpg");


        try {
            Statement st = conn.createStatement();
            st.executeUpdate("USE db");
            ResultSet rs = st.executeQuery("SELECT * FROM pictures");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getBlob("photo"));
            }
        } catch (SQLException ex) {
            System.out.println("Cannot open connection! " + ex.getMessage());
        }
    }

}
