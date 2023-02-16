/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0010;

import java.util.Arrays;

/**
 *
 * @author Lap
 */
public class Main {

   

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();

        //input number of array ( number phai la so nguyen duong)
        int number = linearSearch.getInt("Enter number of array: ", "wrong1(do chua bic db ycau nhap tu bnh)",
                "Number must > 0", "Input phai la so", 0, Integer.MAX_VALUE);
        //create array
        int[] array = new int[number];
        
        //input search number
        int searchNumber = linearSearch.getInt("Enter number that u want to search: ", "wrong1(do chua bic db ycau nhap tu bnh)",
                "Number must > 0", "Input phai la so", Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        //create random number for elements
        linearSearch.randomElement(array);
        
        //show array
        System.out.println("The array: " + Arrays.toString(array));
        
        //search numer
        linearSearch.search(array, searchNumber);

        //fix
        //search numer
        int index = linearSearch.search(array, searchNumber);
        //found
        if(index != -1){
            System.out.println("Found " + searchNumber + " at index " + index);
        //not found
        }else {
            System.out.println("Not Found!!");
        }

    }
}
