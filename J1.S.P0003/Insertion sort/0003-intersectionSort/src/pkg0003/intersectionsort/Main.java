/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0003.intersectionsort;

import java.util.Arrays;

/**
 *
 * @author chungdoan
 */
public class Main {

    public static void main(String[] args) {
        Function function = new Function();

        // Prompt the user to input a positive decimal number
        int number = function.getInput("Enter number of array: ", "Input must be a positive integer.",
                "Number must be greater than 0.", "Input must be an integer.", 0, Integer.MAX_VALUE);

        // Generate the array with n elements and display it
        int[] arr = function.generateArray(number);
        System.out.println("Unsorted array: " + Arrays.toString(arr));

        // Sort the array and display it again
        function.insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

