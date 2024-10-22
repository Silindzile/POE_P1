/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_p1;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class POE_P1 {

    public static void main(String[] args) {
        
         //importing scanner
     Scanner sc = new Scanner(System.in);
     Login sp = new Login();
     final JDialog dialog = new JDialog();
     dialog.setAlwaysOnTop(true);
     
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
        
        
           if(sp.loginUser(newUsername, newPassword)){ 
            JOptionPane.showMessageDialog(dialog,"Welcome to EasyKanban", "EasyKanban", JOptionPane.INFORMATION_MESSAGE);
       int numTasks ;
        String num1;
            while(true){
               String menuOption= JOptionPane.showInputDialog(dialog, "Select menu option: \n1.Add taks \n2.Show report \n3.Quit");
               switch (menuOption){
                   case "1":
                       //Add tasks logic
             
        
         num1 = JOptionPane.showInputDialog(dialog, "Enter the number of tasks to add:");
         numTasks = Integer.parseInt(num1);
       Task[] tasks = new Task[numTasks];
       int totalHours = 0;
       
        for(int i = 0; i<numTasks; i++){
            String taskName = JOptionPane.showInputDialog(dialog, "Enter task name: ");
            String taskDescription = JOptionPane.showInputDialog(dialog, "Enter task description: ");
            while(taskDescription.length()>50){
                JOptionPane.showMessageDialog(dialog,"Please enter a task description of less than 50 characters");
            }
            String developerDetails = JOptionPane.showInputDialog(dialog, "Enter developer details: ");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Enter task duration in hours: "));
            int taskNo = i=1;
            Task task= new Task(taskName, developerDetails, taskNo, taskDescription ,  taskDuration);
           tasks[i] = task;
           String taskID = task.createTaskID();
           
           String taskStatus= JOptionPane.showInputDialog(dialog, "Select task status: \n1.To Do \n2.Done \n3.Doing");
           switch(taskStatus){
               case "1": taskStatus = "To Do";
               break;
               case "2": taskStatus= "Done";
               break;
               case "3": taskStatus = "Doing";
               break;
           }
           
         
          
               }
        break;
           case "2": JOptionPane.showMessageDialog(dialog, "Coming soon");
                    break;   
                   case "3": 
                       System.exit(0);
                       dialog.dispose();
                       break;
           }            
        
        
    }
    }  
    }
}
      
        
    

