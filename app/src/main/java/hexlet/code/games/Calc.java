package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc extends GameDummy{
    @Override

    public String getPrompt() {
        return "What is the result of the expression?";
    }

    @Override
    public String getNextQuestion() {
        int num1 = rnd.nextInt(100);
        int num2 = rnd.nextInt(100);
        int action = rnd.nextInt(3);
        String question = "";

        switch (action)
        {
            case 0:
                //addition
                question = num1 + " + " + num2;
                correct = Integer.toString(num1 + num2);
                break;
            case 1:
                //subtraction
                question = num1 + " - " + num2;
                correct = Integer.toString(num1 - num2);
                break;
            case 2:
                //multiplication
                question = num1 + " * " + num2;
                correct = Integer.toString(num1 * num2);
                break;
            default:
                //no defaults
                break;
        }
        return question;
    }
}
