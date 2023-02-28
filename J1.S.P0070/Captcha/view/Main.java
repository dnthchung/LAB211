package view;

import model.EBank;
import controller.Login;
import java.util.Locale;

public class Main {

    public static void main(String[] args) { // Tạo menu cho phép người dùng nhập dữ liệu
        while (true) {
            //display menu:
            System.out.println("-------Login Program-------\n"
                    + "1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            //create object Locale for VietNamese and English
            Locale VietNam = new Locale("vi");//tạo một đối tượng Locale đại diện cho ngôn ngữ tiếng Việt
            Locale English = new Locale("en");//tạo một đối tượng Locale đại diện cho ngôn ngữ tiếng Anh

            //create object input
            EBank input = new EBank();
            choice = Login.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    input.setLocale(VietNam);
                    break;
                case 2:
                    input.setLocale(English);
                    System.exit(0);
                    break;
                case 3:
                    return;
            }
            Login.manageLogin(input);
        }
    }

}
