import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    private static final int MAX_ATTEMPTS = 5; 
    private static final int LOWER_BOUND = 1; 
    private static final int UPPER_BOUND = 100; 
    private static int roundsWon = 0; 


    private static int generateRandomNumber(Random random) {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }

    private static boolean playRound(Scanner scanner, int numberToGuess) {
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                guessedCorrectly = true;
                break;
            }
        }

        return guessedCorrectly;
    }

    private static boolean promptPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play another round? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    private static void displayScore() {
        System.out.println("Game over! You won " + roundsWon + " round(s).");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = generateRandomNumber(random);
            boolean roundWon = playRound(scanner, numberToGuess);

            if (roundWon) {
                roundsWon++;
                System.out.println("Congratulations! You've guessed the number correctly.");
            } else {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            playAgain = promptPlayAgain(scanner);
        } while (playAgain);

        displayScore();
        scanner.close();
    }

}