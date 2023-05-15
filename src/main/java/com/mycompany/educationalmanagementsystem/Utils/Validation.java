/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mahfoudhi
 */
public final class Validation {
    
    private Validation(){}
    
    public static boolean isAlphabetic(String str){
        boolean isValid = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    
    public static boolean isEmail(String email){
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
