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
    private String taskID;
    
    
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskNo){
        this.taskDescription = taskDescription;
        this.taskName= taskName;
        this.developerDetails= developerDetails;
        this.taskNo = taskNo;
        this.taskID = createTaskID();
         this.taskDuration = taskDuration;
         
    }
    //Method to check task description if it has 50 or less characters
    public boolean checkTaskDescription(String taskDescription){
         this.taskDescription = taskDescription;
        return taskDescription.length() <=50;
    }
    
    //Method to create Task ID
    public String createTaskID(){
        
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNo + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        
    }
    
    //Method to return task full details of each task
    public String printTaskDetails(){
        
        //return message
        return "Task Name= "+taskName + "\n"+ "Task Number= " + taskNo+"\n"+ "Task Description= "+ taskDescription +"\n" +"Developer Details= "+ developerDetails + "\n"+ "Task Duration= " + taskDuration + "\n" + "Task ID= " + createTaskID()+"\n"+"Task Status= "  ; 
    }
    
    //Method that returns the total hours spent on the tasks
    public int returnTotalHours(){
        return taskDuration;
    }
    
    
}
