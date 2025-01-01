package hexlet.code;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

import hexlet.code.Cli;
import hexlet.code.games.*;

public class Engine {
	public static int correctRoundsExpected = 3;
	public static int roundsExpected = 3;
	public static String winMessage = "Congratulations, %s!";
	public static String loseMessage = "You lose, %s!";
	public static String prompt = "Your answer:";
	public static String correctMessage = "Correct!";
	public static String incorrectMessage = "'%s' is wrong answer ;(. Correct answer was '%s'";

	public static void onlyCorrectCounts() {
		roundsExpected = Integer.MAX_VALUE;
	}
	
	public static void runGame(GameOutput Game) {
		if (correctRoundsExpected < roundsExpected) {
			InvalidParameterException e = new InvalidParameterException("Rounds are set incorrectly!");
			throw e;
		}

		int i = roundsExpected;

		Scanner sc = new Scanner(System.in);
		String usr = Cli.helloUser();
		int correctRounds = 0;
		String expectedAnswer, userAnswer;

		while (i-- != 0) {
			System.out.println(Game.getNextQuestion());
			expectedAnswer = Game.getExpected();

			System.out.print(prompt + " ");
			userAnswer = sc.next().strip();

			if (expectedAnswer.equals(userAnswer)) {
				System.out.println(correctMessage);
				correctRounds++;
			} else {
				System.out.printf(incorrectMessage + "\n", userAnswer, expectedAnswer);
			}

			if (correctRounds == correctRoundsExpected) {
				System.out.printf(winMessage + "\n", usr);
				return;
			}
		}

		System.out.printf(loseMessage + "\n", usr);
	}

}