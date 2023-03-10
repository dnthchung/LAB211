/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


/**
 *
 * @author chungdoan
 */
public class Main {

    public static void main(String[] args) {
        View_Task view = new View_Task();
        while (true) {
            displayMenu();
            int option = Utility.getInt("Option: ", "wrong1", "wrong2", "wrong3", 1, 4);

            switch (option) {
                case 1:
                    // input task
                    view.inputTask();
                    break;
                case 2:
                    // delete task
                    view.deleteTask();
                    break;
                case 3:
                    // display task
                    view.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
