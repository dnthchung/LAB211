/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chungdoan
 */
public class Task {

    private static int auto_tang = 1;
    private int id;
    private String name, date;
    private int taskType;
    private double from, to;
    private String assignee, reviewer;

    public Task() {
    }
    
    //phai xoa int id o trong phan tut truyen vao
    public Task(String name, String date, int taskType, double from, double to, String assignee, String reviewer) {
        this.id = auto_tang++;
        this.name = name;
        this.date = date;
        this.taskType = taskType;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getTaskType() {
        return taskType;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    //sd switch case
    public String getStringTaskType() {
        String result = null;
        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;

    }
    public double getTimeInput(double from, double to){
        double time = to - from ;
        return time;
    }
    
    /**
     * "ID","Name","Task Type","Date","Time","Assignee","Reviewer")
     * @return "ID","Name","Task Type","Date","Time","Assignee","Reviewer")
     */
    @Override
    public String toString() {
//  "ID","Name","Task Type","Date","Time","Assignee","Reviewer");
        return String.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s "
                , id, name, getStringTaskType(), date, getTimeInput(from, to), assignee, reviewer);
    }

}
