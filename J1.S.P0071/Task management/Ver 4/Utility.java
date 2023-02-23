/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Utility {

    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final Scanner scanner = new Scanner(System.in);

    // check int input
    public static int getInt(String message, String wrong1, String wrong2, String wrong3, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(wrong1);
                    } else if (number > max) {
                        System.out.println(wrong2);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException E) {
                System.out.println(wrong3);
            }
        }
    }

    // check double input
    public static double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    // check float input
    public static float getFloat(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    float number = Float.parseFloat(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }

    // check String input
    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            input = trycatch(input);
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    // ham change String input : input : CoDe -> still match to format : code
    public static String trycatch(String meow) {
        
        meow = meow.toLowerCase();
        meow = meow.replaceAll("  +", " ");
        //split string and save them to array
        String[] w = meow.split(" ");
        //clear sting meow
        meow = "";
        int i = 0;
        int n = w.length;
        //Viet hoa tat ca chu cai dau cua tu
        for (i = 0; i < n; i++) {
            w[i] = w[i].substring(0, 1).toUpperCase() + w[i].substring(1, w[i].length());
        }
        //add cac tu lai thanh String goc 
        for (i = 0; i < n; i++) {
            meow = meow + w[i] + " ";
        }
        return meow.trim();
    }

}
