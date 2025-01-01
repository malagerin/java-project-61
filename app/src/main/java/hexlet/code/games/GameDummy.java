package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class GameDummy implements GameOutput{

    protected Random rnd = new Random();
    protected Scanner sc = new Scanner(System.in);
    protected String correct = "";

    public abstract String getPrompt();
    public abstract String getNextQuestion();

    @Override
    public String getExpected() {
        return correct;
    }
}
