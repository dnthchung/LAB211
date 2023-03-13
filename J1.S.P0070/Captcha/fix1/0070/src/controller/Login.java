/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ResourceBundle;
import model.EBank;
import view.Inputted;

/**
 *
 * @author chungdoan
 */
public class Login {
    public static void loginDisplay(EBank tpbank) {
        // Tạo ResourceBundle để lấy dữ liệu ngôn ngữ từ hai file
        ResourceBundle language = tpbank.getLanguage();
        String messageReturn;
        
    //function check usernumber
        String accountNumber;
        System.out.print(Message.getMessage(language, "mess.inputAcc"));
        do {
            accountNumber = Inputted.inputString("");
            messageReturn = tpbank.checkAccountNumber(accountNumber);
            //neu có thong bao 
            if (messageReturn == null) {
                break;
            }
            System.err.println(messageReturn);
            System.out.print(Message.getMessage(language, "mess.tryAgain"));
        } while (true);

        
    //function check pasword
        String password;
        System.out.print(Message.getMessage(language, "mess.inputPass"));
        do {
            password = Inputted.inputString("");
            messageReturn = tpbank.checkPassword(password);
            if (messageReturn == null) {
                break;
            }
            System.err.println(messageReturn);
            System.out.print(Message.getMessage(language, "mess.tryAgain"));
        } while (true);

        
    //function check captcha
        //create random captcha
        String captchaGenerate = tpbank.generateCaptchaText(6);
        //print captchar
        System.out.println("Captcha: " + captchaGenerate);
        String captchaInput;
        System.out.print(Message.getMessage(language, "mess.inputCap"));
        do {
            captchaInput = Inputted.inputString("");
            //check input captcha
            messageReturn = tpbank.checkCaptcha(captchaGenerate, captchaInput);
            if (messageReturn == null) {
                break;
            }
            System.err.println(messageReturn);
            System.out.print(Message.getMessage(language, "mess.tryAgain"));
        } while (true);

        System.out.println(Message.getMessage(language, "mess.loginSuccess"));
    }
}
