/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_p1;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    //Declarations
    private String taskName;
    private String developerDetails;
    private int taskNo;
    private String taskDescription;
    private int taskDuration;
    private String taskStatus;
  
    //Method to check task description if it has 50 or less characters
    public boolean checkTaskDescription(String taskDescription){
         this.taskDescription = taskDescription;
        return taskDescription.length() <=50;
    }
    
    //Method to create Task ID
    public String createTaskID( String taskName,int taskNo, String developerDetails ){
          this.taskName = taskName;
        this.taskNo = taskNo;
        this.developerDetails = developerDetails;
        
        //return message
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNo + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }
    
    //setter for task Status
    public void setTaskStatus(String taskStatus){
        this.taskStatus = taskStatus;
    }
   
    //setter for task duration
    public void setTaskDuration(int taskDuration){
      this.taskDuration = taskDuration;  
    }
    
    //Method to return full details of each task
    public String printTaskDetails(String taskName, int taskNo, String taskDescription, String developerDetails, int taskDuration){
         
        //return message
        return "Task Status: " + taskStatus+ "\n"+ "Developer's Details: "+ developerDetails +"\n"+ "Task Number: " + taskNo+"\n" +  "Task Name: "+taskName + "\n"+ "Task Description: "+ taskDescription +"\n" +  "Task ID: " + createTaskID( taskName, taskNo, developerDetails )+"\n"+  "Task Duration: " + taskDuration + " hours"  ; 
    }
    
    //Method that returns the total hours spent on the all the tasks
    public int returnTotalHours(){
      return taskDuration;
    }
    
}
