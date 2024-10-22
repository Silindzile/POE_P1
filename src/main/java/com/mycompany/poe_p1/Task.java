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
    private String taskName;
    private String developerDetails;
    private int taskNo;
    private String taskDescription;
    private int taskDuration;
    
    public Task(String taskName, String developerDetails, int taskNo,  String taskDescription,  int taskDuration){
    this.taskDescription = taskDescription; 
    this.developerDetails = developerDetails;
    
    this.taskNo = taskNo;
    this.taskName = taskName;
    this.taskDuration = taskDuration;
    
    }
    
    public boolean checkTaskDescription(String taskDescription){
        return taskDescription.length() <=50;
    }
    public String createTaskID(){
        
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNo + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        
    }
    
    public String printTaskDetails(){
        return "Task Name= "+taskName + "\n"+ "Task Number= " + taskNo+"\n"+ "Task Description= "+ taskDescription +"\n" +"Developer Details= "+ developerDetails + "\n"+ "Task Duration= " + taskDuration + "\n" + "Task ID= " + createTaskID()+"\n"+"Task Status= "   ; 
    }
    
    public int returnTotalHours(){
        return taskDuration;
    }
    
    
}
