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
        final int START_UP_TO = 20;
        final int STEP_FROM = -10;
        final int STEP_TO = 20;
        final int LEN_FROM = 5;
        final int LEN_TO = 20;

        int start = rnd().nextInt(START_UP_TO);
        int step = rnd().nextInt(STEP_FROM, STEP_TO);
        int length = rnd().nextInt(LEN_FROM, LEN_TO);
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
