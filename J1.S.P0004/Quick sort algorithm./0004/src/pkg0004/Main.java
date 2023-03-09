/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0004;

import java.util.Arrays;

/**
 *
 * @author chungdoan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //dây la khai bao bien selectionSort
        Function4 quickSort = new Function4();

        //input number of array ( number phai la so nguyen duong)
        int number = quickSort.getInt("Enter number of array: ", "wrong1(do chua bic db ycau nhap tu bnh)",
                "Number must > 0", "Input phai la so", 0, Integer.MAX_VALUE);
        //create array
        int[] array = new int[number];
        //create random number for elements
        quickSort.randomElement(array);
        //display unsorted array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        //sort array
        quickSort.quickSort(array, 0, array.length - 1);
        //display sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

