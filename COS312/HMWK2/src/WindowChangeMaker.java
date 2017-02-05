import javax.swing.*;

/**
 * This program is designed to convert money into coins.
 *  Lance Douglas, WindowChangeMaker.java, February 12th, 2017.
 */

public class WindowChangeMaker {
    public static void main(String[] args) throws InterruptedException {
        String amountString = JOptionPane.showInputDialog( //JOptionPane is a GUI thingy.
                "Enter a whole number from 1 to 99.\n" +
                        "I will output a combination of coins\n" +
                        "that equals that amount of change.");

        //Integer initialization. Declaration on lines 27-33.

        int amount, originalAmount,
                quarters, dimes,
                nickels, pennies;

        try {
            amount = Integer.parseInt(amountString); //Converts amountString to Integer - JOptions can only do Strings.
            originalAmount = amount; //Saving original amount.
            if (originalAmount > 100) { //If the money is more than a dollar,
                JOptionPane.showMessageDialog(null, "That's more than a dollar."); //Tell the user they're stupid.
                System.exit(1); //Rage quit on them.
            } else if (originalAmount < 0) { //If it's less than a dollar,
                JOptionPane.showMessageDialog(null, "You can't spend negative money."); //Tell them they're stupid again.
                System.exit(2); //Rage quit again.
            }

            //Declaring and breaking down the variables.

            quarters = amount / 25; // Divides the total by 25.
            amount = amount % 25;
            dimes = amount / 10;
            amount = amount % 10;
            nickels = amount / 5;
            amount = amount % 5;
            pennies = amount;

            //Now print out the number in change.

            Thread.sleep(350);
            JOptionPane.showMessageDialog(null,
                    originalAmount + " cents in coins can" +
                            " be given as:\n" +
                            quarters + " quarters, " +
                            dimes + " dimes, " +
                            nickels + " nickels, and " +
                            pennies + " pennies.");
            System.exit(1337); //Exiting successful - 1337 because too hax. http://www.urbandictionary.com/define.php?term=1337
        } catch (NumberFormatException NFE) { //I'm going to be honest it took me way
                                                //too damn long to figure out this isn't
                                                //an InputMismatchException...
            Thread.sleep(350);
            JOptionPane.showMessageDialog(null,
                    "Nope, use integers next time.");
        }
    }
}
