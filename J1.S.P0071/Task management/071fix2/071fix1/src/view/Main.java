/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Validate;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        ViewUser vUser = new ViewUser();
        Validate vali = new Validate();
        while (true) {
            vUser.menu();
            int choice = vali.getInt("Enter your choice: ", 1, Integer.MAX_VALUE, "wrong input");
            switch (choice) {
                case 1:
                    vUser.add();
                    break;
                case 2:
                    vUser.delete();
                    break;
                case 3:
                    vUser.display();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
