/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.util.Arrays;

/**
 *
 * @author chungdoan
 */
public class Main {


    public static void main(String[] args) {
        
        //dây la khai bao bien selectionSort
        Manage selectionSort = new Manage();

        //input number of array ( number phai la so nguyen duong)
        int number = selectionSort.getInt("Enter number of array: ", "wrong1(do chua bic db ycau nhap tu bnh)",
                "Number must > 0", "Input phai la so", 0, Integer.MAX_VALUE);
        //create array
        int[] array = new int[number];
        //create random number for elements
        selectionSort.randomElement(array);
        //display unsorted array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        //sort array
        selectionSort.bubble_srt(array);
        //display sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

}
