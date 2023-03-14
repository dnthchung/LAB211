/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Validate {
    static Scanner sc = new Scanner(System.in);

    //fuction check input int
    public int getInt(String mess, int min, int max, String errMinMax) {
        int number = 0;
        while (true) {
            try {
                System.out.print(mess);
                number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.out.println(errMinMax);
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Pls input must be integer number");
            }
        }
        return number;
    }

    
    //fuction check input double
    public double getDouble(String mess, double min, double max, String errMinMax) {
        double number;
        while (true) {
            try {
                System.out.print(mess);
                number = Double.parseDouble(sc.nextLine());
                if (number >= min && number <= max && number % 0.5 == 0) {
                    break;
                } else {
                    System.out.println("Input must from 8.5 to 17.5");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Input must be number!");
            }
        }
        return number;
    }

     //fuction check input String
    public String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
//            input = trycatch(input);
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

     //fuction check input date
    public Date getDate(String mess) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        while (true) {
            try {
                System.out.print(mess);
                Date date = sdf.parse(sc.nextLine());
                return date;
            } catch (ParseException e) {

            }
        }
    }


    //check date input
    public String getDate() {
        while (true) {
            System.out.print("Enter date: ");
            String input = sc.nextLine().trim();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
                //check format    
            } else {
                //check date valid
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                try {
                    if (!input.matches("\\d{2}[-]\\d{2}[-]\\d{4}")) {
                        System.out.println("Date must focus in format dd-MM-yyyy");
                    } else {
                        dateFormat.parse(input.trim());
                        return input;
                    }
                } catch (ParseException e) {
                    System.out.println("Date does not exist !!");
                }
            }
        }

    }


}
