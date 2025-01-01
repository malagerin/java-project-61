package hexlet.code.games;

public final class Calc extends GameDummy {
    @Override

    public String getPrompt() {
        return "What is the result of the expression?";
    }

    @Override
    public String getNextQuestion() {
        final int MAX_NUM = 100;
        final int MAX_ACT = 3;
        int num1 = rnd().nextInt(MAX_NUM);
        int num2 = rnd().nextInt(MAX_NUM);
        int action = rnd().nextInt(MAX_ACT);
        String question = "";

        switch (action) {
            case 0:
                //addition
                question = num1 + " + " + num2;
                setCorrect(Integer.toString(num1 + num2));
                break;
            case 1:
                //subtraction
                question = num1 + " - " + num2;
                setCorrect(Integer.toString(num1 - num2));
                break;
            case 2:
                //multiplication
                question = num1 + " * " + num2;
                setCorrect(Integer.toString(num1 * num2));
                break;
            default:
                //no defaults
                break;
        }
        return question;
    }
}
