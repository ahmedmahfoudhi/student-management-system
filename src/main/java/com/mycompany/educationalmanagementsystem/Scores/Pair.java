/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Scores;

/**
 *
 * @author mahfoudhi
 * @param <T0>
 * @param <T1>
 */
public class Pair<T0, T1> {
    T0 first;
    T1 second;
    public Pair(T0 f, T1 s){
        this.first = f;
        this.second = s;
    }
    
    public T0 getFirst(){
        return first;
    }
    
    public T1 getSecond(){
        return second;
    }
    
    public void setFirst(T0 f){
        first = f;
    }
    
    public void setSecond(T1 s){
        second = s;
    }
}
