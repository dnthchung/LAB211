/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Task;

/**
 *
 * @author chungdoan
 */
public class TaskManage {
    List<Task> ListTask = new ArrayList<>();

    public int addTask(String name, String assignee, String reviewer, int TaskType, Date date, double PlanFrom, double PlanTo) {
        int id = 1;
        if (ListTask.isEmpty()) {
            id = 1;
        } else {
            id = ListTask.get(ListTask.size() - 1).getId() + 1;
        }
        ListTask.add(new Task(id, TaskType, reviewer, date, PlanFrom, PlanTo, assignee, reviewer));
        return id;
    }

    public void deleteTask(String id) {
        int index = 0;
        boolean check = false;
        for (int i = 0; i < ListTask.size(); i++) {
            if (id.equals(ListTask.get(i).getId())) {
                index = i;
                check = true;
                break;
            }
        }
        if (check) {
            ListTask.remove(id);
        }
    }

    public List<Task> getdataTask() {
        return ListTask;
    }



}
