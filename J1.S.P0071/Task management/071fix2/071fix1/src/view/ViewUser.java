/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskManage;
import controller.Validate;
import java.util.Date;
import java.util.Scanner;
import model.Task;

/**
 *
 * @author chungdoan
 */
public class ViewUser {
    //Function details
    static Scanner sc = new Scanner(System.in);
    Validate v = new Validate();
    TaskManage m = new TaskManage();

    //Function 1: Add Task
    public void menu() {
        System.out.println("========== Task Program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. exit");

    }
//______________________________________________________________________________
    //Function 2: Perform function based on the selected option.
    //Option 1:
    public void add() {
        
        System.out.println("========== Add Task ==========");

        String name = v.getString("Enter name: ","wrong input","^[a-zA-Z ]+$");        
        int TypeId = v.getInt("Enter Type Task: ", 1, 4, "Plz input integer number from 1 to 4");
        String date = v.getDate();
        double from = v.getDouble("Enter from: ", 8, 17, "Plz input must be from 8 to 17,5");        
        double to = v.getDouble("Enter to: ", from + 0.5, 17.5, "Plz input must be from 8 to 17,5");        
        String assignee = v.getString("Enter assignee: ","input must be word","^[a-zA-Z]+$");        
        String reviewer = v.getString("Enter reviewer: ","input must be word","^[a-zA-Z]+$");
        
        //Add a Task on the program
        Task task = new Task(0, TypeId, name, date, from, to, assignee, reviewer);
        m.addTask(name, assignee, reviewer, TypeId, date, from, to);
        
        System.out.println("add successfully");
    }
//______________________________________________________________________________
    //Option 2:
    public void delete() {
        System.out.println("========== Delete Task ==========");
        String id = v.getString("Enter the ID want to delete: ","wrong input","\\d");
        m.deleteTask(id);
    }
//______________________________________________________________________________
    //Option 3:
    public void display() {
        if (m.getdataTask().isEmpty()) {
            System.out.println("Database is Empty");
        } else {
            System.out.println("----------------------Task--------------------");
            System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "TaskType", "Date", "Time", "Assignee", "Reviewer");

            for (int i = 0; i < m.getdataTask().size(); i++) {
                System.out.println(m.getdataTask().get(i));
            }
        }

    }
}
