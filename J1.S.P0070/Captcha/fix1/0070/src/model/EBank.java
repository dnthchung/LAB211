/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Message;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author chungdoan
 */
public class EBank {
    
    /**
     * REGEX_ACCOUNTNUMBER : must have 10 digits
     * REGEX_PASSWORD_LENGTH : từ 8 đến 31 ký tự
     * REGEX_PASSWORD_ALPHANUMERIC:  chỉ chứa các ký tự chữ cái và số 
     * REGEX_CAPTCHA 
     * CHAR_LIST 
     */
    private final String REGEX_ACCOUNTNUMBER = "^\\d{10}$";
    private final String REGEX_PASSWORD_LENGTH = "^.{8,31}$";
    private final String REGEX_PASSWORD_ALPHANUMERIC = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
    private final String REGEX_CAPTCHA = "^[A-Z0-9]{1}$";
    private final String CHAR_LIST = "abcdefghjklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                        //"ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
//Function 1: change language
    // Tạo ResourceBundle để lấy dữ liệu ngôn ngữ từ hai file
    private ResourceBundle language;

    /**
     * Constructor default
     */
    public EBank() {
    }

    // Thực hiện lấy file chứa ngôn ngữ theo locale truyền vào.
    public void setLocate(Locale locate) {
        String baseName = "model.mess";
        language = ResourceBundle.getBundle(baseName, locate);
    }
    
    //hàm getLanguage() trả về đối tượng ResourceBundle đã được thiết lập.
    public ResourceBundle getLanguage() {
        return language;
    }

    
//Function 2: Check account number
    public String checkAccountNumber(String accountNumber) {
        //Nếu không phù hợp, phương thức sẽ trả về một thông báo lỗi
        if (!accountNumber.matches(REGEX_ACCOUNTNUMBER)) {
            return Message.getMessage(language, "mess.wrongAcc");
        }
        //Nếu chuỗi đầu vào hợp lệ, phương thức sẽ trả về null.
        return null;
    }

//Function 3: Check password
    public String checkPassword(String password) {
        if (!password.matches(REGEX_PASSWORD_LENGTH)) {
            return Message.getMessage(language, "mess.wrongNumberOfPass");
        }
        // chỉ chứa các ký tự chữ cái và số
        if (!password.matches(REGEX_PASSWORD_ALPHANUMERIC)) {
            return Message.getMessage(language, "mess.wrongTypePass");
        }
        return null;
    }

//Function 4:  Generate a random captcha code.
    public String generateCaptchaText(int captchaLength) {
        // Khởi tạo một StringBuilder để lưu trữ chuỗi captcha
        StringBuilder captchaText = new StringBuilder();
        // Biến lưu trữ số ngẫu nhiên
        int randomNumber;
        // Biến lưu trữ ký tự ngẫu nhiên
        char randomChar;
        // Lặp lại cho đến khi độ dài của chuỗi captcha bằng với tham số truyền vào
        for (int i = 0; i < captchaLength; i++) {
            // Lấy ra một số ngẫu nhiên từ hàm getRandomNumber()
            randomNumber = getRandomNumber(captchaLength);
            // Lấy ra ký tự ngẫu nhiên từ chuỗi ký tự CHAR_LIST dựa trên số ngẫu nhiên
            randomChar = CHAR_LIST.charAt(randomNumber);
            // Thêm ký tự ngẫu nhiên vào chuỗi captcha
            captchaText.append(randomChar);
        }
        return captchaText.toString();
    }

    //create random number
    private int getRandomNumber(int max) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(max);
        return randomInt % max;
    }

//Function 5: Check the captcha code
    public String checkCaptcha(String captchaGenerate, String captchaInput) {
        String messErr = null;
        //Nếu giá trị captchaInput rỗng hoặc không khớp với giá trị captchaGenerate
        //-->tra ve thong báo wrong
        if (!captchaGenerate.contains(captchaInput) || captchaInput.isEmpty()) {
            messErr = language.getString("mess.wrongCap");
        }
        //true--> tra ve null
        return messErr;
    }
    
}
