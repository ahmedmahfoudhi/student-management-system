/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahfoudhi
 */
public class StudentSubjectsDTO {
    private int studentId;
    private List<Pair<Integer,Integer>> subjectsScores;
    
    public StudentSubjectsDTO(int id){
        studentId = id;
        subjectsScores = new ArrayList<>();
    }
    
    public void setStudentId(int id){
        studentId = id;
    }
    
    public List<Pair<Integer,Integer>> getSubjectsScores(){
        return subjectsScores;
    }
    
    public void addSubjectScore(int subjectId, int score){
        subjectsScores.add(new Pair(subjectId,score));
    }
    
}
