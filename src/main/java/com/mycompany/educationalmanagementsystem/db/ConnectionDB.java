/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mahfoudhi
 */
public class ConnectionDB {
    private static Connection connection;
    
    
    public static Connection getConnection(){
        if(connection == null){
            String username = "root";
            String password = "root";
            String dbUrl = "jdbc:mysql://localhost:3306/online_platform";
            try{
                connection = (Connection) DriverManager.getConnection(dbUrl,username,password);
            }catch(SQLException e){
                System.out.println("Unable to connect to the database, please verify database url and user credentials");
            }
            
        }
        return connection;
    }
}
