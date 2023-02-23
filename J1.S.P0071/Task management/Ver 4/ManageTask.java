/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;


import model.Task;


/**
 *
 * @author chungdoan
 */
public class ManageTask {

  ArrayList<Task> listTask = new ArrayList<> ();
  
  public List<Task> getListTask(){
      return listTask;
  }

  //1. Add task
//  public int addTask(String requirement, String taskType, String date, double from, double to, String assignee, String reviewer) {
//      Task task = new Task(requirement, taskType, date, from, to, assignee, reviewer);
//      //add to list
//      listTask.add(task);
//      //return
//      return task.getId();
//  }
  
  
  //1. add task
    public int addTask(String requirement, String taskType, String date, double from,
            double to, String assignee, String reviewer) {

        //check duplicate => duplicate => return -1 
        if (checkOverlaps(date, assignee, from, to)) {
            return -1;
        } //else return id
        else {
            //create bien instance
            Task task = new Task(requirement, taskType, date, from, to, assignee, reviewer);
            //add to list
            listTask.add(task);
            //return
            return task.getId();
        }
    }

    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean checkOverlaps(String date, String assignee, double from, double to) {

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : listTask) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from2 < from1 && to2 > from1
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                //if from2 = from1 and to2 > from1 => return true
                if (from == task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                // if from2 > from1 and to2 >= to1  and from2 < to1=> return true
                if (from > task.getFrom() && to >= task.getTo()
                        && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }
  
  //3. ham thuat toan search by id
  public Task searchTaskById(int id) {
    for (Task task : listTask) {
      if (task.getId() == id) {
        return task;
      }
    }
    return null;
  }



}
