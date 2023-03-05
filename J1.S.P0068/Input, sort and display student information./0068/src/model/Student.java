/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chungdoan
 */
public class Student {

    //attribute
    private String name;
    private float mark;
    private String classes;

    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * Constructor with parameters
     *
     * @param name
     * @param mark
     * @param classes
     */
    public Student(String name, float mark, String classes) {
        this.name = name;
        this.mark = mark;
        this.classes = classes;
    }

    //getter
    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }

    public String getClasses() {
        return classes;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    //toString method
    @Override
    public String toString() {
        return String.format("Name: %s\n"+ "Classer: %s\n"+ "Mark: %s", getName(), getClasses(), getMark()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
