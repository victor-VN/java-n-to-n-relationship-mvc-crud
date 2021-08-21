package com.io.victorvn.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String HOST = "localhost";
    private static final String DB_NAME = "PTPESDB";
    private static final String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "jdbc:mysql://" + HOST + "/" + DB_NAME + "?useTimezone=true&serverTimezone=UTC";

    public static Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null){
                System.out.println("SUCCESS: BANCO CONECTADO");
            }
            return connection;
        } catch (SQLException e){

            System.out.println("ERROR: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
