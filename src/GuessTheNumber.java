import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNum = 1;
        int maxNum = 100;
        int attempts = 10; // Changed limit to 10 attempts
        int rounds = 0;
        int score = 0;

        while (true) {
            System.out.println("\n--- Round " + (rounds + 1) + " ---");
            if (guessNumber(minNum, maxNum, attempts, random, scanner)) {
                score++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }

            rounds++;
        }

        System.out.println("\nGame over!");
        System.out.println("Total rounds played: " + (rounds + 1));
        System.out.println("Your score: " + score);

        scanner.close();
    }

    public static boolean guessNumber(int minNum, int maxNum, int attempts, Random random, Scanner scanner) {
        // Generate a random number within the specified range
        int secretNumber = random.nextInt(maxNum - minNum + 1) + minNum;

        for (int attemptCount = 0; attemptCount < attempts; attemptCount++) {
            System.out.print("Guess the number between " + minNum + " and " + maxNum + ": ");
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                return true;
            } else if (guess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
        return false;
    }
}
