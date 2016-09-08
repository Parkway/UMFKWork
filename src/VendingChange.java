import java.util.Scanner; // Basic user IO

public class VendingChange { // Class name
    public static void main (String[] args) { // Method name

        Scanner scn = new Scanner(System.in); // For user input
        System.out.println("Enter price of item, \nFrom 25 cents to $1");
        int price = scn.nextInt();
        int answer = 100 - price;

        int quarters = answer / 25;
        int dimes = answer / 10 ;
        int nickels = answer / 5;



        System.out.println("You bought an item for " + price + " cents and gave me a dollar.\n" +
                "Your change is:\n" +
                quarters + " quarters, " +
                dimes + " dimes, and " +
                nickels + " nickels.");
    }
}
