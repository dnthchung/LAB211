/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class EastAsiaCountry extends Country{
    private String terrain;
    
    /**
     * Constructor full parameter
     * @param code
     * @param name
     * @param area
     * @param terrain 
     */
    public EastAsiaCountry(String code, String name, float area, String terrain) {
        super(code, name, area);
        this.terrain = terrain;
    }
    
    /**
     * Constructor no parameter
     */
    public EastAsiaCountry() {
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public void display() {
        super.display(); 
        System.out.format("%-15s\n", terrain);
    }
    
    
    

    
    

}
