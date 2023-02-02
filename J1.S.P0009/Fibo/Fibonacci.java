
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lap
 */
public class Fibonacci {

    public static void main(String[] args) {
       //create array 
       int[] array = new int[45];
       //use recursion to find 45 sequence fibonacci
       findFibonacciNumbers(array, 0);
       //display sequence
       displaySequence(array);
    }

    private static void findFibonacciNumbers(int[] array, int count) {   
        if (count == 0 || count == 1) {
            array[count] = count;
        }else {
            array[count] = array[count - 1] + array[count - 2];
        }
        count++;       
        if (count == array.length) {
            return;
        }
        findFibonacciNumbers(array, count);        
    }

    private static void displaySequence(int[] array) {
        System.out.print("The sequence: ");
//        System.out.println("The sequence: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
  
}
