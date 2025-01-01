package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class GameDummy implements GameOutput {

    //protected Random rnd = new Random();
    //protected Scanner sc = new Scanner(System.in);
    //protected String correct = "";

    //idiotic way to do it:
    private Random rnd_place = new Random();
    protected final Random rnd() {
        return rnd_place;
    }

    private Scanner _sc = new Scanner(System.in);
    protected final Scanner sc() {
        return _sc;
    }

    private String correct = "";
    protected final void setCorrect(String corr) {
        correct = corr;
    }

    public abstract String getPrompt();
    public abstract String getNextQuestion();

    @Override
    public final String getExpected() {
        return correct;
    }
}
