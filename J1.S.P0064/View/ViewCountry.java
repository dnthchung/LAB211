/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.EastAsiaCountry;

public class ViewCountry {

    ManageEastAsiaCountries manage = new ManageEastAsiaCountries();

    void inputCountry() {
        String code, name, terrain;
        float area;
        //input information
        while (true) {
            code = Utility.getString("Enter code of country: ", "Wrong", Utility.REGEX_CODE);
            //check duplicate code
            // => true => duplicate code => bao loi => nhap lai
            // => false => not duplicate  => break => nhap tiep
            if (manage.checkDuplicateCode(code)) {
                System.out.println("DUPLICATE CODE !!");
            } else {
                break;
            }
        }
        while (true) {
            name = Utility.getString("Enter name of country: ", "Wrong", Utility.REGEX_NAME);
            //check duplicate code
            // => true => duplicate code => bao loi => nhap lai
            // => false => not duplicate  => break => nhap tiep
            if (manage.checkDuplicateName(name)) {
                System.out.println("DUPLICATE NAME !!");
            } else {
                break;
            }
        }

        area = Utility.getFloat("Enter area: ", "Wrong", 0, Float.MAX_VALUE);
        terrain = Utility.getString("Enter terrain of country: ", "Wrong", Utility.REGEX_NAME);

        //add to list
        manage.addToCountryList(code, name, area, terrain);
        System.out.println("ADD SUCCESSFULL !!");
    }

    void displayCountryJustInput() {
        
        
        ArrayList<EastAsiaCountry> countryList = manage.getCountryList();
        
        //check list size
        if (countryList.isEmpty()) {
//            System.out.println("NOT COUNTRY TO DISPLAY !!");
            return;
        }
        
        //get country just input = countrry at last index
        EastAsiaCountry country = countryList.get(countryList.size() - 1);

        //display
        System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Area", "Terrain");
        country.display();
    }

    void searchCountryByName() {
        // tao ra cai gio countryListFOund
        ArrayList<EastAsiaCountry> listFound = new ArrayList<>();
        //input name
        String name = Utility.getString("Enter name of country: ", "Wrong", Utility.REGEX_NAME);
        //tim quoc gia by contain
        manage.search(listFound, name);
        //not found
        if (listFound.isEmpty()) {
            System.out.println("NOT FOUND !!");
        } else {
            //found
            System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Area", "Terrain");
            for (EastAsiaCountry eastAsiaCountry : listFound) {
                eastAsiaCountry.display();
            }
        }

    }

    void sortAscendingCountryByName() {
        if (manage.getCountryList().isEmpty()) {
            return;
        }
        
        // sort list
        ArrayList<EastAsiaCountry> sortList = new ArrayList<>();

        // them cac phan tu vao ben trorng sortList
        manage.addAllElement(sortList);

        // sort phan tu ben trong sortList
        manage.sortElement(sortList);

        //hien thi ra phan tu ben trong sortList
        System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Area", "Terrain");
        for (EastAsiaCountry eastAsiaCountry : sortList) {
            eastAsiaCountry.display();
        }

    }

}
