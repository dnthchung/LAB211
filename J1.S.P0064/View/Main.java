/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

public class Main {

    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
        while (true) {
            displayMenu();

            //enter option
            int option = Utility.getInt("Enter option: ", "Wrong", 1, 5);

            switch (option) {
                case 1:
                    //1. Enter the information for 11 countries in Southeast Asia.
                    view.inputCountry();
                    break;
                case 2:
                    //2. Display the information of country you've just input
                    view.displayCountryJustInput();
                    break;
                case 3:
                    //Search the information of country by user-entered name
                    view.searchCountryByName();
                    break;
                case 4:
                    //Display the information of countries sorted name in ascending order
                    view.sortAscendingCountryByName();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }
}
