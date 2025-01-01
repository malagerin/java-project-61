package hexlet.code;

import java.security.InvalidParameterException;
import java.util.Scanner;

import hexlet.code.games.GameOutput;

public class Engine {

    //and here comes another unnecessary finals
    private final static int correctRoundsExpected = 3;
    private static int roundsExpected = 3;
    private final static String WIN_MESSAGE = "Congratulations, %s!";
    private final static String LOSE_MESSAGE = "You lose, %s!";
    private final static String QUESTION_MESSAGE = "Question:";
    private final static String PROMPT = "Your answer:";
    private final static String CORRECT_MESSAGE = "Correct!";
    private final static String INCORRECT_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'";

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
            System.out.println(QUESTION_MESSAGE + " " + game.getNextQuestion());
            expectedAnswer = game.getExpected();

            System.out.print(PROMPT + " ");
            userAnswer = sc.next().strip();

            if (expectedAnswer.equals(userAnswer)) {
                System.out.println(CORRECT_MESSAGE);
                correctRounds++;
            } else {
                System.out.printf(INCORRECT_MESSAGE + "\n", userAnswer, expectedAnswer);
                //wtf. Wrong answer just stops the game?
                System.out.println("Let's try again, " + usr + "!");
                return;
            }

            if (correctRounds == correctRoundsExpected) {
                System.out.printf(WIN_MESSAGE + "\n", usr);
                return;
            }
        }

        System.out.printf(LOSE_MESSAGE + "\n", usr);
    }

}

