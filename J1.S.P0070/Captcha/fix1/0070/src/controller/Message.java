/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ResourceBundle;

/**
 *
 * @author chungdoan
 */
public class Message {
    public static String getMessage(ResourceBundle language, String key) {
        return language.getString(key);
    }
}
