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
           //return message if user has entered a correct username
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
               //Print message if the user has logged in successfuly
            JOptionPane.showMessageDialog(dialog,"Welcome to EasyKanban!", "EasyKanban", JOptionPane.INFORMATION_MESSAGE);
            
            //Declarations
       int numTasks ;
        String num1;
        int totalHours = 0 ;
        
        //Declaring arrays to store task data
         ArrayList<String> developer = new ArrayList<>();
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> TaskID = new ArrayList<>();
        ArrayList<Integer> TaskDuration = new ArrayList<>();
        ArrayList<String> TaskStatus = new ArrayList<>();

        //Importing scanner
        Task task= new Task();
        
            while(true){
               String menuOption= JOptionPane.showInputDialog(dialog, "Select menu option: \n1.Add taks \n2.Tasks with status 'Done' \n3.Task with longest duration \n4.Search task by name \n5.Search tasks by developer \n6.Delete task by name \n7.Show report \n8.Quit");
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
          task.setTaskDuration( taskDuration);
          
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
           task.setTaskStatus(taskStatus);
           
           //printing the task details
        JOptionPane.showMessageDialog(dialog, task.printTaskDetails(), "Task Details:", JOptionPane.INFORMATION_MESSAGE);
           
               //Returning total hours
   totalHours += task.returnTotalHours() ;
    // Populate arrays
     developer.add(developerDetails);
     taskNames.add(taskName);
     TaskID.add(task.createTaskID(taskName, taskNo, developerDetails));
      TaskDuration.add(taskDuration);
      TaskStatus.add(taskStatus);                   
        }
        
       //Printing the total hours
        JOptionPane.showMessageDialog(dialog, "Total hours across all tasks: "+ totalHours + " hours" );
          
             break;
                    case "2": // Tasks with status "Done"
                            StringBuilder doneTasks = new StringBuilder("Tasks with status 'Done':\n");
                            for (int i = 0; i < TaskStatus.size(); i++) {
                                if (TaskStatus.get(i).equals("Done")) {
                                    doneTasks.append("Developer: ").append(developer.get(i))
                                             .append("\n Task Name: ").append(taskNames.get(i))
                                             .append("\n Duration: ").append(TaskDuration.get(i)).append(" hours\n");
                                }
                            }
                            JOptionPane.showMessageDialog(dialog, doneTasks.toString());
                            break;
                            case "3": // Task with longest duration
                            int maxDuration = 0;
                            int maxIndex = -1;
                            for (int i = 0; i < TaskDuration.size(); i++) {
                                if (TaskDuration.get(i) > maxDuration) {
                                    maxDuration = TaskDuration.get(i);
                                    maxIndex = i;
                                }
                            }
                            String longestTaskReport = "Developer: " + developer.get(maxIndex) +
                                                       "\nDuration: " + TaskDuration.get(maxIndex) + " hours";
                            JOptionPane.showMessageDialog(dialog, longestTaskReport);
                            break;
                    case "4": // Search task by name
                            String searchTaskName = JOptionPane.showInputDialog(dialog, "Enter task name to search:");
                            String taskReport = "Task not found.";
                            for (int i = 0; i < taskNames.size(); i++) {
                                if (taskNames.get(i).equalsIgnoreCase(searchTaskName)) {
                                    taskReport = "Task Name: " + taskNames.get(i) + 
                                                  "\nDeveloper: " + developer.get(i) + 
                                                  "\nStatus: " + TaskStatus.get(i);
                                }
                            }
                                JOptionPane.showMessageDialog(dialog, taskReport);
                            
                                    break;
                        case "5": // Search tasks by developer
                            String searchDeveloper = JOptionPane.showInputDialog(dialog, "Enter developer's name to search:");
                            StringBuilder developerTasks = new StringBuilder("Tasks for developer " + searchDeveloper + ":\n");
                            for (int i = 0; i < developer.size(); i++) {
                                if (developer.get(i).equalsIgnoreCase(searchDeveloper)) {
                                    developerTasks.append("Task Name: ").append(taskNames.get(i))
                                                  .append("\nStatus: ").append(TaskStatus.get(i)).append("\n");
                                }
                            }
                            JOptionPane.showMessageDialog(dialog, developerTasks.toString());
                            break;        
                        
                        case "6": // Delete task by name
                            String deleteTaskName = JOptionPane.showInputDialog(dialog, "Enter task name to delete:");
                            int indexToDelete = -1;
                            for (int i = 0; i < taskNames.size(); i++) {
                                if (taskNames.get(i).equalsIgnoreCase(deleteTaskName)) {
                                    indexToDelete = i;
                                    break;
                                }
                            }
                            if (indexToDelete != -1) {
                                developer.remove(indexToDelete);
                                taskNames.remove(indexToDelete);
                                TaskID.remove(indexToDelete);
                                TaskDuration.remove(indexToDelete);
                                TaskStatus.remove(indexToDelete);
                                JOptionPane.showMessageDialog(dialog, "Task deleted successfully.");
                            } else {
                                JOptionPane.showMessageDialog(dialog, "Task not found.");
                            }
                            break;
                      case "7": // Show report
                            StringBuilder allTasks = new StringBuilder("All tasks:\n");
                            for (int i = 0; i < taskNames.size(); i++) {
                                allTasks.append("Task Name: ").append(taskNames.get(i))
                                        .append(", Developer: ").append(developer.get(i))
                                        .append(", Task ID: ").append(TaskID.get(i))
                                        .append(", Status: ").append(TaskStatus.get(i))
                                        .append(", Duration: ").append(TaskDuration.get(i)).append(" hours\n");
                            }
                            JOptionPane.showMessageDialog(dialog, allTasks.toString());
                            break;      
                            
                   case "8": 
                       //user exits the application
                       System.exit(0);
                       dialog.dispose();
                       break;
               }   
            } 
            }
            }
    }







      
        
    

