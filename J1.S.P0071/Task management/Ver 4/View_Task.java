/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageTask;
import java.text.SimpleDateFormat;
import model.Task;
import static view.Utility.scanner;

/**
 *
 * @author chungdoan
 */
public class View_Task {

    ManageTask manage = new ManageTask();

    void inputTask() {
        //input properties
        System.out.println("------------Add Task---------------");
        String requirementName = getRequirementNameInput();
        String taskType = getTaskTypeInput();
        String date = getDate();
        double from = getFromInput();
        double to = getToInput(from);
        String assignee = getAssigneeInput();
        String reviewer = getReviewerInput();

        //add Task 
        int result = manage.addTask(requirementName, taskType, date, from, to, assignee, reviewer);
        //if result = -1 => overlaps task
        if (result == -1) {
            System.out.println("Overlaps task!!");
        } 
        // not equal -1 => add successfull
        else {
            System.out.println("Add successful!!");
        }
    }
    
    //check date input
    public String getDate() {
        while (true) {
            System.out.print("Enter date: ");
            String input = scanner.nextLine().trim();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
                //check format    
            } else {
                //check date valid
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                try {
                    if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
                        System.out.println("Date must focus in format dd-MM-yyyy");
                    } else {
                        dateFormat.parse(input.trim());
                        return input;
                    }
                } catch (Exception e) {
                    System.out.println("Date does not exist !!");
                }
            }
        }

    }
    
    // Ham nhap input
    // get requirement Name
    public String getRequirementNameInput() {
        String requirementName = Utility.getString("Requiment name: ", "Your input must be String", "[a-zA-Z ]+");
        return requirementName;
    }

    // get task type
    public String getTaskTypeInput() {
        String taskType = Utility.getString("Task type: ", "Your input must be [Code - Test - Design or Review].", "Code|Test|Design|Review");
        return taskType;
    }

    // get from
    public double getFromInput() {
        double from = Utility.getDouble("Enter from: ", "Input must >= 8", "Input must =< 17", "Input must be number!!", 8, 17);
        return from;
    }

    // get to
    // getToInput phai truyen them from de dam bao diu kien "to" > "from"
    public double getToInput(double from) {
        double to = Utility.getDouble("Enter to: ", "Input must >= 8 ", "Input must =< 17.5", "Input must be number!!", from + 0.5, 17.5);
        return to;
    }

    // get assignee
    public String getAssigneeInput() {
        String assignee = Utility.getString("Enter assignee: ", "Input must be String without symbol!", Utility.REGEX_STRING);
        return assignee;
    }

    // get reviewer
    public String getReviewerInput() {
        String reviewer = Utility.getString("Enter reviewer: ", "Input must be String without symbol!", Utility.REGEX_STRING);
        return reviewer;
    }
    
    
    //2. Delete Task
    public void deleteTask() {
        //get input id
        System.out.println("---------Del Task------");
        int id = Utility.getInt("Enter id: ", "Wrong1", "Wrong2", "Your input must be an integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //search = id
        Task task = manage.searchTaskById(id);
        //not found
        if (task == null) {
            System.out.println("Not Found!");
            System.out.println("Delete falled!");
        } else {
            //found
            manage.getListTask().remove(task);
        }
    }
    
    //3.display task
    public void displayTask() {
        System.out.println("------------------------------------------------ Task -----------------------------------------------------------");
        System.out.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }
    
}
