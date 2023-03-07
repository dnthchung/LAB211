package model;

import controller.Login;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class EBank {
    Login control = new Login();
 
    
    //Function check input language
    // Tạo ResourceBundle để lấy dữ liệu ngôn ngữ từ hai file
    ResourceBundle bundle; 
    /**
     * Constructor
     */
    public EBank() {
    }
    // Thực hiện lấy file chứa ngôn ngữ theo locale truyền vào.
    // dùng để thiết lập locale được chọn và sau đó dùng đối tượng ResourceBundle 
    //để tìm file chứa dữ liệu ngôn ngữ theo locale đã truyền vào, với tên file là "model.Language"
    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("model.Language", locale);// tìm đến file languages đến locale mình truyền vào là VI hoạc EN
    }
    //Cuối cùng, hàm getLanguage() trả về đối tượng ResourceBundle đã được thiết lập.
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
    public static boolean checkCaptcha(String inputCaptcha, String randomCaptcha) {//Kiểm tra mã Captcha có nhập đúng không
        return randomCaptcha.contains(inputCaptcha);    
    }
    //Phương thức checkCaptcha được khai báo là static để cho phép gọi phương thức này mà không cần tạo một đối tượng của lớp EBank. 
    //Khi phương thức được khai báo là static, nó thuộc về lớp chứ không phải thuộc về một đối tượng cụ thể nào. 
    //Do đó, phương thức có thể được gọi bằng cách sử dụng tên lớp trực tiếp, ví dụ: EBank.checkCaptcha(inputCaptcha, randomCaptcha).
    
    //Trong trường hợp này, phương thức checkCaptcha không cần truy cập các thuộc tính hay phương thức của một đối tượng EBank cụ thể nào,
    //nên việc khai báo nó là static là hợp lý và tiện lợi.
    
    
    
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
            //Tạo ra một số ngẫu nhiên để làm cơ sở để tạo ra ký tự tiếp theo của chuỗi captcha.
            int base = Math.abs(random.nextInt()) % 62;
            //Với giá trị base (từ 0 đến 61) nhận được từ số ngẫu nhiên ở bước trên, 
            //ta sẽ xác định được ký tự sẽ được lấy ra từ bảng mã ASCII để thêm vào chuỗi captcha. Cụ thể:
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
            //Chuyển đổi giá trị số được lấy từ bảng mã ASCII sang ký tự tương ứng bằng cách ép kiểu int sang char.
            char character = (char) number;
            //add char to String captcha
            captcha = captcha + character;
        }
        return captcha;
    }





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