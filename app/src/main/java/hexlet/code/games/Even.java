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

public final class Even extends GameDummy {
    @Override
    public String getPrompt() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String getNextQuestion() {
        final int maxNum = 1000;
        int num = rnd().nextInt(maxNum);
        String question = Integer.toString(num);
        setCorrect(num % 2 == 0 ? "yes" : "no");

        return question;
    }
}
