/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import model.EastAsiaCountry;

public class ManageEastAsiaCountries {
    ArrayList<EastAsiaCountry> countryList;

    public ManageEastAsiaCountries() {
        countryList = new ArrayList<>();
//        countryList.add(new EastAsiaCountry("VN", "Viet Nam", 1000, "asasdasd"));
//        countryList.add(new EastAsiaCountry("IDN", "Indonesia", 1000, "asasdasd"));
//        countryList.add(new EastAsiaCountry("PL", "Philipin", 1000, "asasdasd"));
    }

    public ArrayList<EastAsiaCountry> getCountryList() {
        return countryList;
    }
    
    
    
    public boolean checkDuplicateCode(String code) {
        for (EastAsiaCountry country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicateName(String name) {
        for (EastAsiaCountry country : countryList) {
            if (country.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void addToCountryList(String code, String name, float area, String terrain) {
        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);
        countryList.add(country);
    }

    public void search(ArrayList<EastAsiaCountry> listFound, String name) {
        name = name.toUpperCase();
        //loop through all element
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            // check if an country contain name, add to listFound
            if (eastAsiaCountry.getName().toUpperCase().contains(name)) {
                listFound.add(eastAsiaCountry);
            }
        }
    }

    public void addAllElement(ArrayList<EastAsiaCountry> sortList) {
        sortList.addAll(countryList);
    }

    public void sortElement(ArrayList<EastAsiaCountry> sortList) {
        Collections.sort(sortList, new Comparator<EastAsiaCountry>() {
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
    
    
}
