/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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

    //check int input
    public int getInt(String message, String firstError, String secondError,
            String thirdError, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
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

    //check double input
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

    //check float input
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
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    //check String input
    public String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
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

    //check date input
    public String getDate() {
        while (true) {
            System.out.println("Enter date: ");
            String input = scanner.nextLine().trim();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
                //check format    
            } else {
                if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{1,4}")) {
                    System.out.println("Date must focus in format dd-MM-yyyy");
                } else {
                    //check dateInput  >= dateNow
                    SimpleDateFormat dateFormat = new SimpleDateFormat(/** pattern**/"dd-MM-yyyy");
                    dateFormat.setLenient(false);
                    try {
                        Date dateNow = new Date();
                        Date dateInput = dateFormat.parse(input);
                        //chuyen dateNow(co gio giac) -> thanh dateNow(gio giac == gio giac dateInput)
                        dateNow = dateFormat.parse(dateFormat.format(dateNow));

                        if (dateInput.after(dateNow)) {
                            return input;
                        } else {
                            System.out.println("Date must be greater or equal to date now !!");
                        }
                    } catch (Exception e) {
                        System.out.println("Date does not exist !!");
                    }
                }
            }

        }
    }

    //nhap du lieu dau vao 
    //get requirement name
    public String getRequirementNameInput() {
        String requirementName = getString("Requiment name: ", "Your input must be String", "[a-zA-Z ]+");
        return requirementName;
    }
    
    //get task type
    public int getTaskTypeInput() {
        int taskType = getInt("Task type: ", "Input must be 1,2,3 or 4", "Input must be 1,2,3 or 4", "Input must be INT", 1, 4);
        return taskType;
    }
    
    //get from
    public double getFromInput() {
        double from = getDouble("Enter from: ", "Wrong", "Wrong", "Wrong", 8, 17);
        return from;
    }
    
    //get to
    public double getToInput(double from) {
        double to = getDouble("Enter to: ", "Wrong", "Wrong", "Wrong", from + 0.5, 17.5);
        return to;
    }
    
    //get assignee
    public String getAssigneeInput() {
        String assignee = getString("Enter assignee: ", "Wrong", REGEX_STRING);
        return assignee;
    }
    
    //get reviewer 
    public String getReviewerInput() {
        String reviewer = getString("Enter reviewer: ", "Wrong", REGEX_STRING);
        return reviewer;
    }
}
