package hexlet.code;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {
    public static String helloUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");

        //sc.close();

        return userName;
    }

    public static int outputMenu(String[] menuItems,
                                 String headMessage, String choiceMessage, String exitItem,
                                 int repeatIfInputMismatch, String inputMismatchMessage) {

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(headMessage);

        for (int i = 1; i <= menuItems.length; i++) {
            System.out.printf("%2d - %s\n", i, menuItems[i - 1]);
        }

        System.out.printf("%2d - %s\n", 0, exitItem);
        System.out.print(choiceMessage + " ");

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
