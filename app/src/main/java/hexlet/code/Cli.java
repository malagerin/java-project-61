/**
 * @file Cli.java
 * @author AF/Malagerin
 * @brief File contains some text interations.
 *
 * I believe Hexlet course developers wanted to name this part after Command Line Interface,
 * but this is way too big...
 *
 * helloUser - greeting method
 * outputMenu - way to output specified menu with specified items.
 */

package hexlet.code;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {

    /**
     * A small dialog to ask user name.
     * @return User name as string.
     */
    public static String helloUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");

        //sc.close();

        return userName;
    }

    /**
     * Outputs text menu consisting of specified items, gets a user's answer.
     * @param menuItems Array of menu items.
     * @param headMessage Message to output before menu items.
     * @param choiceMessage Prompt for user input.
     * @param exitItem Message displayed on exit.
     * @param repeatIfInputMismatch Times of repeating after incorrect input.
     * @param inputMismatchMessage Message displayed on typo or another incorrect way to input.
     * @return menu item number, or -1 if input is (finally) incorrect.
     */
    public static int outputMenu(String[] menuItems,
                                 String headMessage, String choiceMessage, String exitItem,
                                 int repeatIfInputMismatch, String inputMismatchMessage) {

        Scanner sc = new Scanner(System.in); //input
        System.out.println();
        System.out.println(headMessage);

        //output the menu itself
        for (int i = 1; i <= menuItems.length; i++) {
            System.out.printf("%2d - %s\n", i, menuItems[i - 1]);
        }

        System.out.printf("%2d - %s\n", 0, exitItem);
        System.out.print(choiceMessage + " ");

        //if the input is faulty, either repeat or return "wrong" value
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            if (repeatIfInputMismatch != 0) {
                System.out.print(inputMismatchMessage);
                return outputMenu(menuItems, headMessage, choiceMessage,
                        exitItem, repeatIfInputMismatch - 1,
                        inputMismatchMessage);
            } else {
                return -1;
            }

        }
    }
}
