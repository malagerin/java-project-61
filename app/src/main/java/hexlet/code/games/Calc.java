package hexlet.code.games;

public final class Calc extends GameDummy {
    @Override

    public String getPrompt() {
        return "What is the result of the expression?";
    }

    @Override
    public String getNextQuestion() {
        final int maxNum = 100;
        final int maxAct = 3;
        int num1 = rnd().nextInt(maxNum);
        int num2 = rnd().nextInt(maxNum);
        int action = rnd().nextInt(maxAct);
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
