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
    private String name;
    private String classes;
    private double maths;
    private double physical;
    private double chemistry;
    
    
    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * Constructor
     * @param name
     * @param classes
     * @param maths
     * @param physical
     * @param chemistry 
     */
    public Student(String name, String classes, double maths, double physical, double chemistry) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public double getMaths() {
        return maths;
    }

    public double getPhysical() {
        return physical;
    }

    public double getChemistry() {
        return chemistry;
    }
    
    public double getAverage(){
        return (getMaths() + getPhysical() + getChemistry()) / 3;
    }
//___________________________________________________________
   
    public String getType(){
         if (getAverage() > 7.5) {
            return "A";
        }else if( getAverage() >= 6 && getAverage() <= 7.5) {
            return "B";
        }else if (getAverage() >= 4 && getAverage() < 6) {
            return "C";
        }else {
            return "D";
        }
    }
//___________________________________________________________
    
    
    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    //___________________________________________________________

    
    public void display() {
        System.out.format("Name: %s\n"
                + "Classes: %s\n"
                + "AVG: %.2f\n"
                + "Type: %s\n", getName(), getClasses(), getAverage(), getType());
    }
    
    
    
    
}
