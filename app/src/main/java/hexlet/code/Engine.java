package hexlet.code;

import java.security.InvalidParameterException;
import java.util.Scanner;

import hexlet.code.games.GameOutput;

public class Engine {

    //and here comes another unnecessary finals
    private final static int correctRoundsExpected = 3;
    private static int roundsExpected = 3;
    private final static String winMessage = "Congratulations, %s!";
    private final static String loseMessage = "You lose, %s!";
    private final static String questionMessage = "Question:";
    private final static String prompt = "Your answer:";
    private final static String correctMessage = "Correct!";
    private final static String incorrectMessage = "'%s' is wrong answer ;(. Correct answer was '%s'";

    public static void onlyCorrectCounts() {
        roundsExpected = correctRoundsExpected; //Integer.MAX_VALUE - 1;
    }

    public static void runGame(GameOutput game) {
        if (correctRoundsExpected < roundsExpected) {
            InvalidParameterException e = new InvalidParameterException("Rounds are set incorrectly!");
            throw e;
        }

        int i = roundsExpected;

        Scanner sc = new Scanner(System.in);
        String usr = Cli.helloUser();
        int correctRounds = 0;
        String expectedAnswer;
        String userAnswer;

        System.out.println(game.getPrompt());

        while (i-- != 0) {
            System.out.println(questionMessage + " " + game.getNextQuestion());
            expectedAnswer = game.getExpected();

            System.out.print(prompt + " ");
            userAnswer = sc.next().strip();

            if (expectedAnswer.equals(userAnswer)) {
                System.out.println(correctMessage);
                correctRounds++;
            } else {
                System.out.printf(incorrectMessage + "\n", userAnswer, expectedAnswer);
                //wtf. Wrong answer just stops the game?
                System.out.println("Let's try again, " + usr + "!");
                return;
            }

            if (correctRounds == correctRoundsExpected) {
                System.out.printf(winMessage + "\n", usr);
                return;
            }
        }

        System.out.printf(loseMessage + "\n", usr);
    }

}

