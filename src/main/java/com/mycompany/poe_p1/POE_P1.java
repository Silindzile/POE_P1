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
     
     //Prompting the user to enter details
        System.out.println("Enter username:");
        String username = sc.next();
        System.out.println("Enter password:");
       String password = sc.next();
        System.out.println("Enter name:");
        String firstname = sc.next();
        System.out.println("Enter last name:");
        String lastname = sc.next();
        
        
        Login sp = new Login();
        sp.setUserName("sli_");
        sp.setPassword("Zitsi20@");
        sp.setFirstName("Silindzile");
        sp.setLastName("Mathenjwa");
        sp.checkPasswordComplexity();
        sp.checkUserName();
        sp.loginUser();
        sp.registerUser();
        sp.returnLoginStatus();
        sp.display();
        

     }
     
}
        
        
    

