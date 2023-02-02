/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageReal;

import java.util.Scanner;
import static packageReal.CheckFormat.checkDate;
import static packageReal.CheckFormat.checkEmail;
import static packageReal.CheckFormat.checkPhone;

/**
 *
 * @author Lap
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        //input phone
        while (true) {
            System.out.print("Enter phone number: ");
            input = scanner.nextLine();
            String result = checkPhone(input);
            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }
        }
        //input gmail
        while (true) {
            System.out.print("Enter your gmail: ");
            input = scanner.nextLine();
            String result = checkEmail(input);
            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }
        }

        //input date
        while (true) {
            System.out.print("Enter date: ");
            input = scanner.nextLine();
            String result = checkDate(input);
            if (result.isEmpty()) {
                break;
            } else {
                System.out.println(result);
            }
        }

    }
}

