/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_p1;
import java.util.*;
/**
 *
 * @author RC_Student_lab
 */
public class POE_P1 {

    public static void main(String[] args) {
        
         //importing scanner
     Scanner sc = new Scanner(System.in);
     Login sp = new Login();
     
     //Prompting the user to enter details as they are being registered
        System.out.println("REGISTER");
        System.out.println("Enter username:");
       String username = sc.next();
       if (sp.checkUserName(username)){
           System.out.println("Username correctly formatted");
       }
        
        System.out.println("Enter password:");
     String password = sc.next();
       if (sp.checkPasswordComplexity(password)){
           System.out.println("Password correctly formatted");
       }
       
        System.out.println("Enter name:");
        String firstname = sc.next();
        System.out.println("Enter last name:");
        String lastname = sc.next();
        
          //After registering 
        String registrationMessage = sp.registerUser(username, password, firstname, lastname);
        System.out.println(registrationMessage);
        
        //Prompting the user to enter details as they login
      
        System.out.println("LOGIN");
        System.out.println("Enter username:");
         String newUsername = sc.next();
        System.out.println("Enter password:");
       String newPassword = sc.next();
        //Login execusion
      boolean login = sp.loginUser(newUsername, newPassword);
        System.out.println(login);
        String success = sp.returnLoginStatus();
        System.out.println(success);
        
       
     }
     
}
        
        
    

