package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class BrainGCD {
    private static final String GAME_DESCRIPTION = "Find the greatest " +
            "common divisor of given numbers.";
    public static int findGCD(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return num1;
    }

    public static void start() {
        Random random = new Random();
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            var number1 = random.nextInt(100);
            var number2 = random.nextInt(100);
            var question = String.format("%d %d", number1, number2);
            var answer = String.valueOf(findGCD(number1, number2));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }
}
