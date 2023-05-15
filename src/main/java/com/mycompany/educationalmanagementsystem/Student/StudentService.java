/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Student;

import com.mycompany.educationalmanagementsystem.Utils.Validation;
import java.util.List;



/**
 *
 * @author mahfoudhi
 */
public class StudentService {
    private static StudentService instance;
    private static StudentRepository studentRepo;
    
    private StudentService(StudentRepository studentRepo){
        StudentService.studentRepo = studentRepo;
    }
    
    public static StudentService getInstance(){
        if(instance != null) return instance;
        instance = new StudentService(StudentRepository.getInstance());
        return instance;
    }
    

    
    public void addStudent(Student s) throws Exception{
        String error = isValid(s);
        if(error != null){
            throw new Exception(error);
        }
        try{
            studentRepo.createStudent(s);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Failed to create student");
        }
    }
    
    public void updateStudent(Student s) throws Exception{
        String validRes = isValid(s);
        if(validRes != null){
            throw new Exception(validRes);
        }
        Student studentFound = null;
        try{
            studentFound = studentRepo.getStudentById(s.getId());
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while searching for student by ID");
        }
        
        if(studentFound == null){
            throw new Exception("Student with id " + s.getId() + " does not exist");
        }
        
        try{
          
            Student student = studentRepo.getStudentByEmail(s.getEmail());
            if(student != null && !student.getEmail().equals(s.getEmail())){
                throw new Exception("Email already in use");
            }
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while searching for a student by email");
        }

        try{
            studentRepo.updateStudent(s);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while searching for a student");
        }
    }
    
    public void deleteStudent(int id) throws Exception{
        Student studentFound = null;
        try{
            studentFound = studentRepo.getStudentById(id);
        }catch(Exception e){
            throw new Exception("Error while searching for student by ID");
        }
        if(studentFound == null){
            throw new Exception("Student with id " + id + " does not exist");
        }
        try{
            studentRepo.deleteStudent(id);
        }catch(Exception e){
            throw new Exception("Error while deleting a student");
        }
    }
    
    public List<Student> getAll() throws Exception{
        try{
            return studentRepo.getAll();
        }catch(Exception e){
            throw new Exception("Error while getting all students");
        }
    }
    
    public Student getByEmail(String email) throws Exception{
        try{
            return studentRepo.getStudentByEmail(email);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while searching for a student by email");
        }
    }
    
    public Student getStudentById(int id) throws Exception{
        try{
            return studentRepo.getStudentById(id);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while searching for a student by id");
        }
    }
    
    public String isValid(Student s){
        if(s.getFirstName().equals("") || !Validation.isAlphabetic(s.getFirstName())){
            return "Invalid Firstname";
        }
        if(s.getLastName().equals("") || !Validation.isAlphabetic(s.getLastName())){
            
            return "Invalid Lastname";
        }
        if(!Validation.isEmail(s.getEmail())){
            
            return "Invalid Email";
        }
        return null;
    }
    

}
