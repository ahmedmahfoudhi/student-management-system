/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

/**
 *
 * @author mahfoudhi
 */
public class Score {
    private int studentId;
    private int subjectId;
    private int score;
    
    public Score(int studentId, int subjectId, int score){
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getScore() {
        return score;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
