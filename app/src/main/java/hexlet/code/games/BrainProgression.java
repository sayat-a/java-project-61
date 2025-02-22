package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class BrainProgression {
    private static final String GAME_DESCRIPTION = "What number is missing "
            + "in the progression?";

    public static String[] generateProgression() {
        Random random = new Random();
        final int PROGRESSION_LENGTH = 10;
        final int MAX_STEP_NUMBER = 10;
        final int MAX_RANDOM_NUMBER = 10;
        var step = random.nextInt(MAX_STEP_NUMBER) + 1;
        var begin = random.nextInt(MAX_RANDOM_NUMBER) + 1;
        int[] progression = new int[PROGRESSION_LENGTH];

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = begin + i * step;
        }

        var missingIndex = random.nextInt(PROGRESSION_LENGTH);
        var answer = progression[missingIndex];
        progression[missingIndex] = -1;

        String[] formattedProgression = new String[11];
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            formattedProgression[i] = (progression[i] == -1) ? ".." : String.valueOf(progression[i]);
        }
        formattedProgression[10] = String.valueOf(answer);

        return formattedProgression;
    }

    public static void start() {
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            var progressionData = generateProgression();
            var question = String.join(" ", java.util.Arrays.copyOf(progressionData, 10));
            var answer = progressionData[10];

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }
}
