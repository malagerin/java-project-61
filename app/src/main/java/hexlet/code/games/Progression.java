package hexlet.code.games;

public class Progression extends GameDummy {
    @Override
    public String getPrompt() {
        return "What number is missing in the progression?";
    }

    @Override
    public String getNextQuestion() {
        int start = rnd.nextInt(20);
        int step = rnd.nextInt(-10,20);
        int length = rnd.nextInt(5, 20);
        int missing = rnd.nextInt(length);
        StringBuilder question = new StringBuilder("");

        for (int i = 0; i < length; i++) {
            if (i == missing) {
                question.append(".. ");
                continue;
            }
            question.append(Integer.toString(start + i * step) + " ");
        }

        correct = Integer.toString(start + missing * step);

        return question.toString();
    }
}
