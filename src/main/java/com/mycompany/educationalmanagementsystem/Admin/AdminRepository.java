/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Admin;

import com.mycompany.educationalmanagementsystem.db.ConnectionDB;
import java.sql.*;

/**
 *
 * @author mahfoudhi
 */
public class AdminRepository {
    private Connection conn;
    private static AdminRepository instance;
    
    private AdminRepository(Connection conn){
        this.conn = conn;
    }
    
    public static AdminRepository getInstance(){
        if(instance == null){
            instance = new AdminRepository(ConnectionDB.getConnection());
        }
        return instance;
    }
    
    public AdminLogin findByUsername(String username){
        String sql = "SELECT * from admins where username = ?";
        AdminLogin admin = null;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                admin = new AdminLogin(result.getString("username"), result.getString("password"));
                result.close();
                statement.close();
            }
        }catch(SQLException e){
            System.out.println("Error while searching for admin by username");
            
            System.out.println(e.toString());
        }
        return admin;

        
    }
}
