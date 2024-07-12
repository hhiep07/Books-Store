/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dang
 */
public class DatabaseUtil {
    private static final String URL = "jdbc:sqlserver://PHUOCHIEP:1433;databaseName=GR3;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "hiep170703";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
