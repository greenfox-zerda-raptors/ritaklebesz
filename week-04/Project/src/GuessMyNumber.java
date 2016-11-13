import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Rita on 2016-11-10.
 */
public class GuessMyNumber {
    static Scanner userInput = new Scanner(System.in);
    static Random random = new Random();
    static int numToGuess;
    static int upperLimit;
    static boolean loopCond;
    static int guessRemaining;
    static int guess;
    static ArrayList<Integer> guessedNumbers = new ArrayList<>();
    static ArrayList<String> tooLow = new ArrayList<>(Arrays.asList("Nope, you're low.", "That's too low.", "Nope, try a higher value."));
    static ArrayList<String> tooHigh = new ArrayList<>(Arrays.asList("Nope, you're high.", "Nope, try a lower value.", "That's too high."));

    public static void main(String[] args) {
        loopCond = true;
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
        guessRemaining = 5;
        System.out.println("Okay, I've got a number.  You should be able to figure that out in 6 goes, let's begin.");
        while (guessRemaining >= 0) {
            try {
                System.out.println("Guess?");
                guess = Integer.parseInt(userInput.nextLine());
                if (guessRemaining == 0) {
                    System.out.println("Sorry, you are out of guesses. The number was: " + numToGuess);
                    guessedNumbers.clear();
                    break;
                } else if (guess == numToGuess) {
                    System.out.println("Great job, you guessed right!");
                    guessedNumbers.clear();
                    break;
                } else {
                    if (guessedNumbers.contains(guess)) {
                        System.out.println("Seriously? You've already guessed that one.");
                    } else if (guess > upperLimit || guess < 1) {
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
        if (guess > numToGuess) {
            System.out.println(tooHigh.get(random.nextInt(tooHigh.size())));
        } else {
            System.out.println(tooLow.get(random.nextInt(tooHigh.size())));
        }
    }
}
