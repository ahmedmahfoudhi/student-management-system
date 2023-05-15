/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

import com.mycompany.educationalmanagementsystem.Student.Student;
import com.mycompany.educationalmanagementsystem.Student.StudentService;
import com.mycompany.educationalmanagementsystem.Subjects.Subject;
import com.mycompany.educationalmanagementsystem.Subjects.SubjectService;

/**
 *
 * @author mahfoudhi
 */
public class ScoreService {
    private ScoreRepository scoreRepo;
    private StudentService studentService;
    private SubjectService subjectService;
    private static ScoreService instance;
    
    private ScoreService(ScoreRepository scoreRepo){
        this.scoreRepo = scoreRepo;
        this.studentService = StudentService.getInstance();
        this.subjectService = SubjectService.getInstance();
    }
    
    
    public static ScoreService getInstance(){
        if(instance == null){
            instance = new ScoreService(ScoreRepository.getInstance());
        }
        return instance;
    }
    
    public void addScore(Score s) throws Exception{
        
        
        try{
            Student student = studentService.getStudentById(s.getStudentId());
            if(student == null){
                throw new Exception("Student does not exist");
                
            }
            Subject subject = subjectService.getSubjectById(s.getSubjectId());
            if(subject == null){
                throw new Exception("Subject does not exist");
                
            }
            scoreRepo.createScore(s);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while adding or updating student scores");
        }
        
    }
    
    public StudentSubjectsDTO getStudentSubjectsAndScores(int id) throws Exception{
        try{
            return scoreRepo.getStudentSubjectsAndScores(id);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception(e.getMessage());
        }
    }
}
