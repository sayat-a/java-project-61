package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class BrainProgression {
    private static final String GAME_DESCRIPTION = "What number is missing" +
            "in the progression?";

    public static String[] generateProgression() {
        Random random = new Random();
        var step = random.nextInt(10) + 1;
        var begin = random.nextInt(100) + 1;
        int[] progression = new int[10];

        for (int i = 0; i < 10; i++) {
            progression[i] = begin + i * step;
        }

        var missingIndex = random.nextInt(10);
        var answer = progression[missingIndex];
        progression[missingIndex] = -1;

        String[] formattedProgression = new String[11];
        for (int i = 0; i < 10; i++) {
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
