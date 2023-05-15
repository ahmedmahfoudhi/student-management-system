/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Student;

import com.mycompany.educationalmanagementsystem.Subjects.Subject;
import com.mycompany.educationalmanagementsystem.db.ConnectionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahfoudhi
 */
public class StudentRepository {
    private static StudentRepository instance;
    private static Connection conn;
    
    private StudentRepository(Connection conn){
        StudentRepository.conn = conn;
    }
    
    public static StudentRepository getInstance(){
        if(instance == null){
            instance = new StudentRepository(ConnectionDB.getConnection());
        }
        return instance;
    }
    

    
    public void createStudent(Student s) throws Exception{
        String sql = "INSERT INTO students (first_name, last_name, email, date_of_birth) values(?,?,?,?)";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,s.getFirstName());
            statement.setString(2, s.getLastName());
            statement.setString(3, s.getEmail());
            statement.setDate(4, Date.valueOf(s.getDateOfBirth()));
            statement.executeUpdate();
    
            statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
            throw e;
        }
    }
    
    public void updateStudent(Student s) throws Exception{
        String sql = "UPDATE students set first_name = ?, last_name = ?, email = ?, date_of_birth = ? where id = ? ";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,s.getFirstName());
            statement.setString(2, s.getLastName());
            statement.setString(3, s.getEmail());
            statement.setDate(4, Date.valueOf(s.getDateOfBirth()));
            statement.setInt(5, s.getId());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.println("Error while updating a student");
            throw e;
        }
    }
    
    public void deleteStudent(int id) throws Exception{
        String sql = "DELETE from students where id = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.println("Error while deleting a student");
            throw e;
        }
    }
    
    public Student getStudentById(int id) throws Exception{
        String sql = "SELECT * from students where id = ?";
        Student student = null;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                student = getStudentFromResult(result);
            }
        }catch(SQLException e){
            System.out.println("Error while deleting a student");
            throw e;
        }
        return student;
    }
    
    
    public Student getStudentByEmail(String email){
        String sql = "SELECT * from students where email = ?";
        Student student = null;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                student = getStudentFromResult(result);
            }
        }catch(SQLException e){
            System.out.println("Error while deleting a student");
        }
        return student;
    }
    
    public List<Student> getAll() throws Exception{
        String sql = "SELECT * from students";
         try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Student> students = new ArrayList<>();
            while(result.next()){
                
                students.add(getStudentFromResult(result));
            }
            result.close();
            statement.close();
            return students;
        }catch(SQLException e){
            System.out.println("Error while getting all subjects");
            throw e;
        }
    }
    
    private Student getStudentFromResult(ResultSet result) throws SQLException{
        int id = result.getInt("id");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String email = result.getString("email");
        LocalDate dateOfBirth = result.getDate("date_of_birth").toLocalDate();
        return new Student(id,firstName,lastName,email,dateOfBirth);
    }
}
