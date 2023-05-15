/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Student;

import java.time.LocalDate;

/**
 *
 * @author mahfoudhi
 */
public class Student{
    
    private int id;   
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    
    public Student(String firstName, String lastName, String email, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    
    public Student(int id, String firstName, String lastName, String email, LocalDate dateOfBirth){
        this(firstName,lastName,email,dateOfBirth);
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public static boolean isValidFirstName(String firstName){
        return true;
    }
    
    
}
