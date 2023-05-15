/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Subjects;

import com.mycompany.educationalmanagementsystem.db.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahfoudhi
 */
public class SubjectRepository {
    private Connection conn;
    private static SubjectRepository instance;
    
    private SubjectRepository(Connection conn){
        this.conn = conn;
    }
    
    public static SubjectRepository getInstance(){
        if(instance == null){
            instance = new SubjectRepository(ConnectionDB.getConnection());
        }
        return instance;
    }
    
    public List<Subject> getAll(){
        String sql = "SELECT * from subjects";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(result.next()){
                Subject subject = new Subject(result.getInt("id"),result.getString("title"));
                subjects.add(subject);
            }
            result.close();
            statement.close();
            return subjects;
        }catch(SQLException e){
            System.out.println("Error while getting all subjects");
            return null;
        }
    }
    
    public Subject getSubjectById(int id) throws Exception{
        System.out.println(id);
        String sql = "SELECT * from subjects where id = ?";
        Subject subject = null;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                subject = new Subject(id, result.getString(1));
            }
        }catch(SQLException e){
            System.out.println("Error while deleting a student");
            throw e;
        }
        return subject;
    }
}
