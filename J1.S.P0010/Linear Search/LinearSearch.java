/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0010;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lap
 */
public class LinearSearch {
    
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
            } catch (Exception e) {
                //xay ra khi ng dung nhap khong phai so nguyen
                System.out.println(thirdError);
            }
        }
    }
    
    
    void randomElement(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            //sinh ra cac so ngau nhien va gasn vao cac phan tu mang
            array[i] = random.nextInt(array.length - 1) + 1;

        }
    }

    //search
    void search(int[] array, int searchNumber) {
        for (int i = 0; i < array.length; i++) {
            if(searchNumber == array[i]) {
                System.out.println("Found " + searchNumber + " at index " + i );
                //stop 
                return;
            }else {
                
            }
            
        }System.out.println("Not found.");
    }
    
    //fix    
    //search - cô năng yêu cầu phải trả về index
    public int search(int[] array, int searchNumber){
        for (int i = 0; i < array.length; i++) {
            if(searchNumber == array[i]){
                return i;
            }
        }
        return -1;
    }
    
    
}
