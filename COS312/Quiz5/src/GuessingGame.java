import javax.swing.*;
import java.util.Random;

/*****************************************
 * Created by Lance Douglas on 4/21/2017
 *
 * ~~This is just a small game where the
 * player must correctly guess a random
 * number assigned by the machine. Really
 * simple stuff, nothing particularly new
 * here. Have fun.~~
 *
 * Haha, just kidding, that's boring as
 * all hell. Here's somma that new shit:
 * Attempt counts.
 * Rounds.
 * Error catching.
 * Exception handling.
 * Easter eggs.
 * Individual methods for:
 * Randomization.
 * Gameplay.
 * Next game.
 *
 * @version 1.00
 *****************************************/

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
    private static void randomizer() {
        Random random = new Random();
        int number = random.nextInt(100);
        game(round, attempt, number);
    }
    private static void game(int round, int attempt, int number) {
        try {
            int guess = -1;

            while (guess != number) {
                while (attempt > 1) {
                    attempt--;
                    String guessStr = Integer.toString(guess);
                    guessStr = JOptionPane.showInputDialog(number + " Enter your guess:\nAttempts remaining: " + attempt);
                    if (guessStr.equals("")) {
                        game(round, attempt, number);
                    }
                    guess = Integer.parseInt(guessStr);

                    if (guess <= 0) {
                        JOptionPane.showMessageDialog(null,
                                    "Guess must be a positive number.");
                        attempt++;
                        game(round, attempt, number);
                    } else if (guess == 420) {
                        JOptionPane.showMessageDialog(null,
                                    "Too fukn high lmao.");
                        attempt++;
                        game(round, attempt, number);
                    } else if (guess > 100) {
                        JOptionPane.showMessageDialog(null,
                                    "The number must be less than 100.");
                        attempt++;
                        game(round, attempt, number);
                    }


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
                JOptionPane.showMessageDialog(null,
                        "You ran out of attempts.\nGame over.");
                again();
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number, not a string.");
            game(round, attempt, number);
        } catch (NullPointerException NPE) {
            System.exit(0);
        }
    }
    private static void again() {
        int again = JOptionPane.showConfirmDialog(null,
                "Would you like to play again?", "Again", JOptionPane.YES_NO_OPTION);
        if (again == JOptionPane.YES_OPTION) {
            round++;
            JOptionPane.showMessageDialog(null,
                    "Round " + round + ", go!");
            attempt = 11;
            randomizer();
        } else {
            if (round == 1) {
                JOptionPane.showMessageDialog(null,
                        "You played for " + round + " round!\n" +
                                "Good bye!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "You played for " + round + " rounds!\n" +
                                "Good bye!");
            }
            System.exit(1);
        }
    }
}
