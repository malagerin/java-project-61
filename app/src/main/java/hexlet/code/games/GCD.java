package hexlet.code.games;

public final class GCD extends GameDummy {
    @Override
    public String getPrompt() {
        return "Find the greatest common divisor of given numbers.";
    }

    private int gcd(int a, int b) {
        //don't want to pull full library - e.g. Guava - just for gcd
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String getNextQuestion() {
        final int MAXNUM = 50;
        int num1 = rnd().nextInt(MAXNUM);
        int num2 = rnd().nextInt(MAXNUM);
        setCorrect(Integer.toString(gcd(num1, num2)));
        return num1 + " " + num2;
    }
}
