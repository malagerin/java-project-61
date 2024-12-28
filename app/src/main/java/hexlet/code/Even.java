package hexlet.code;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void game() {
        Scanner sc = new Scanner(System.in);

        String usrName = Cli.helloUser();

        int correct = 0, num = 0;
        String ans = "";
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random rnd = new Random();
        while (correct < 3) {

            num = rnd.nextInt(1000);
            System.out.println("Question: " + num);
            System.out.print("Your answer: ");
            ans = sc.next();

            if ((ans.equals("no") && (num % 2 == 1)) ||
                    (ans.equals("yes") && (num % 2 == 0))) {
                correct++;
                System.out.println("Correct!");
            }
            else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'\n",
                        ans, num % 2 == 0? "yes" : "no");
            }
        }

        System.out.println("Congratulations, " + usrName + "!");
    }
}
