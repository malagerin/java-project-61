package hexlet.code;

import java.util.Scanner;

public class App {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String usrName = ""; // Cli.helloUser();
        int res = 10;
        String[] mainMenu = {"Greet"};

        while (res != 0) {
            res = Cli.outputMenu(mainMenu,
                    "Please enter the game number and press Enter.",
                    "Your choice is:","Exit",
                    1, "\n >> Input incorrect, please reenter: ");

            switch (res) {
                case 1:
                    Cli.helloUser();
                    break;
                default:
                    break;
            }
        }

        sc.close();
    }


}
