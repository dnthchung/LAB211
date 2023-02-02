/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0001;

import java.util.Arrays;

/**
 *
 * @author Lap
 */
public class Main {
    public static void main(String[] args) {
        BubblerSort bubblerSort = new BubblerSort();
        
        
        //input number of array ( number phai la so nguyen duong)
        int number = bubblerSort.getInt("Enter number of array: ", "wrong1(do chua bic db ycau nhap tu bnh)",
                "Number must > 0", "Input phai la so", 0, Integer.MAX_VALUE);
        //create array
        int[] array = new int[number];
        //create random number for elements
        bubblerSort.randomElement(array);
        //display unsorted array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        //sort array
        bubblerSort.sort(array);
        //display sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}
