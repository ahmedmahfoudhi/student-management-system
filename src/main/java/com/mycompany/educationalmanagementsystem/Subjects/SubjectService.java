/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Subjects;

import java.util.List;

/**
 *
 * @author mahfoudhi
 */
public class SubjectService {
    private static SubjectService instance;
    private static SubjectRepository subjectRepo;
    
    private SubjectService(SubjectRepository studentRepo){
        SubjectService.subjectRepo = studentRepo;
    }
    
    public static SubjectService getInstance(){
        if(instance != null) return instance;
        instance = new SubjectService(SubjectRepository.getInstance());
        return instance;
    }
    
    public List<Subject> getAll() throws Exception{
        try{
            return subjectRepo.getAll();
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while getting subjects");
        }
    }
    
    public Subject getSubjectById(int id) throws Exception{
        try{
            return subjectRepo.getSubjectById(id);
        }catch(Exception e){
            System.out.println(e);
            throw new Exception("Error while getting subject by id");
        }
    }
}
