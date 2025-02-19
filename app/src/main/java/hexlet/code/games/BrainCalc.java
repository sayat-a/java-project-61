package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class BrainCalc {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_NUMBER = 100;
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void start() {
        var roundsCount = Engine.getRoundsToWin();
        String[][] questionsAndAnswers = new String[roundsCount][2];
        Random random = new Random();

        for (int i = 0; i < roundsCount; i++) {
            var num1 = random.nextInt(MAX_NUMBER);
            var num2 = random.nextInt(MAX_NUMBER);
            char operator = OPERATORS[random.nextInt(OPERATORS.length)];

            var question = num1 + " " + operator + " " + num2;
            var answer = String.valueOf(calculate(num1, num2, operator));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        Engine.startGame(GAME_DESCRIPTION, questionsAndAnswers);
    }

    private static int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
