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
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    //private static boolean onlyCorrectRounds = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //input
        int res = Integer.MAX_VALUE;   //menu result storage
        String[] mainMenu = {
            "Greet",
            "Even",
            "Calc",
            "GCD",
            "Progression",
            "Prime"
        }; //menu items storage

        final int menuGreet = 1;
        final int menuEven = 2;
        final int menuCalc = 3;
        final int menuGCD = 4;
        final int menuProgr = 5;
        final int menuPrime = 6;
        //        if (onlyCorrectRounds) {
        //            Engine.onlyCorrectCounts();
        //        }

        //Exit is provided only when input is '0'
        while (res != 0) {
            //one menu pass
            res = Cli.outputMenu(mainMenu,
                    "Please enter the game number and press Enter.",
                    "Your choice is:", "Exit",
                    1, "\n >> Input incorrect, please reenter: ");

            //menu following
            switch (res) {
                case menuGreet:
                    Cli.helloUser(); //greeting
                    break;
                case menuEven:
                    Engine.runGame(new Even());
                    break;
                case menuCalc:
                    Engine.runGame(new Calc());
                    break;
                case menuGCD:
                    Engine.runGame(new GCD());
                    break;
                case menuProgr:
                    Engine.runGame(new Progression());
                    break;
                case menuPrime:
                    Engine.runGame(new Prime());
                    break;
                default:
                    //No defaults for now
                    break;
            }

            break; //why in the Force do Hexlet need one run only?!
        }

        //Closing input stream
        sc.close();
    }

}
