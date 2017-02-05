import javax.swing.*;

/**
 * This program takes the cost of an item, and gives you your change back
 * in coins depending on the price.
 * Eg. You paid 72 cents, you're getting a quarter and three pennies.
 * Lance Douglas, VendingChange(GUI), February 12th, 2017
 */

public class VendingChange {
    public static void main(String[] args) throws InterruptedException{

        String amountString = JOptionPane.showInputDialog( //The magic input dialog.
                "Enter price of item from 0 cents to a dollar.");

        try {
            int amount = Integer.parseInt(amountString); //String to Integer. Not sure how to capture in exception handling.

            int price = 100 - amount;

            // Just making sure the user can follow directions and read.

            if (amount > 100) {
                JOptionPane.showMessageDialog(null, "That's more than a dollar.");
                System.exit(1);
            } else if (amount < 0) {
                System.out.println("You can't spend negative money.");
                System.exit(2);
            } else { //The rest of the program is the else, so whatever.
                int change = 100 - amount; //To determine how much change you get back.
                int quarters = change / 25;
                change = change % 25;// remaining change after deducting quarters
                int dimes = change / 10;
                change = change % 10;// remaining change after deducting dimes, too
                int nickels = change / 5;
                change = change % 5;
                int pennies = change;

                //The grammar will be incorrect if any of the values are 1
                //because the required code will not be added.

                Thread.sleep(350);
                JOptionPane.showMessageDialog(null, //The null is for determining the parent frame. There is none, so default it goes.
                        "You bought an item for " + amount
                                + " cents, and gave me a dollar,"
                                + " so your change is\n"
                                + quarters + " quarters, "
                                + dimes + " dimes, "
                                + nickels + " nickels, and "
                                + pennies + " pennies.\n"
                                + "In total, you get " + price + " cents back.");
                System.exit(1337);
            }
        } catch (NumberFormatException NFE) {
            Thread.sleep(350);
            JOptionPane.showMessageDialog(null, "Use numbers next time.");
        }
    }
}