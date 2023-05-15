/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Admin;

/**
 *
 * @author mahfoudhi
 */
public class AdminService {
    private AdminRepository adminRepo;
    private static AdminService instance;
    
    private AdminService(AdminRepository adminRepo){
        this.adminRepo = adminRepo;
    }
    
    public static AdminService getInstance(){
        if(instance == null){
            instance = new AdminService(AdminRepository.getInstance());
        }
        return instance;
    }
    
    public boolean verifyAdmin(AdminLogin admin){
        AdminLogin foundAdmin = adminRepo.findByUsername(admin.getUsername());
        return !(foundAdmin == null || (foundAdmin.getPassword() == null ? admin.getPassword() != null : !foundAdmin.getPassword().equals(admin.getPassword())));
    }
    
}
