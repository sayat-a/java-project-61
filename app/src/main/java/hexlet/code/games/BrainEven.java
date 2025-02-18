package hexlet.code;
import java.util.Random;
import java.util.Scanner;


public class BrainEven {
    private static final int ROUNDS_TO_WIN = 3;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var correctAnswers = 0;

        while (correctAnswers < ROUNDS_TO_WIN) {
            var number = random.nextInt(100); // Генерируем случайное число от 0 до 99
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            var answer = scanner.nextLine();

            var correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
