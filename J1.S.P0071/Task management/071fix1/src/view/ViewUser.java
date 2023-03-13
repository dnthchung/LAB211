/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskManage;
import controller.Validate;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import model.Task;

/**
 *
 * @author chungdoan
 */
public class ViewUser {
    static Scanner sc = new Scanner(System.in);
    Validate v = new Validate();
    TaskManage m = new TaskManage();

    public void menu() {
        System.out.println("========== Task Program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. exit");

    }

    public void add() throws ParseException {
        System.out.println("========== Add Task ==========");
        String name = v.getString("Enter name: ");
        int TypeId = v.getInt("Enter Type Task: ", 1, 4, "Plz input integer number from 1 to 4");
        Date date = v.getDate("Enter date: ");
        double from = v.getDouble("Enter from: ", 8, 17, "Plz input must be from 8 to 17,5");
        double to = v.getDouble("Enter to: ", from + 0.5, 17.5, "Plz input must be from 8 to 17,5");
        String assignee = v.getString("Enter assignee: ");
        
        String reviewer = v.getString("Enter reviewer: ");
        Task task = new Task(0, TypeId, name, date, from, to, assignee, reviewer);
        m.addTask(name, assignee, reviewer, TypeId, date, from, to);
        System.out.println("add successfully");
    }

    public void delete() {
        System.out.println("========== Delete Task ==========");
        String id = v.getString("Enter the ID want to delete: ");
        m.deleteTask(id);
    }

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
