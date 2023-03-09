/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0005;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Function5 {
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

// Hàm đệ quy để sắp xếp mảng sử dụng Merge Sort
    public void merge_Sort(int[] array, int left, int right) {
        if (left < right) {
            // Tìm điểm giữa của mảng để chia thành hai nửa
            int middle = (left + right) / 2;

            // Đệ quy gọi hàm mergeSort cho nửa đầu tiên
            merge_Sort(array, left, middle);

            // Đệ quy gọi hàm mergeSort cho nửa thứ hai
            merge_Sort(array, middle + 1, right);

            // Gọi hàm merge để trộn hai nửa đã sắp xếp thành một mảng sắp xếp
            merge(array, left, middle, right);
        }
    }

    // Hàm trộn hai mảng đã sắp xếp thành một mảng sắp xếp
    public void merge(int[] array, int left, int middle, int right) {
        // Tạo một mảng tạm để lưu trữ các giá trị của mảng ban đầu
        int[] temp = new int[array.length];
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        // Sử dụng ba biến i, j và k để trộn hai mảng thành một mảng
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
            //if (temp[i] >= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        // Sao chép các phần tử còn lại của nửa đầu tiên (nếu có)
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }
        // Sao chép các phần tử còn lại của nửa thứ hai (nếu có)
        while (j <= right) {
            array[k] = temp[j];
            k++;
            j++;
        }
    }
    
    
    
}
