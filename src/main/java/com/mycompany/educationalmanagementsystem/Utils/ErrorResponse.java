/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educationalmanagementsystem.Utils;

/**
 *
 * @author mahfoudhi
 */
public class ErrorResponse {
    private int hasError;
    private String errorMsg;
    
    public ErrorResponse(int err, String errMsg){
        this.hasError = err;
        this.errorMsg = errMsg;
    }

    public int getHasError() {
        return hasError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setHasError(int hasError) {
        this.hasError = hasError;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
