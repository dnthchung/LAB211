/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import controller.Utility;
import model.Student;

/**
 *
 * @author chungdoan
 */
public class View {
    ManageStudent manage = new ManageStudent();
       
    //function add input Student
    void inputStudent() {
        System.out.println("====== Collection Sort Program ======");
        while (true) {            
            System.out.println("Please input student information.");
            //input name, classes, mark 
            String name = Utility.getString("Name: ", "Name must be letter", Utility.REGEX_NAME);
            String classes = Utility.getString("Classes: ", "Classes must be letter or digit", Utility.REGEX_CLASSES);
            float mark = Utility.getFloat("Mark: ", "Mark must be real number", 0, Float.MAX_VALUE);
            
            //create instance
            Student student = new Student(name, mark, classes);
            
            //add to list
            manage.addStudent(student);
            
            //continue ?
            //if check yes no function = False => dont want to contnue => break
            if(!manage.checkYesNo() == true) {
                break;
            }
        }
    }

    //sort student by name
    void sortStudent() {
        manage.sort();
    }

    //display list student
    void displayStudent() {
        manage.display();
    }

    
}
