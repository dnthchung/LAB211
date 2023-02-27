package model;

import controller.Login;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class EBank {
    Login control = new Login();
    
    // Tạo ResourceBundle để lấy dữ liệu ngôn ngữ từ hai file
    ResourceBundle bundle; 
    /**
     * Constructor
     */
    public EBank() {
    }
    // Thực hiện lấy file chứa ngôn ngữ theo locale truyền vào.
    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("model.Language", locale);// tìm đến file languages đến locale mình truyền vào là VI hoạc EN
    }
    
    public ResourceBundle getLanguage() {
        return bundle;
    }
    

    
    //Function check usernumber 
    public String checkAccountNumber(String accountNumber) {// Kiểm tra tài khoản được truyền vào
        String account = "";
        Pattern p = Pattern.compile(control.REGEX_USERNAME); // tài khoản phải có 10 chữ số
        if (!p.matcher(accountNumber).find()) {
            account = bundle.getString("account.error");
        }
        return account;
    }

    //Function check Password 
    public String checkPassword(String password) {// Kiểm tra pass có thảo mãn yêu cầu đề bài hay không
        String pass = "";
        Pattern p = Pattern.compile(control.REGEX_PASSWORD); // Phải nhập từ 8-31 ký tự bao gồm số và ký tự
        //not match
        if (!p.matcher(password).find()) {
            pass = bundle.getString("password.error");
        }
        return pass;
    }

    //Function check Captcha
    public String checkCaptcha(String captcha, String captchaEnter) {//Kiểm tra mã Captcha có nhập đúng không
        String captcha2 = "";
        if (!captchaEnter.equals(captcha)) {
            captcha2 = bundle.getString("captcha.incorrect");
        }
        if (!captcha.contains(captchaEnter) || captchaEnter.isEmpty() || captchaEnter.length() != 1) {
            captcha2 = bundle.getString("captcha.incorrect");
        }
        return captcha2;
    }
    
    //Function create Captcha 
    public static String createCaptcha() {
        Random random = new Random();
        int number = 0;
        int i = 0;
        String captcha = "";
        /**
         * Int(number):     A-Z: 65 - 90 / a-z: 97 - 122/0-9: 48 - 57
         *
         * Base:            A-Z: 0 - 25  / a-z: 26 - 51 /0-9: 52 - 61
         * 
         * Char(captcha):   A-Z          / a-z          /0-9:
         */
        for (i = 0; i < 5; i++) {
            // lấy ngẫu nhiên giá tri base là s? du 
            int base = Math.abs(random.nextInt()) % 62;
            if (base < 26) {
                // lấy số ký tự bất từ A-Z từ vị trí 65-90 trong bảng mã ASCII
                number = 65 + base;
            } else if (base < 52) {
                // lấy số ký tự bất từ a-z từ vị trí 97-121 trong bảng mã ASCII
                number = 71 + base;
            } else {
                // lấy số bất kỳ 0-9 từ vị trí 48-57 trong bảng mã ASCII
                number = base - 4;
            }
            //convert kieu int qua kieu char 
            char character = (char) number;
            //add char to String captcha
            captcha = captcha + character;
        }
        return captcha;
    }
    //    public static String createCaptcha() {
//        Random rd = new Random();
//        String captcha = "";
//        // tạo 5 ký tự của mã captcha
//        for (int i = 0; i < 5; i++) {
//            // lấy ngẫu nhiên số từ 0-59
//            int k = rd.nextInt(60); // tổng của các ký tự 0-9, A-Z, a-z = 60
//            if (k < 10) {
//                captcha += (char) (k + 48); // lấy số bất kỳ 0-9 từ vị trí 48-57 trong bảng mã ASCII
//            } else if (10 <= k && k < 36) {
//                captcha += (char) (k + 48 + 7); // lấy số ký tự bất từ A-Z từ vị trí 65-90 trong bảng mã ASCII
//            } else {
//                captcha += (char) (k + 48 + 7 + 6); // lấy số ký tự bất từ a-z từ vị trí 97-121 trong bảng mã ASCII
//            }
//        }
//        return captcha;
//    }




}
