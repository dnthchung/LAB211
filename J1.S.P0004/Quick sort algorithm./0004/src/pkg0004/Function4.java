/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0004;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Function4 {
    
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
    
    // Phương thức QuickSort
    public void quickSort(int[] arr, int low, int high) {
        // Trường hợp cơ sở cho đệ quy là khi mảng con chỉ chứa một phần tử
        if (low < high) {
            // Phân chia mảng con sử dụng phần tử pivot
            int pivotIndex = partition(arr, low, high);

            // Đệ quy sắp xếp các mảng con bên trái và bên phải
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

// Phương thức hỗ trợ để phân chia mảng con sử dụng phần tử pivot
    private int partition(int[] arr, int low, int high) {
        // Chọn phần tử cuối cùng của mảng làm pivot
        int pivot = arr[high];

        // Khởi tạo chỉ số của phần tử nhỏ hơn
        int i = low - 1;

        // Lặp qua mảng con từ low đến high - 1
        for (int j = low; j < high; j++) {
            // Nếu phần tử hiện tại nhỏ hơn hoặc bằng pivot,
            // hoán đổi nó với phần tử tại arr[i+1] và tăng i lên 1
            if (arr[j] <= pivot) {
                i++;

                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Hoán đổi phần tử pivot với phần tử tại arr[i+1]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Trả về chỉ số của phần tử pivot sau khi phân chia
        return i + 1;
    }


}
