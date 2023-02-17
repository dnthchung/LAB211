/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;


import model.Task;
import view.Utility;

/**
 *
 * @author chungdoan
 */
public class ManageTask {
  Utility input = new Utility();
  ArrayList<Task> listTask = new ArrayList<> ();

  //1. Add task
  public void inputTask() {
    // input in4
    String requirementName;
    String date;
    String assignee;
    String reviewer;
    String taskType;
    double from;
    double to;

    // actions
    System.out.println("------------Add Task---------------");
    requirementName = input.getRequirementNameInput();
    taskType = input.getTaskTypeInput();
    date = input.getDate();
    from = input.getFromInput();
    to = input.getToInput(from);
    assignee = input.getAssigneeInput();
    reviewer = input.getReviewerInput();

    // add to list
    Task task = new Task(requirementName, date, taskType, from, to, assignee, reviewer);
    listTask.add(task);
  }


  //2. Selete Task
  public void deleteTask() {
    //get input id
      System.out.println("---------Del Task------");
      int id = input.getInt("Enter id: ", "Wrong1", "Wrong2", "Your input must be an integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
    //search = id
      Task task = searchTaskById(id);
    //not found
    if(task == null){
      System.out.println("Not Found!");
      System.out.println("Delete falled!");
    }else {
    //found
      listTask.remove(task);
    }
  }

  public Task searchTaskById(int id) {
    for (Task task : listTask) {
      if (task.getId() == id) {
        return task;
      }
    }
    return null;
  }

  //3.display task
  public void displayTask() {
    System.out.println("------------------------------------------------ Task -----------------------------------------------------------");
      System.out.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
      for (Task task : listTask) {
        System.out.println(task);
      }
    }

}
