import java.util.Scanner; // Basic user IO
/* This program will return exact change in the minimum amount of coin necessary. The user enters the price of an item
   they purchased, and the program subtracts the price from a dollar, to get the change, and then it turns the change
   into exact coin.
   */

public class VendingChange { // Class name
    public static void main (String[] args) { // Method name

        Scanner scn = new Scanner(System.in); // For user input
        System.out.println("Enter price of item, \nFrom 25 cents to $1, in five cent increments.");
        int price = scn.nextInt();
        int change = 100 - price; //Dollar - price to get change.

        int quarters = change / 25; // For the record,
        int dimes = (quarters % 25 ) / 10; // I know none of this works,
        int nickels = (dimes % 10)/ 5; // it's just a placeholder.



        System.out.println("You bought an item for " + price + " cents and gave me a dollar.\n" +
                "Your change is:\n" +
                quarters + " quarters, " + // Returns Quarters
                dimes + " dimes, and " + // Returns Dimes
                nickels + " nickels."); // Returns Nickels
    }
}
