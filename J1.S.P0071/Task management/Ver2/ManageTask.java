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
    ArrayList<Task> listTask = new ArrayList<>();

    public void inputTask() {
        //input information
        String requirementName, date, assignee, reviewer;
        String taskType;
        double from, to;

        System.out.println("------------Add Task---------------");
        requirementName = input.getRequirementNameInput();
        taskType = input.getTaskTypeInput();
        date = input.getDate();
        from = input.getFromInput();
        to = input.getToInput(from);
        assignee = input.getAssigneeInput();
        reviewer = input.getReviewerInput();

        //check duplicate from to date asignee date
        if (checkDuplicate(date, assignee, from, to)) {
            System.out.println("Overlap!!");
        } else {
            Task task = new Task(requirementName, date, taskType, from, to, assignee, reviewer);
            listTask.add(task);
        }

    }

    //check overlap
    private boolean checkDuplicate(String date, String assignee, double from, double to) {
        for (Task task : listTask) {
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }else if (from == task.getFrom()) {
                    return true;
                }else if (from > task.getFrom() && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteTask() {
        //input id
        System.out.println("---------Del Task------");
        int id = input.getInt("Enter id: ", "Wrong", "Wrong", "Wrong", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //search task by id
        Task task = searchTaskById(id);
        //not found
        if (task == null) {
            System.out.println("NOT FOUND !!");
            System.out.println("DELETE FAILED !!");
        //found
        } else {
            listTask.remove(task);
        }

    }

    public void displayTask() {
        System.out.println("------------------------------------------------ Task -----------------------------------------------------------");
        System.out.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : listTask) {
            System.out.println(task);
        }
    }

    private Task searchTaskById(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

}
