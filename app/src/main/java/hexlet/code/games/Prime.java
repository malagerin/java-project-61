package hexlet.code.games;

public final class Prime extends GameDummy {
    private final int[] primelist = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97
    }; //it's not a magic number collection!!!

    @Override
    public String getPrompt() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String getNextQuestion() {
        int num = rnd().nextInt(2, 100);

        setCorrect("no");
        for (int x : primelist) {
            if (x == num) {
                setCorrect("yes");
                break;
            }
        }

        return Integer.toString(num);
    }
}
