/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manage;

/**
 *
 * @author chungdoan
 */
public class Main {
    public static void main(String[] args) {
        Manage manage = new Manage();
        //input data
        manage.inputData();

        //display student information
        manage.displayStudentInformation();

        //display classification infomation
        manage.displayClassification();

    }
}
