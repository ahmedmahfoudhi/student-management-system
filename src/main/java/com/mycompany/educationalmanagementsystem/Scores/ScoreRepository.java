/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

import com.mycompany.educationalmanagementsystem.db.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahfoudhi
 */
public class ScoreRepository {
    private Connection conn;
    private static ScoreRepository instance;
    
    private ScoreRepository(Connection conn){
        this.conn = conn;
    }
    
    public static ScoreRepository getInstance(){
        if(instance == null){
            instance = new ScoreRepository(ConnectionDB.getConnection());
        }
        return instance;
    }
    
    public void deleteStudentScores(int studentId) throws Exception{
        String sql = "DELETE from scores where student_id = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,studentId);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            
            throw e;
        }
        
    }
    
    public void createScore(Score s) throws Exception{
        
        
        String sql = "INSERT into scores (student_id, subject_id,score) values (?,?,?)";
        try{
            deleteStudentScores(s.getStudentId());
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,s.getStudentId());
            statement.setInt(2,s.getSubjectId());
            statement.setInt(3,s.getScore());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            
            System.out.println(e.toString());
            throw e;
        }
        
    }
    
    
    public void updateStudentScoreForSubject(Score s){
        String sql = "UPDATE scores SET score = ? WHERE subject_id = ? and student_id = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,s.getScore());
            statement.setInt(2,s.getSubjectId());
            statement.setInt(3,s.getStudentId());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public StudentSubjectsDTO getStudentSubjectsAndScores(int id) throws Exception{
        StudentSubjectsDTO resultList = new StudentSubjectsDTO(id);
        String sql = "SELECT s.subject_id, st.student_id, sc.score " +
                     "FROM score sc " +
                     "JOIN subject s ON sc.subject_id = s.subject_id " +
                     "JOIN student st ON sc.student_id = st.student_id " +
                     "GROUP BY  st.student_id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int subjectId = rs.getInt("subject_id");
                int score = rs.getInt("score");
                resultList.addSubjectScore(subjectId, score);
            }
        } catch (SQLException ex) {
            // handle exception
            throw new Exception("Error while getting student subjects and scores");
        }
        return resultList;
    }
    
    public List<SubjectScoreDTO> findHighestScoringStudentsBySubject() {
        List<SubjectScoreDTO> resultList = new ArrayList<>();
        String sql = "SELECT s.subject_name, st.student_name, sc.score " +
                     "FROM score sc " +
                     "JOIN subject s ON sc.subject_id = s.subject_id " +
                     "JOIN student st ON sc.student_id = st.student_id " +
                     "WHERE sc.score = (" +
                     "  SELECT MAX(score) FROM score sc2 WHERE sc2.subject_id = sc.subject_id" +
                     ") " +
                     "ORDER BY s.subject_name ASC, sc.score DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String subjectName = rs.getString("subject_name");
                String studentName = rs.getString("student_name");
                int score = rs.getInt("score");
                resultList.add(new SubjectScoreDTO(subjectName, studentName, score));
            }
        } catch (SQLException ex) {
            // handle exception
        }
        return resultList;
    }
}

