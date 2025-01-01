package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class GameDummy implements GameOutput {

    //protected Random rnd = new Random();
    //protected Scanner sc = new Scanner(System.in);
    //protected String correct = "";

    //idiotic way to do it:
    private Random _rnd = new Random();
    protected Random rnd() {
        return _rnd;
    }

    private Scanner _sc = new Scanner(System.in);
    protected Scanner sc() {
        return _sc;
    }

    private String correct = "";
    protected void setCorrect(String corr) {
        correct = corr;
    }

    public abstract String getPrompt();
    public abstract String getNextQuestion();

    @Override
    public String getExpected() {
        return correct;
    }
}
