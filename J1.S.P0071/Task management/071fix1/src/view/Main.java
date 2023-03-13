/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        ViewUser vUser = new ViewUser();

        while (true) {
            vUser.menu();
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
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
