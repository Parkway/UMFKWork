import java.util.Scanner;

/**
 * Created by parkway on 9/5/16.
 */
public class VendingChange {
    public static void main (String[] args) {

        int quarters;
        int dimes;
        int nickels;
        
        double dollars;

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter price of item, \n From 25 cents to $1");
        int price = scn.nextInt();
        System.out.println("You bought an item for " + price + " cents and gave me a dollar.\n" +
                "Your change is:\n");
    }
}
