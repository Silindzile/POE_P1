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
       System.out.println("====REGISTER====");
        System.out.println("Enter first name:");
        String firstname = sc.next();
        System.out.println("Enter last name:");
        String lastname = sc.next();
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
       
       
        
          //calling the methods after a user registers
        String registrationMessage = sp.registerUser(username, password, firstname, lastname);
        System.out.println(registrationMessage);
        
        //Prompting the user to enter details as they login
        System.out.println("====LOGIN====");
        System.out.println("Enter username:");
         String newUsername = sc.next();
        System.out.println("Enter password:");
       String newPassword = sc.next();
       
        //Login method that logs the user in and returns registration message
      boolean login = sp.loginUser(newUsername, newPassword);
        System.out.println(login);
        String success = sp.returnLoginStatus();
        System.out.println(success);
        
        
           if(sp.loginUser(newUsername, newPassword)){ 
               //Print message if the user 
            JOptionPane.showMessageDialog(dialog,"Welcome to EasyKanban!", "EasyKanban", JOptionPane.INFORMATION_MESSAGE);
            
            //Declarations
       int numTasks ;
        String num1;
        int totalHours = 0 ;
        
        //Importing scanner
        Task task= new Task();
        
            while(true){
               String menuOption= JOptionPane.showInputDialog(dialog, "Select menu option: \n1.Add taks \n2.Show report \n3.Quit");
               switch (menuOption){
                   case "1":
                       //Add tasks logic
             
        //Prompting the user to enter the number of tasks
         num1 = JOptionPane.showInputDialog(dialog, "Enter the number of tasks to add:");
         numTasks = Integer.parseInt(num1);
         
         //Create array to store task objects
       Task[] tasks = new Task[numTasks];
       
       //Loop to input and create tasks
        for(int i = 0; i<numTasks; i++){
          
            //Prompt user to input task details
         String taskName = JOptionPane.showInputDialog(dialog, "Enter task name: ");
          String taskDescription = JOptionPane.showInputDialog(dialog, "Enter task description: ");
          
           //checking if task description is greater than 50 characters
           while(!task.checkTaskDescription(taskDescription)){
               JOptionPane.showMessageDialog(dialog, "Please enter task description of les than 50 characters");
               taskDescription = JOptionPane.showInputDialog(dialog, "Enter task description: ");
           }if (task.checkTaskDescription(taskDescription)){
               //Return message
              JOptionPane.showMessageDialog(dialog, "Task description successfully captured");
               
           }
           
           //Pompt user to enter developer's details
        String developerDetails = JOptionPane.showInputDialog(dialog, "Enter developer's details(First name and surname): ");
        //create task object and store in array
       tasks[i] = task; 
          int taskNo = i;
       
       
         //Prompting the user to enter task duration
          int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Enter task duration in hours: "));
          task.setTaskDuration(taskDuration);
          
           //print the ask ID
         JOptionPane.showMessageDialog(dialog, task.createTaskID( taskName, taskNo, developerDetails), ">>>>TASK ID<<<<", JOptionPane.INFORMATION_MESSAGE);
          
        //Input task status with options
        String taskStatus= JOptionPane.showInputDialog(dialog, "Select task status: \n1.To Do \n2.Done \n3.Doing");
           switch(taskStatus){
               case "1": taskStatus = "To Do";
               break;
               case "2": taskStatus= "Done";
               break;
               case "3": taskStatus = "Doing";
               break;
           }
        JOptionPane.showMessageDialog(dialog, task.printTaskDetails(taskName,  taskNo, taskDescription,  developerDetails,  taskDuration)+ taskStatus, "Task Details:", JOptionPane.INFORMATION_MESSAGE);
           
               //Returning total hours
   totalHours += task.returnTotalHours() ;
        }
        
       //Printing the total hours
        JOptionPane.showMessageDialog(dialog, "Total hours across all tasks: "+ totalHours );
               
               
        break;
        //Option 2 which displays the a certain message
           case "2": JOptionPane.showMessageDialog(dialog, "Coming soon");
                    break; 
               
                   case "3": 
                       //user exits the application
                       System.exit(0);
                       dialog.dispose();
                       break;
           }            
        
        
            }
           }
}
}    


      
        
    

