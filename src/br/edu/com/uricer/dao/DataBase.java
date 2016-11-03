package br.edu.com.uricer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class DataBase {
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TRABLP3", "TRAB", "TRAB");
        return conn;
    }
    
}
