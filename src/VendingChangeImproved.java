import java.util.Scanner; // Basic user IO
/* This program will return exact change in the minimum amount of coin necessary. The user enters the price of an item
   they purchased, and the program subtracts the price from a dollar, to get the change, and then it turns the change
   into exact coin. Now, it magically accounts for integers that don't fall into the range of 25-100 cents, or aren't multiples of five.
   Lance Douglas, VendingChange, September 12, 2016
   */

public class VendingChangeImproved { // Class name
    public static void main (String[] args) { // Method name

        int amount;
        int price;
        int quarters;
        int dimes;
        int nickels;

        System.out.println("Enter price of an item, \nfrom 25 cents to $1, in 5 cent increments.");

        Scanner scn = new Scanner(System.in);
        price = scn.nextInt();
        if (price > 100) { //If price is more than 100, it won't work.
            System.out.println("Invalid cost: This number is more than $1.");
        } else if (price < 25) { //If the price is less than 25, it won't work.
            System.out.println("Invalid cost: This number is less than 25 cents.");
        } else if (price % 5 != 0) { //If the remainder of a price is not 0, than it was not a multiple of 5.
            System.out.println("Invalid cost: This number is not a multiple of 5.");
        } else {
            amount = 100 - price;
            quarters = amount / 25;
            amount = amount % 25;
            dimes = amount / 10;
            amount = amount % 10;
            nickels = amount / 5;

            System.out.println("You bought an item for " + price + " cents, and gave me a dollar.\nYour change is\n"
                    + quarters + " quarters,\n"
                    + dimes + " dimes, and\n"
                    + nickels + " nickels.");
        }/*Now, I also could have done a switch statement:
                int(price) {
                    case 1: *code*
                        break;
                    case 2: *code*
                        break;
                    case n: *code*
                        break;
                    default: *code*
                }
        */

    }
} //End code.