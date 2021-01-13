package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JavaApp {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root";

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

        try {
            Connection conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection! " + ex.getMessage());
            return;
        }

    }
}
