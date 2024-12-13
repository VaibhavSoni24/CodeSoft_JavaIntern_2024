import java.util.Random;
import java.util.Scanner;

public class NumberGame 
{
    public static void main(String[] args)
    {
        try (Scanner scan = new Scanner(System.in))
        {
            Random rand = new Random();
            int totalRounds = 0; // To keep track of rounds played
            int totalWins = 0;   // To keep track of wins
            boolean playAgain = true;
            
            while (playAgain)
            {
                totalRounds++;
                int numberToGuess = rand.nextInt(100) + 1; // Generate a random number between 1 and 100
                int attemptsLeft = 10; // Limit the number of attempts
                boolean guessedCorrectly = false;
                
                System.out.println("Round " + totalRounds + ": Guess the number between 1 and 100.");
                
                while (attemptsLeft > 0 && !guessedCorrectly)
                {
                    System.out.println("You have " + attemptsLeft + " attempts remaining.");
                    System.out.print("Enter your guess: ");
                    int userGuess = scan.nextInt();
                    
                    if (userGuess < numberToGuess)
                    {
                        System.out.println("Your guess is too low.");
                    }
                    else if (userGuess > numberToGuess)
                    {
                        System.out.println("Your guess is too high.");
                    }
                    else
                    {
                        System.out.println("Congratulations! You've guessed the correct number.");
                        guessedCorrectly = true;
                        totalWins++;
                    }
                    attemptsLeft--;
                }

                if (!guessedCorrectly)
                {
                    System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
                }

                System.out.println("Your score: " + totalWins + " out of " + totalRounds + " rounds.");
                System.out.print("Would you like to play another round? (yes/no): ");
                String response = scan.next();
                
                if (response.equalsIgnoreCase("no"))
                {
                    playAgain = false;
                    System.out.println("Thank you for playing! Final score: " + totalWins + " out of " + totalRounds + " rounds.");
                }
            }
        }
    }
}