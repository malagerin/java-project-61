package hexlet.code.games;

public final class Progression extends GameDummy {
    @Override
    public String getPrompt() {
        return "What number is missing in the progression?";
    }

    @Override
    public String getNextQuestion() {

        //and another block added due to "excellent" checkstyle
        //while the numbers are just random bounds, not anything more.
        final int startUpTo = 20;
        final int stepFrom = -10;
        final int stepTo = 20;
        final int lenFrom = 5;
        final int lenTo = 20;

        int start = rnd().nextInt(startUpTo);
        int step = rnd().nextInt(stepFrom, stepTo);
        int length = rnd().nextInt(lenFrom, lenTo);
        int missing = rnd().nextInt(length);
        StringBuilder question = new StringBuilder("");

        for (int i = 0; i < length; i++) {
            if (i == missing) {
                question.append(".. ");
                continue;
            }
            question.append(Integer.toString(start + i * step) + " ");
        }

        setCorrect(Integer.toString(start + missing * step));

        return question.toString();
    }
}
