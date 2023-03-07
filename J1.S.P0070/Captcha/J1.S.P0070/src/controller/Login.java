/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.EBank;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Login {
 
    public final String REGEX_PASSWORD = "^[a-zA-Z0-9]{8,30}$";
            //"^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
    //^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$
    public final String REGEX_USERNAME = "^\\d{10}$";
    public final String REGEX_STRING = "[a-zA-Z0-9]+";
    
    //Function check login input 
    public static void manageLogin(EBank input) {
        Scanner sc = new Scanner(System.in);
        String account;
        String password;

        //check usernumber input
        while (true) {
            System.out.print(input.getLanguage().getString("account"));
            account = sc.nextLine();
            //check empty
            if (input.checkAccountNumber(account).equals("")) {
//            if (input.checkAccountNumber(account).isEmpty()) {    
                break;
            } else {
                System.out.println(input.checkAccountNumber(account));
            }
        }

        //check password input
        while (true) {
            System.out.print(input.getLanguage().getString("password"));
            password = sc.nextLine();
            if (input.checkPassword(password).equals("")) {
                break;
            } else {
                System.out.println(input.checkPassword(password));
            }
        }

        
        
        //check captcha input
        //create captcha
        String randomCaptcha = EBank.createCaptcha();
        while (true) {
            System.out.print(input.getLanguage().getString("captcha"));
            System.out.println(randomCaptcha);
            //check captcha
            String inputCaptcha = sc.nextLine();
            //check input captcha = chu cai dau captcha
            if(!EBank.checkCaptcha(inputCaptcha,randomCaptcha)){
                System.out.println(input.getLanguage().getString("captcha.incorrect"));
            }else {
                break;
            }
        }
        
        
        
        
        
        System.out.println(input.getLanguage().getString("successeror"));
    }
    
    
    
    //Function check input int 
    public static int checkInputIntLimit(int min, int max) {//Kiểm tra nhập giá trị từ 1 đến n
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter your choice: ");
            }
        }
    }
    
}



////check captcha
//// create captcha
//String randomCaptcha = EBank.createCaptcha();
//        while (true) {
//            System.out.print(input.getLanguage().getObject("captcha"));
//            System.out.println(randomCaptcha);
//            // check captcha
//            String inputCaptcha = sc.nextLine();
//            //input = captcha
////            if (randomCaptcha.equals(inputCaptcha)) {
////                break;
////            } else {
////                System.out.println(input.bundle.getObject("captcha.incorrect"));
////            }
//            //input = chu cai dau captcha
//            if (!randomCaptcha.contains(inputCaptcha)) {
//                System.out.println(input.getLanguage().getObject("captcha.incorrect"));
//            } else {
//                break;
//            }
//        }
//
//        System.out.println(input.getLanguage().getObject("successeror"));
//    }



//chỉ có phương thức isEmpty mới trả về giá trị false, 
//còn phương thức equals có thể trả về cả false hoặc 
//NullPointerException nếu checkAccountNumber(account) trả về null.