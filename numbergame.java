`
import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int totalScore = 0;
        boolean playAgain;

        System.out.println(" Welcome to the Number Guessing Game!");

        do {
            int randomNumber = rand.nextInt(max - min + 1) + min;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.printf("Guess a number between %d and %d. You have %d attempts.%n", min, max, maxAttempts);

            while (attemptsLeft > 0) {
                System.out.print(" Enter your guess: ");
                int guess = sc.nextInt();
                attemptsLeft--;

                if (guess < randomNumber) {
                    System.out.println(" Too LOW!");
                } else if (guess > randomNumber) {
                    System.out.println("Too HIGH!");
                } else {
                    System.out.println("correct!  The number was " + randomNumber);
                    guessedCorrectly = true;
                    totalScore += 10;  // score +10 for correct guess
                    break;
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("out of attempts! The number was: " + randomNumber);
                }
            }

            System.out.println("Do you want to play again? (yes/no): ");
            sc.nextLine(); // consume newline
            String response = sc.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

        } while (playAgain);

        System.out.println("Game Over!");
        System.out.println("Your total score: " + totalScore);
        sc.close();
    }
}
