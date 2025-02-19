package hexlet.code;
import hexlet.code.games.BrainEven;
import hexlet.code.games.BrainCalc;
import hexlet.code.games.BrainGCD;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var choice = scanner.nextLine();
        switch (choice) {
            case "1":
                Cli.greetUser();
                break;
            case "2":
                BrainEven.start();
                break;
            case "3":
                BrainCalc.start();
                break;
            case "4":
                BrainGCD.start();
                break;
            case "0":
                break;
        }
    }
}
