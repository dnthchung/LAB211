/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lap
 */
public class BubblerSort {
    
    //check input int
    public int getInt(String message, String firstError, String secondError, String thirdError, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {            
            try{
                System.out.println(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                
                //check range
                if(number > max){
                    System.out.println(firstError);
                }else if(number < min) {
                    System.out.println(secondError);
                }else {
                    return number;
                }
            }catch(NumberFormatException e){
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
    void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)   // neu cho chay toi thang n thi  bi thua so luon phan tu (vidu index la 4 nma so luong phan tu la 5, co 5 phan tu nma chi can so sanh 4 lan)
            for (int j = 0; j < n - i - 1; j++) // n-i-1: so lan so sanh
                if (array[j] > array[j + 1]) {
                    // swap array[j+1] and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}
