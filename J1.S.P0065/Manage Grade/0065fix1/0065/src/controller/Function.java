/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author chungdoan
 */
public class Function {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_YN = "[yYnN]";

    List<Student> listStudent = new ArrayList<>();
//___________________________________________________________   
    //Function1: Input student information
    public Student createStudent(String name, String classes, double math, double physical, double chemistry) {
        Student student = new Student(name, classes, math, physical, chemistry);
        return student;
    }
//___________________________________________________________   
    //Function 2: Student classification.
    public List<Student> getListStudent() {
        return listStudent;
    }
    public void addStudent(Student student) {
        listStudent.add(student);
    }
//___________________________________________________________    
    //Function3: Student Type Statistics
    public HashMap<String, Double> getPercentTypeStudent() {
        HashMap<String, Double> hashMap = new HashMap<>();
        hashMap.put("A", 0.0);
        hashMap.put("B", 0.0);
        hashMap.put("C", 0.0);
        hashMap.put("D", 0.0);
        //duyệt qua danh sách sinh viên và tăng giá trị tương ứng
        for (Student student : listStudent) {
            double value = hashMap.get(student.getType()).doubleValue() + 1;
            hashMap.replace(student.getType(), value);
        }
        //HashMap chứa tỷ lệ phần trăm cho mỗi loại sinh viên được trả về.
        return hashMap;
    }
    
//___________________________________________________________  
    //check yes or no 
    static boolean checkYesNo() {
        String result = getString("Do you want to enter more student information?(Y/N):",
                "Must input y or n", REGEX_YN);
        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

//___________________________________________________________  
   //get double input
    public static double getDouble(String message, String firstError, String secondError, String thirdError, double min, double max) {
        //loop unti get number double
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);
                //if number in range => return number
                //else => tell error
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }

            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }
//___________________________________________________________
    //check string input
    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }

    }


    
    
    
    
    
}
