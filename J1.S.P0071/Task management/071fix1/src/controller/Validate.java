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

    public String getString(String mess) {
        String s = "";
        while (true) {
            System.out.print(mess);
            s = sc.nextLine();
            if (s.trim().isEmpty()) {
                continue;
            }
            break;
        }
        return s;
    }

//    public Date getDate(String mess) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
//        while (true) {
//            try {
//                System.out.print(mess);
//                Date date = sdf.parse(sc.nextLine());
//                return date;
//            } catch (ParseException e) {
//
//            }
//        }
//    }

    public Date getDate(String mess) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        Date date = null;
        try {
                System.out.print(mess);
                date = formatter.parse(sc.nextLine());
                return date;
        } catch (ParseException e) {
            System.out.println("Your date is not real!");
            return null;
        }
        
    }


}
