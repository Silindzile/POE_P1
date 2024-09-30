/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_p1;



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
     
    
    
    //Boolean used to check username
    public boolean checkUserName(String username){
     return username.contains("_")&& username.length()<= 5;
    }
    //Boolean used to check password
    public boolean checkPasswordComplexity(String password){
        return password.length()== 8 && password.matches(".*[A-Z].*")&& password.contains("1")||password.contains("2")||password.contains("3")||password.contains("4")||password.contains("5")||password.contains("6")||password.contains("7")||password.contains("8")||password.contains("9")||password.contains("0")&& password.matches(".*[^a-zA-Z0-9].*");
        
    }
    //register user
    public String registerUser(String username, String password, String firstname, String lastname){
        if(!checkUserName(username)){
           return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        }
        
      
       if(!checkPasswordComplexity(password)){
            return "Password incorrectly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        }
        
       
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
      
       
        return "User has been registered successfully";
    }
     
        
    //login user
    public boolean loginUser(String username, String password){
      return this.username != null && this.username.equals(username)&&this.password !=null&& this.password.equals(password);
    }
    
    //method to return login status 
    public String returnLoginStatus(){
       if(username.equals(this.username)&& password.equals(this.password)){
           return "Welcome " + firstname+" "+ lastname + ", it is great to see you again";
           
       }
       
       else
       {
           return "Username or password incorrect, please try again";
       } 
    }
    
    
}
