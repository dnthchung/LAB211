/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0003.intersectionsort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Function {

    // Function to get user input and validate it
    public int getInput(String message, String firstError, String secondError, String thirdError, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                // Check if the input is within the allowed range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                // Catch the exception if the input is not a valid integer
                System.out.println(thirdError);
            }
        }
    }

    // Function to generate an array with n elements
    public int[] generateArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // Generate a random integer between 1 and 2n (inclusive)
            arr[i] = random.nextInt(n * 2) + 1;
        }
        return arr;
    }

    // Function to perform insertion sort on an array
    public void insertionSort(int[] arr) {
        //Bước đầu tiên là lặp qua từng phần tử của mảng, bắt đầu từ phần tử thứ 2 (i=1).
        for (int i = 1; i < arr.length; i++) {
            //Đối với mỗi phần tử, ta lưu giữ giá trị của nó vào biến key và tiến hành duyệt các phần tử từ phần tử trước nó (j=i-1) đến phần tử đầu tiên của mảng (j=0).
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}







/**
 * Bước đầu tiên là lặp qua từng phần tử của mảng, bắt đầu từ phần tử thứ 2 (i=1).

Đối với mỗi phần tử, ta lưu giữ giá trị của nó vào biến key và tiến hành duyệt các phần tử từ phần tử trước nó (j=i-1) đến phần tử đầu tiên của mảng (j=0).

Trong khi vẫn còn phần tử nằm bên trái key mà có giá trị lớn hơn key thì ta di chuyển các phần tử đó sang phải một vị trí để tạo chỗ trống cho key. Để di chuyển các phần tử này, ta gán giá trị của phần tử bên trái sang phải một vị trí (arr[j+1] = arr[j]), và sau đó giảm giá trị của biến j đi một đơn vị (j--).

Khi không còn phần tử nào bên trái key mà có giá trị lớn hơn key, ta sẽ chèn key vào vị trí còn trống đó (arr[j+1] = key).

Kết quả sau khi sắp xếp được lưu trữ trong mảng arr.
 */
