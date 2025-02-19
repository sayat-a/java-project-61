package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class BrainPrime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given " +
            "number is prime. Otherwise answer 'no'.";

    public static boolean isPrime(int num) {
        for (var i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            Random random = new Random();
            var number = random.nextInt(100);
            var question = String.valueOf(number);
            var answer = (isPrime(number)) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }
}
