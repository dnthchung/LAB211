/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Student;

/**
 *
 * @author chungdoan
 */
public class ManageStudent {

    //create list
    private List<Student> listStudent = new ArrayList<>();
//    //get list Student
//    public List<Student> getListStudent(){
//        return listStudent;
//    }
    
    //add student 
    public void addStudent(Student student) {
        listStudent.add(student);
    }
    
    //sort student by name
    public void sort(){
        Collections.sort(listStudent, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    //Function check yes no
    public boolean checkYesNo() {
        String result = Utility.getString("Do you want to enter more student information?(Y/N):", "Must be Y or N", Utility.REGEX_YN);
        return result.equalsIgnoreCase("y");
    }

    //Function display
    public void display() {
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println("-------------Student"+ (i+1) +"-------------");
            System.out.println(listStudent.get(i));
        }
    }
    
}


        //so sánh hai chuỗi đưa ra dựa trên nội dung của chuỗi 
        //không phân biệt chữ hoa và chữ thường. 
        //Nếu hai chuỗi khác nhau nó trả về false. 
        //Nếu hai chuỗi bằng nhau nó trả về true.