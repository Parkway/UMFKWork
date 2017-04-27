import javax.swing.*;
import java.util.Random;

/*****************************************************************************************
 * Created by Lance Douglas on 4/21/2017  -  Quiz 5                                      *
 *                                                                                       *
 * //This is just a small game where the player must correctly guess a random number     *
 * //assigned by the machine. Really simple stuff, nothing particularly new here.        *
 * //Have fun.                                                                           *
 *                                                                                       *
 * Haha, just kidding, that's boring as all hell. Here's somma that new shit:            *
 * Attempt counts.  Rounds.  Error catching.  Exception handling. Easter eggs.           *
 * Individual methods for:  Randomization.  Gameplay.  Next game.                        *
 *                                                                                       *
 * @version 1.01 GuessingGame.java                                                       *
 * Changelog: Did some cleanup with recursive integers - round was not needed in game(). *
 *                                                                                       *
 * Disclaimer: Flying spaghetti code - Prepare the colander hat.                         *
 ****************************************************************************************/

public class GuessingGame {

    static int attempt = 11;
    static int round = 1;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "This is just a simple guessing game.\n" +
                        "As the player, your job is to guess a number\n" +
                        "chosen by the computer, between 0-100.\n" +
                        "You have ten tries. Enjoy.");
        randomizer();
    }

    /**
     * This method is responsible for the randomization
     * of the secret number. It has to be its own special
     * method due to the recursive properties of game().
     * To put it bluntly, the number would reshuffle
     * every guess if the random function was in game().
     */
    private static void randomizer() {
        Random random = new Random();
        int number = random.nextInt(100);
        game(attempt, number);
    }

    /**
     * This method handles the actual gameplay of the... game.
     * It counts attempts, holds the secret number, and accounts for any
     * and all issues that could be presented by the user or to the user.
     * It checks for a blank entry, a number outside of the 0-100 parameter,
     * and has a couple funnies in it. If the player enters an invalid option,
     * an attempt is not taken away - attempts are only revoked for valid tries.
     * Includes NumberFormatException for any non-integers entered into the guess
     * input area.
     * @param attempt
     * @param number
     */
    private static void game(int attempt, int number) {
        try {
            //Define guess by default.
            int guess = -1;
            //While loop for while the number is wrong.
            while (guess != number) {
                //while loop for the attempt countdown.
                while (attempt > 1) {
                    //Decrement countdown instantly.
                    attempt--;
                    /*  This is gross, I know. :(.
                        Basically, showInputDialogs only read Strings, not ints.
                        So I had to convert the guess into a String, acknowledge it, and
                        then convert it back into an int for reading.
                    */
                    String guessStr = Integer.toString(guess);
                    guessStr = JOptionPane.showInputDialog("Enter your guess:\nAttempts remaining: " + attempt);
                    //If the input is empty, just restart. No need for an error message.
                    if (guessStr.equals("")) {
                        attempt++;
                        game(attempt, number);
                    }
                    guess = Integer.parseInt(guessStr);

                    /*  If the guess is less than 0, tell them its too low.
                        "" Higher than 100, too high.
                        If equals 420, make shitty prepubescent weed joke. Lmao.
                        Each time, give back an attempt for invalid entry.
                    */
                    if (guess <= 0) {
                        JOptionPane.showMessageDialog(null,
                                    "Guess must be a positive number.");
                        attempt++;
                        game(attempt, number);
                    } else if (guess == 420) {
                        JOptionPane.showMessageDialog(null,
                                    "Too fukn high lmao.");
                        attempt++;
                        game(attempt, number);
                    } else if (guess > 100) {
                        JOptionPane.showMessageDialog(null,
                                    "The number must be less than 100.");
                        attempt++;
                        game(attempt, number);
                    }

                    /*  If the guess is less than the number, say it's too low.
                        If it's too high, say it's too high.
                        If it's neither too high or too low, it's obviously
                        correct, so acknowledge the victory and call again()
                        method.
                     */
                    if (guess < number) {
                        JOptionPane.showMessageDialog(null,
                                    "Too low, guess again:");
                    } else if (guess > number) {
                        JOptionPane.showMessageDialog(null,
                                    "Too high, guess again:");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                    "Correct, the number was " + number + "!");
                        again();
                    }
                }
                /*  This is post-attempt while loop. If they run out of attempts, game over.
                    Prompt for next attempt with again().
                */
                JOptionPane.showMessageDialog(null,
                        "You ran out of attempts.\nGame over.");
                again();
            }
        //Catch NFE and NPE.
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number, not a string.");
            attempt++;
            game(attempt, number);
        } catch (NullPointerException NPE) {
            System.exit(0);
        }
    }

    /**
     * This method is responsible for managing the count of the rounds
     * and handling whether or not the game is to be played another time.
     */
    private static void again() {
        //JOP Asking if the player wants to play again.
        int again = JOptionPane.showConfirmDialog(null,
                "Would you like to play again?", "Again", JOptionPane.YES_NO_OPTION);
        /*  If the user clicks the yea button,
            add a round to the count, and start over
            with fresh attempts and a new number.
        */
        if (again == JOptionPane.YES_OPTION) {
            round++;
            JOptionPane.showMessageDialog(null,
                    "Round " + getDigit(round) + ", go!");
            attempt = 11;
            randomizer();

        /*  If the player clicks anything else
            Tell the user how many games they played, and then exit.
            If they only played a single game, one is not plural.
            Anything other than one is plural. "One rounds" is bad.
        */
        } else {
            if (round == 1) {
                JOptionPane.showMessageDialog(null,
                        "You played for " + getDigit(round) + " round!\n" +
                                "Good bye!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "You played for " + getDigit(round) + " rounds!\n" +
                                "Good bye!");
            }
            System.exit(1);
        }
    }

    /*  This is just some fun stuff to be grammatically correct.
        Nothing else.
     */
    private static String getDigit(int round) {
        String result;
        switch (round) {
            case 0: result = "zero";  break;
            case 1: result = "one";   break;
            case 2: result = "two";   break;
            case 3: result = "three"; break;
            case 4: result = "four";  break;
            case 5: result = "five";  break;
            case 6: result = "six";   break;
            case 7: result = "seven"; break;
            case 8: result = "eight"; break;
            case 9: result = "nine";  break;
            default:
                //If more than nine, just print the number.
                result = Integer.toString(round);
                break;
        }
        return result;
    }
}
