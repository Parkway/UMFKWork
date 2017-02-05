import javax.swing.*;

/**
 * This is not part of the homework, but I wanted to make it because
 * having a program only do coins irritated me for some reason.
 * This is the exact same program, but now it also takes dollars.
 * So there.
 */

public class DollarsToCoins {
    public static void main(String[] args) {
        String amountString = JOptionPane.showInputDialog( //JOptionPane is a GUI thingy.
                "Enter a whole number.\n" +
                        "I will output a combination of coins\n" +
                        "that equals that amount of change.");

        //Integer initialization. Declaration on lines 27-33.

        int amount, originalAmount,
                dollars, quarters,
                dimes, nickels, pennies;

        amount = Integer.parseInt(amountString); //Converts amountString to Integer - JOptions can only do Strings.
        originalAmount = amount; //Saving original amount.
        if (originalAmount < 0) { //If it's less than a dollar,
            JOptionPane.showMessageDialog(null, "You can't spend negative money."); //Tell them they're stupid again.
            System.exit(2); //Rage quit again.
        } //If without else because the whole program is the else.

        //Declaring and breaking down the variables.

        dollars = amount / 100; //There, now it really does things.
        amount = amount % 100;
        quarters = amount / 25;
        amount = amount % 25;
        dimes = amount / 10;
        amount = amount % 10;
        nickels = amount / 5;
        amount = amount % 5;
        pennies = amount;

        //Just for fun, pretend the computer is doing something.

        JOptionPane.showMessageDialog(null, "Mathing...");

        //Now print out the number in change.

        JOptionPane.showMessageDialog(null,
                originalAmount + " cents in coins can" +
                        " be given as:\n" +
                        dollars + " dollars, " +
                        quarters + " quarters, " +
                        dimes + " dimes, " +
                        nickels + " nickels, and " +
                        pennies + " pennies.");
        System.exit(1337); //Exiting successful - 1337 because too hax. http://www.urbandictionary.com/define.php?term=1337
    }
}