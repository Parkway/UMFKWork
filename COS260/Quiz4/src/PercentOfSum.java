import java.util.Scanner;

public class PercentOfSum {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); //Accepts input

        System.out.println("How many numbers will you enter?");
        int numAmount = keyboard.nextInt(); //How many integers will be interpreted.
        int[] total = new int[numAmount]; //Puts integers into array with that amount.
        System.out.println("Enter " + numAmount + " integers, one per line:");

        for (int index = 0; index < numAmount; index++) {
            total[index] = keyboard.nextInt();
        } //For num zero to amount of integers, add a new integer

        int sum = addition(total, numAmount); //New variable, data type integer, named sum, from method addition with contstructors total and numAmount
        System.out.println("The sum is " + sum);
        for(int index = 0; index < numAmount; index++) {
            System.out.println(total[index] + " is "
                    + (((double) total[index] / sum) * 100.0 + 0.5)
                    + "% of the sum.");
        } //While index less than total inputs, get percentage of number within array
    }

    private static int addition(int[] listOfValues, int listLength) { //Separate method for getting the sum.
        int total = 0;
        for(int i = 0; i < listLength; i++) {
            total = total + listOfValues[i];
        }
        return(total);
    }
}

