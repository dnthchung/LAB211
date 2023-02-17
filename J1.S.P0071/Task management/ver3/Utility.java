/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author chungdoan
 */
public class Utility {

  public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
  public static final Scanner scanner = new Scanner(System.in);

  // check int input
  public int getInt(String message, String wrong1, String wrong2, String wrong3, int min, int max) {
    while (true) {
      try {
        System.out.println(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
          System.out.println("Input cannot be empty !!");
        } else {
          int number = Integer.parseInt(input);
          if (number < min) {
            System.out.println(wrong1);
          } else if (number > max) {
            System.out.println(wrong2);
          } else {
            return number;
          }
        }
      } catch (NumberFormatException E) {
        System.out.println(wrong3);
      }
    }
  }

  // check double input
  public double getDouble(String message, String firstError, String secondError,
      String thirdError, double min, double max) {
    while (true) {
      try {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
          System.out.println("Input cannot be empty !!");
        } else {
          double number = Double.parseDouble(input);
          if (number < min) {
            System.out.println(firstError);
          } else if (number > max) {
            System.out.println(secondError);
          } else {
            return number;
          }
        }
      } catch (Exception e) {
        System.out.println(thirdError);
      }
    }
  }

  // check float input
  public float getFloat(String message, String firstError, String secondError,
      String thirdError, double min, double max) {
    while (true) {
      try {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
          System.out.println("Input cannot be empty !!");
        } else {
          float number = Float.parseFloat(input);
          if (number < min) {
            System.out.println(firstError);
          } else if (number > max) {
            System.out.println(secondError);
          } else {
            return number;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println(thirdError);
      }
    }
  }

  // check String input
  public String getString(String message, String error, String regex) {
    while (true) {
      System.out.print(message);
      String input = scanner.nextLine().trim();
      input = trycatch(input);
      if (input.isEmpty()) {
        System.out.println("Input cannot be empty !!");
      } else {
        if (input.matches(regex)) {
          return input;
        } else {
          System.out.println(error);
        }
      }
    }
  }

  // ham change String input : input : CoDe -> still match to format : code
  public String trycatch(String meow) {
    meow = meow.toLowerCase();
    meow = meow.substring(0, 1).toUpperCase() + meow.substring(1, meow.length());

    return meow;
  }

        //check date input
    public String getDate() {
        while (true) {
            System.out.print("Enter date: ");
            String input = scanner.nextLine().trim();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            //check format    
            } else {

                    //check dateInput  >= dateNow
                    SimpleDateFormat dateFormat = new SimpleDateFormat(/** pattern**/"dd-MM-yyyy");
                    dateFormat.setLenient(false);
                    try {
                        if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
                            System.out.println("Date must focus in format dd-MM-yyyy");
                        }else {
                            dateFormat.parse(input.trim());
                            return input;
                        }
                            
//                        Date dateNow = new Date();
//                        Date dateInput = dateFormat.parse(input);
//                        //chuyen dateNow(co gio giac) -> thanh dateNow(gio giac == gio giac dateInput)
//                        dateNow = dateFormat.parse(dateFormat.format(dateNow));
//
//                        if (dateInput.after(dateNow)) {
//                            return input;
//                        } else {
//                            System.out.println("Date must be greater or equal to date now !!");
//                        }
                    } catch (Exception e) {
                        System.out.println("Date does not exist !!");
                    }
            }
        }

    }
     // ham check date
//  public String getDate() {
//    while (true) {
//      System.out.println("Enter date: ");
//      String input = scanner.nextLine().trim();
//
//      // check input empty
//      if (input.isEmpty()) {
//        System.out.println("Ur input can not be empty!");
//
//        // check format
//      } else {
//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//        dateFormat.setLenient(false);
//        try {
//          if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
//            return "Input not valid";
//          } else {
////            dateFormat.parse(input.trim());
//           return input;
//          }
//        } catch (Exception e) {
//          return "Your date is not real!";
//        }
//      }
//    }
//  }

  
//    // ham check date
//  public String getDate() {
//    while (true) {
//      System.out.println("Enter date: ");
//      String input = scanner.nextLine().trim();
//
//      // check input empty
//      if (input.isEmpty()) {
//        System.out.println("Ur input can not be empty!");
//
//        // check format
//      } else {
//
//        try {
//          if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
//            return "Input not valid";
//          } else {
//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//        dateFormat.setLenient(false);
//           return input;
//          }
//        } catch (Exception e) {
//          return "Your date is not real!";
//        }
//      }
//    }
//  }
//  

  
  
  // Ham nhap input
  // get requirement Name
  public String getRequirementNameInput() {
    String requirementName = getString("Requiment name: ", "Your input must be String", "[a-zA-Z ]+");
    return requirementName;
  }

  // get task type
  public String getTaskTypeInput() {
    String taskType = getString("Task type: ", "Your input must be [Code - Test - Design or Review].", "Code|Test|Design|Review");
    return taskType;
  }

  // get from
  public double getFromInput() {
    double from = getDouble("Enter from: ", "Input must >= 8", "Input must =< 17", "Input must be number!!", 8, 17);
    return from;
  }

  // get to
  // getToInput phai truyen them from de dam bao diu kien "to" > "from"
  public double getToInput(double from) {
    double to = getDouble("Enter to: ", "Input must >= 8 ", "Input must =< 17.5", "Input must be number!!", from + 0.5, 17.5);
    return to;
  }

  // get assignee
  public String getAssigneeInput() {
    String assignee = getString("Enter assignee: ", "Input must be String without symbol!", REGEX_STRING);
    return assignee;
  }

  // get reviewer
  public String getReviewerInput() {
    String reviewer = getString("Enter reviewer: ", "Input must be String without symbol!", REGEX_STRING);
    return reviewer;
  }
}
