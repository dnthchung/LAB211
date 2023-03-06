/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;

/**
 *
 * @author chungdoan
 */
public class Manage {
        Function function = new Function();
        
    public void inputData() {
        while (true) {            
            //input data
            String name = Function.getString("Name: ", "Name must be letters or digits",Function.REGEX_STRING);
            String classes = Function.getString("Classes: ", "Classes must be letters or digits",Function.REGEX_STRING);
            double math = Function.getDouble("Math: ", "Math is less than equal ten", "Maths is greater than equal zero", "Maths is digit", 0, 10);
            double chemistry = Function.getDouble("chemistry: ", "chemistry is less than equal ten", "chemistry is greater than equal zero", "chemistry is digit", 0, 10);
            double physical = Function.getDouble("physical: ", "physical is less than equal ten", "physical is greater than equal zero", "physical is digit", 0, 10);

            //create student
            Student student = function.createStudent(name, classes, math, physical, chemistry);
            //add to list
            function.addStudent(student);
            //check continue
            if (Function.checkYesNo() == false) {
                break;
            }
        }
        
    }
// Student classification.
    public void displayStudentInformation() {
        List<Student> listStudent = function.getListStudent();
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println("------ Student " + (i + 1) + " Info ------");
            listStudent.get(i).display();
        }
    }

    public void displayClassification() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

