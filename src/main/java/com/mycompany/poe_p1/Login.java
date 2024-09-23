/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_p1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
        //Declarations
     private String username; 
     private String password;
     private String firstname;
     private String lastname;
    
     //Getters and setters
     public void setUserName(String i){
         username= i;
     }
     
     public String getUserName(){
         return username;
     }
      public void setPassword(String j){
         password = j;
     }
     
     public String getPassword(){
         return password;
     }
      public void setFirstName(String k){
         firstname= k;
     }
     
     public String getFirstName(){
         return firstname;
     }
      public void setLastName(String l){
         lastname= l;
     }
     
     public String getLastName(){
         return lastname;
     }
      
     
    public boolean checkUserName(){
      if(username.contains("_")&& username.length()<= 5){
          //return statements
        return true;
    }
        else{
           return false;
        }  
       
        
    }
    public boolean checkPasswordComplexity(){
        if(password.length()== 8 && password.matches(".*[A-Z].*")&& password.contains("1||2||3||4||5||6||7||8||9||0")&& password.matches(".*[^a-zA-Z0-9].*") ){
            return true;   
        }
        else{
            return true;
        }
        
    }
    public String registerUser(){
        if(username.contains("_")&& username.length()<= 5){
           return "Username successfully captured";
    }
        else if(password.matches(".*[^a-zA-Z0-9].*") && password.contains("1||2||3||4||5||6||7||8||9||0") && password.length() == 8 && password.matches(".*[A-Z].*")){
           return "Password correctly formatted";
       }
        else{
            return "Username and password incorrectly formatted" ;
        }
    
        
    }
    public boolean loginUser(){
      if(username.equals("sli_")&& password.equals("Zitsi20@")){
          return true;
      }
      else{
          return false;
      }
    }
    public String returnLoginStatus(){
       if(username.equals("sli_") && password.equals("Zitsi20@")){
           return "Welcome Silindzile Mathenjwa, it is great to see you again";
       }else{
           return "Username or password incorrect, please try again";
       } 
    }
    public void display(){
       System.out.println(registerUser()+checkUserName()+ checkPasswordComplexity()+ loginUser() + returnLoginStatus());
    }
    
}
