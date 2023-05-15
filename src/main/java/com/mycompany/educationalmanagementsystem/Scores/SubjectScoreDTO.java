/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

/**
 *
 * @author mahfoudhi
 */
public class SubjectScoreDTO {
    private String studentName;
    private String subjectTitle;
    private int score;
    
    public SubjectScoreDTO(String studentName, String subjectTitle, int score){
        this.studentName = studentName;
        this.subjectTitle = subjectTitle;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public int getScore() {
        return score;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
