/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Manage {
    //check input int

    public int getInt(String message, String firstError, String secondError, String thirdError, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                //xay ra khi ng dung nhap khong phai so nguyen
                System.out.println(thirdError);
            }
        }
    }

    //Ham tao random
    void randomElement(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            //sinh ra cac so ngau nhien va gasn vao cac phan tu mang
            array[i] = random.nextInt(array.length);
        }
    }

    //ham sap xep
void selection_srt(int[] array) {
        int n = array.length; // lấy độ dài của mảng đầu vào
        for (int i = 0; i < n - 1; i++) { // duyệt từ đầu đến n-2 (vị trí thứ n-1 đã được sắp xếp)
            // tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp
            int minIndex = i; // giả sử phần tử đầu tiên trong đoạn chưa sắp xếp là phần tử nhỏ nhất
            for (int j = i + 1; j < n; j++) { // duyệt từ vị trí sau i đến cuối mảng để tìm phần tử nhỏ nhất
                if (array[j] < array[minIndex]) { // nếu phần tử thứ j nhỏ hơn phần tử nhỏ nhất đã tìm thấy
                    minIndex = j; // cập nhật chỉ số của phần tử nhỏ nhất thành j
                }
            }
            // đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên của đoạn chưa sắp xếp
            int temp = array[minIndex]; // lưu giá trị của phần tử nhỏ nhất vào biến tạm thời temp
            array[minIndex] = array[i]; // gán phần tử đầu tiên trong đoạn chưa sắp xếp vào vị trí của phần tử nhỏ nhất
            array[i] = temp; // gán giá trị của phần tử nhỏ nhất vào vị trí của phần tử đầu tiên trong đoạn chưa sắp xếp
        }
    }
    
    
}
