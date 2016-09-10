import java.util.Scanner; // Basic user IO
/* This program will return exact change in the minimum amount of coin necessary. The user enters the price of an item
   they purchased, and the program subtracts the price from a dollar, to get the change, and then it turns the change
   into exact coin.
   Lance Douglas, VendingChange, September 8, 2016
   */

public class VendingChange { // Class name
    public static void main (String[] args) { // Method name

        int amount;
        int price;
        int quarters;
        int dimes;
        int nickels;

        System.out.println("Enter price of an item, \nfrom 25 cents to $1, in 5 cent increments.");

        Scanner scn = new Scanner(System.in);
        price = scn.nextInt();
        amount = 100 - price;
        quarters = amount / 25;
        amount = amount % 25;
        dimes = amount / 10;
        amount = amount % 10;
        nickels = amount / 5;

        if (quarters == 1) {
            System.out.println("You bought an item for " + price + " cents, and gave me a dollar.\nYour change is\n"
                    + quarters + " quarter,\n"
                    + dimes + " dimes, and\n"
                    + nickels + " nickels.");
        } else if (dimes == 1) {
            System.out.println("You bought an item for " + price + " cents, and gave me a dollar.\nYour change is\n"
                    + quarters + " quarters,\n"
                    + dimes + " dime, and\n"
                    + nickels + " nickels.");
        } else if (nickels == 1) {
            System.out.println("You bought an item for " + price + " cents, and gave me a dollar.\nYour change is\n"
                    + quarters + " quarters,\n"
                    + dimes + " dimes, and\n"
                    + nickels + " nickel.");
        } else {
            System.out.println("You bought an item for " + price + " cents, and gave me a dollar.\nYour change is\n"
                    + quarters + " quarters,\n"
                    + dimes + " dimes, and\n"
                    + nickels + " nickels.");
        }

    }
}
