import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            if (playGame()) {
                score++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Your final score is: " + score);
        scanner.close();
    }

    private static boolean playGame() {
        Random random = new Random();
        int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        int attempts = 0;

        System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ". You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return true;
            }

            int remainingAttempts = MAX_ATTEMPTS - attempts;
            if (remainingAttempts > 0) {
                System.out.println("You have " + remainingAttempts + " attempts left.");
            } else {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
                return false;
            }
        }
        return false;
    }
}
