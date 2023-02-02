/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageReal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lap
 */
public class CheckFormat {
    
    //check phone input
    public static String checkPhone(String phone) {
        if (!phone.matches("[0-9]+")) {
            return "Phone number must be number.";
        } else if (!phone.matches("[0-9]{10,11}")) {
            return "Phone number must be 10 digits.";
        } else {
            return "";
        }
    }

    //check gmail
    public static String checkEmail(String email) {
        if (!email.matches("\\w+[@]{1}(\\w+[.]){1,2}\\w+")) {
            return "Email must be correct format.";
        } else {
            return "";
        }
    }

    //check date input 
    public static String checkDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFormat;
        try {
            //check date format
            dateFormat = formatter.parse(date);
            //check date valid
            String result = checkDateExist(date, formatter);
            return result;
        } catch (ParseException ex) {
            return "Date to correct format(dd/MM/yyyy).";
        }
    }

    //check date valid
    private static String checkDateExist(String date, SimpleDateFormat formatter) {
        formatter.setLenient(false);
        try {
            if (!date.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
                return "Input not valid";
            } else {
                formatter.parse(date.trim());
                return "";
            }
        } catch (ParseException e) {
            return "Your date is not real!";
        }
    }
}
