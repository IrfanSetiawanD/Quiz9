/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author setia
 */
public class ConnectionDB {

    private static Connection connection = null;

    public static Connection getConnectionDB() {
        if (connection != null) {
            return connection;
        } else {
            try {
//databaseName?zeroDateTimeBehavior=convertToNull
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/hr";
                String user = "root";
                String password = "";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("sukses");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
            return connection;
        }
    }
}
