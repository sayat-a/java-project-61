package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class BrainProgression {
    private static final String GAME_DESCRIPTION = "What number is missing "
            + "in the progression?";
    private static final int PROGRESSION_LENGTH = 10;

    public static String[] generateProgression() {
        Random random = new Random();
        final int maxStepNumber = 10;
        final int maxRandomNumber = 10;
        var step = random.nextInt(maxStepNumber) + 1;
        var begin = random.nextInt(maxRandomNumber) + 1;
        int[] progression = new int[PROGRESSION_LENGTH];

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = begin + i * step;
        }

        var missingIndex = random.nextInt(PROGRESSION_LENGTH);
        var answer = progression[missingIndex];
        progression[missingIndex] = -1;

        String[] formattedProgression = new String[PROGRESSION_LENGTH + 1];
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            formattedProgression[i] = (progression[i] == -1) ? ".." : String.valueOf(progression[i]);
        }
        formattedProgression[PROGRESSION_LENGTH] = String.valueOf(answer);

        return formattedProgression;
    }

    public static void start() {
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            var progressionData = generateProgression();
            var question = String.join(" ", java.util.Arrays.copyOf(progressionData, PROGRESSION_LENGTH));
            var answer = progressionData[PROGRESSION_LENGTH];

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }
}
