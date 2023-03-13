/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Inputted {
    private static final Scanner INPUT = new Scanner(System.in);

    //function: check input : int
    public static int inputInt(String message, int min, int max) {
        if (min > max) {
            max = max + min;
            min = max - min;
            max = max - min;
        }
        System.out.print(message);
        int inputUser;

        do {
            try {
                inputUser = Integer.parseInt(INPUT.nextLine().trim());
                if (inputUser < min || inputUser > max) {
                    System.err.println("Input out of range. Enter a value between " + min + " and " + max + ":");
                } else {
                    return inputUser;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer.");
            }
            System.out.print("Enter again: ");
        } while (true);
    }

    
    //function: check input : String
    public static String inputString(String message) {
        System.out.print(message);
        return INPUT.nextLine().trim();
    }
}
