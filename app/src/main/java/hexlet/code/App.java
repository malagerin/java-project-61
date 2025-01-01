/**
 * @file App.java
 * @author AF/Malagerin
 * @brief The app entry point.
 *
 * I believe, the code is pretty self-explaining, but a few comments will follow.
 *
 * Main menu leads to the "games". Control is provided via text string input (not the keystrokes)
 * which should provide required option.
 */


package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.*;

public class App {
    public static final boolean onlyCorrectRoundsAreTakenIntoAccount = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //input
        int res = 10;   //menu result storage
        String[] mainMenu = {"Greet", "Even"}; //menu items storage

        if (onlyCorrectRoundsAreTakenIntoAccount) {
            Engine.onlyCorrectCounts();
        }

        //Exit is provided only when input is '0'
        while (res != 0) {
            //one menu pass
            res = Cli.outputMenu(mainMenu,
                    "Please enter the game number and press Enter.",
                    "Your choice is:","Exit",
                    1, "\n >> Input incorrect, please reenter: ");

            //menu following
            switch (res) {
                case 1:
                    Cli.helloUser(); //greeting
                    break;
                case 2:
                    Engine.runGame(new Even());
                    break;
                default:
                    //No defaults for now
                    break;
            }
        }

        //Closing input stream
        sc.close();
    }

}
