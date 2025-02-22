package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_TO_WIN = 3;

    public static int getRoundsToWin() {
        return ROUNDS_TO_WIN;
    }

    public static void startGame(String gameDescription, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(gameDescription);

        for (String[] round : questionsAndAnswers) {
            System.out.println("Question: " + round[0]);
            System.out.print("Your answer: ");
            var answer = scanner.nextLine();

            if (answer.equals(round[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }
}
