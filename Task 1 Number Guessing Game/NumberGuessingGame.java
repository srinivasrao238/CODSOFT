import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            clearScreen();

            // ANSI escape codes for formatting and coloring
          String cyanBold = "\u001B[1;36m";
          String reset = "\u001B[0m";
          String magentaBold = "\u001B[1;35m";
  
          // Printing the welcome message with formatting and colors
          System.out.println(cyanBold + "=======================================================================================================================================");
          System.out.println("\t\t\t\t\t\tWelcome to the Number Guessing Game");
          System.out.println("=======================================================================================================================================" + reset + "\n");
           // Printing instructions with a different color
          System.out.println(magentaBold + "Instructions:");
          System.out.println("1. The computer will generate a random number between 1 and 100." );
          System.out.println("2. You need to guess the correct number.");
          System.out.println("3. After each guess, you will receive feedback on whether the number is too high or too low.");
          System.out.println("4. Keep guessing until you find the correct number.");
          System.out.println("5. Have fun and enjoy the game!");
          
        // Printing with a default color and formatting
           System.out.println("\u001B[0m");
        

            // Generates a random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;
            int userGuess;
            int attempts = 0;

            do {
                if (attempts > 0) {
                    System.out.print("Give another try: ");
                } else {
                    System.out.print("Guess a number between 1 and 100: ");
                }
                userGuess = sc.nextInt();
                attempts++;
                System.out.println();

                if (userGuess == randomNumber) {
                    System.out.println("\u001B[1;32mCongratulations!\u001B[0m You guessed the correct number in " + attempts + " attempts.");
                } else if (userGuess > randomNumber) {
                    System.out.print("\u001B[1;33mToo High!\u001B[0m ");
                } else {
                    System.out.print("\u001B[1;33mToo Low!\u001B[0m ");
                }
            } while (userGuess != randomNumber);

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);
            System.out.println();
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\u001B[1;31mThank you for playing the Number Guessing Game!\u001B[0m\n");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
