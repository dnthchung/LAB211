/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0008;

import com.sun.jndi.url.iiop.iiopURLContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.scene.input.KeyCode;

/**
 *
 * @author chungdoan
 */
public class Main {
    public void count(String str, String type){
        str = str.replaceAll("\\W", " ");
        str = str.replaceAll("[0-9]", " ");
        str = str.replaceAll("  +", " ");
        Map<String, Integer> counter = new HashMap<>();
        StringTokenizer st = new StringTokenizer(str);  
        String[] w = new String[st.countTokens()] ;
        int i=0;
        if(type.equals("Word")){         
            while(st.hasMoreTokens()){
                w[i]=st.nextToken();
                i++;
            }          
        }
        if(type.equals("Char")){
            str= str.replaceAll(" +", "");
            w=str.split("");
        }
        for (String w1 : w) {
            if(!counter.containsKey(w1)){
                counter.put(w1, 1);
            }else{
                counter.put(w1, (int)counter.get(w1)+1);
            }
        }
        System.out.println(counter);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() .trim();
        Main main = new Main();
        main.count(str, "Word");
        main.count(str, "Char");
    }
    
}
