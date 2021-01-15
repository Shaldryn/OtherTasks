package jdbc;

import java.sql.*;
import java.util.Enumeration;

public class JavaApp {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root&useLegacyDateTimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
            return;
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection! " + ex.getMessage());
            return;
        }

        try {
            Statement st = conn.createStatement();
//            st.executeUpdate("CREATE DATABASE db");
            st.executeUpdate("USE db");
//            st.executeUpdate("CREATE TABLE persons (name varchar(32), age int(3))");
//            st.executeUpdate("INSERT INTO persons (name, age) VALUES ('Name4', 32)");
            ResultSet rs = st.executeQuery("SELECT * FROM persons WHERE age=32 ORDER BY name");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getString("age"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
