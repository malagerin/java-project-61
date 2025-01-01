/**
 * @file Even.java
 * @author AF/Malagerin
 * @brief "game2" file.
 *
 * "Even" "game" is the process where question about oddity of random number are asked.
 * Only 3 correct answers grant an exit from the game.
 * If answer is spelled incorrectly(e.g. 'y' instead of 'yes'), it counts as incorrect.
 */

package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even implements GameOutput {

    private Random rnd = new Random();
    private Scanner sc = new Scanner(System.in);
    private String correct = "";

    @Override
    public String getPrompt() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String getNextQuestion() {
        int num = rnd.nextInt(1000);
        String question = "Question: " + num;
        correct = num % 2 == 0? "yes" : "no";

        return question;
    }

    @Override
    public String getExpected() {
        return correct;
    }
}
