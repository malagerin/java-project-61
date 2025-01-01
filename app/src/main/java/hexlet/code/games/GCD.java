package hexlet.code.games;

public class GCD extends GameDummy {
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
        int num1 = rnd.nextInt(50);
        int num2 = rnd.nextInt(50);
        correct = Integer.toString(gcd(num1, num2));
        return num1 + " " + num2;
    }
}
