/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Locale;
import model.EBank;
import view.Inputted;


/**
 *
 * @author chungdoan
 */
public class Main {  
    public static void main(String[] args) { // Tạo menu cho phép người dùng nhập dữ liệu
        EBank tpbank = new EBank();
        while (true) {
            //display menu:
            System.out.println("-------Login Program-------\n"
                    + "1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit");
            //get input from user
            int choice;
            choice = Inputted.inputInt("Enter your choice: ", 1, 3);
            switch (choice) {
                case 1:
                    tpbank.setLocate(new Locale("vi", "VN"));
                    break;
                case 2:
                    tpbank.setLocate(Locale.ENGLISH);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
            Login.loginDisplay(tpbank);
        }
    }  
    
}
