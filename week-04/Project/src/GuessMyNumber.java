import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Rita on 2016-11-10.
 */
public class GuessMyNumber {
    static Scanner userInput = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int numToGuess;
        int upperLimit;
        boolean loopCond = true;
        while (loopCond) {
            System.out.println("Enter a top number in the range of 1 and 2,147,483,647, or 0 to quit?");
            try {
                upperLimit = Integer.parseInt(userInput.nextLine());
                if (upperLimit != 0) {
                    numToGuess = generateRandomNumber(upperLimit);
                    guessingGame(numToGuess, upperLimit);
                    System.out.print("Try again? ");
                } else {
                    System.out.println("It was fun playing. Bye!");
                    userInput.close();
                    loopCond = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value.");
            } catch (IllegalArgumentException e) {
                System.out.println("You must enter a positive number.");
            }
        }
    }

    public static int generateRandomNumber(int upperLimit) {
        return random.nextInt(upperLimit) + 1;
    }

    public static void guessingGame(int numToGuess, int upperLimit) {
        int guessRemaining = 5;
        int guess;
        ArrayList<Integer> guessedNumbers = new ArrayList<>();
        System.out.println("Okay, I've got a number.  You should be able to figure that out in 6 goes, let's begin.");
        while (guessRemaining >= 0) {
            try {
                System.out.println("Guess?");
                guess = Integer.parseInt(userInput.nextLine());
                if (guessRemaining == 0) {
                    System.out.println("Sorry, you are out of guesses. The number was: " + numToGuess);
                    break;
                } else if (guess == numToGuess) {
                    System.out.println("Great job, you guessed right!");
                    break;
                } else {
                    if (guessedNumbers.contains(guess)) {
                        System.out.println("Seriously? You've already guessed that one.");
                    } else if (guess > upperLimit) {
                        System.out.println("Seriously? That's not even within the range.");
                    } else {
                        guessedNumbers.add(guess);
                        evaluateGuess(guess, numToGuess);
                        System.out.println("You've got " + guessRemaining + " guesses left.");
                        guessRemaining--;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value");
            }
        }
    }

    public static void evaluateGuess(int guess, int numToGuess) {
        ArrayList<String> tooLow = new ArrayList<>();
        tooLow.add("Nope, you're low.");
        tooLow.add("That's too low.");
        tooLow.add("Nope, try a higher value.");
        ArrayList<String> tooHigh = new ArrayList<>();
        tooHigh.add("Nope, you're high.");
        tooHigh.add("Nope, try a lower value.");
        tooHigh.add("That's too high.");
        if (guess > numToGuess) {
            System.out.println(tooHigh.get(random.nextInt(tooHigh.size())));
        } else {
            System.out.println(tooLow.get(random.nextInt(tooHigh.size())));
        }
    }
}
