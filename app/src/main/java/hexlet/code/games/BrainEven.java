package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;


public class BrainEven {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number " +
        "is even, otherwise answer 'no'.";

    public static void start() {
        Random random = new Random();
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            var number = random.nextInt(100);
            var question = String.valueOf(number);
            var answer = (number % 2 == 0) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }
}
