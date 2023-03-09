/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author chungdoan
 */
public class Main {

    public void count(String str, String type) {
        // Xóa tất cả các ký tự đặc biệt từ chuỗi str
        str = str.replaceAll("\\W", " ");
        // Xóa tất cả các chữ số từ chuỗi str
        str = str.replaceAll("[0-9]", " ");
        // Xóa tất cả các khoảng trắng thừa từ chuỗi str
        str = str.replaceAll("  +", " ");
        // Khởi tạo một Map để lưu trữ số lần xuất hiện của các từ/ký tự
        Map<String, Integer> counter = new HashMap<>();
        // Tạo một StringTokenizer từ chuỗi str
        StringTokenizer st = new StringTokenizer(str);
        // Khởi tạo một mảng w để lưu trữ các từ hoặc ký tự tùy vào giá trị của biến type
        String[] w = new String[st.countTokens()];
        int i = 0;
        // Nếu type là "Word", thêm các từ vào mảng w

        /**
         *
         */
        if (type.equals("Word")) {
            while (st.hasMoreTokens()) {
                //Sử dụng vòng lặp while để lấy ra từng token 
                //tức là từ được tách ra từ chuỗi đầu vào bởi phương thức StringTokenizer) và lưu vào mảng w.
                w[i] = st.nextToken();
                // Tăng biến i lên mỗi khi một từ được lưu vào mảng w.
                i++;
            }
        }
        // Nếu type là "Char", thêm các ký tự vào mảng w

        if (type.equals("Char")) {
            str = str.replaceAll(" +", "");
            w = str.split("");
        }
        if (!str.equals("")) {
            // Tăng giá trị tương ứng trong Map cho mỗi từ/ký tự
            for (String w1 : w) {
                if (!counter.containsKey(w1)) {
                    counter.put(w1, 1);
                } else {
                    counter.put(w1, (int) counter.get(w1) + 1);
                }
            }
            // In ra Map để hiển thị số lần xuất hiện của các từ/ký tự
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập chuỗi từ người dùng
        String str = sc.nextLine().trim();
        str = str.toLowerCase();
        Main main = new Main();
        // Đếm số lần xuất hiện của từng từ/ký tự trong chuỗi và hiển thị kết quả
//        main.count(str, "Word");
//        main.count(str, "Char");

        main.count(str, "Word");
        main.count(str, ",Char");
//

    }
}

//public class Main {
//    public void count(String str, String type){
//        str = str.replaceAll("\\W", " ");
//        str = str.replaceAll("[0-9]", " ");
//        str = str.replaceAll("  +", " ");
//        Map<String, Integer> counter = new HashMap<>();
//        StringTokenizer st = new StringTokenizer(str);  
//        String[] w = new String[st.countTokens()] ;
//        int i=0;
//        if(type.equals("Word")){         
//            while(st.hasMoreTokens()){
//                w[i]=st.nextToken();
//                i++;
//            }          
//        }
//        if(type.equals("Char")){
//            str= str.replaceAll(" +", "");
//            w=str.split("");
//        }
//        for (String w1 : w) {
//            if(!counter.containsKey(w1)){
//                counter.put(w1, 1);
//            }else{
//                counter.put(w1, (int)counter.get(w1)+1);
//            }
//        }
//        System.out.println(counter);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine() .trim();
//        Main main = new Main();
//        main.count(str, "Word");
//        main.count(str, "Char");
//    }
//    
//}
