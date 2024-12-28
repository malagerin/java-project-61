package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static String helloUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");

        sc.close();

        return userName;
    }
}
