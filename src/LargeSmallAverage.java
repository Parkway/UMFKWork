import java.util.Scanner;
/* This program determines the largest integer, smallest integer, and average double of all the numbers entered.
It takes a number of user inputs, sets the biggest to var largest,
the smallest to var lowest,
and adds them all together and averages them out by total + num.
Lance Douglas, LargeSmallAverage, September 12, 2016.
*/
public class LargeSmallAverage {
    public static void main(String[] args) {
        int total = 0; //All user input added up.
        int largest = Integer.MIN_VALUE; // Guarantees user input must be above lowest integer when recorded.
        int smallest = Integer.MAX_VALUE; // Guarantees user input must be lower than the highest integer when recorded.
        int count = 0; //How many numbers the user added.
        double average; //Will be used to store total / count.
        Scanner scn = new Scanner(System.in);
        System.out.println("This program allows you to enter a list of positive integers,\n" +
                "terminated by a -1, then displays the largest value,\n" +
                "smallest value, and average of the list of numbers,\n" +
                "not including the final negative value that ends the list.\n");
        while(true){ //A while loop. Do these things while the statement is true.
            System.out.println("Please enter a positive integer, or -1 to quit.");
            int num = scn.nextInt();
            if (num == -1) break; //Break function closes while loop.
            count++; //++ adds continually to count. Records how many inputs.
            total = total + num; //Takes total of 0 and adds all nums to it.
            if (num > largest) largest = num; // If the number is bigger than the minimum, it becomes the largest.
            if (num < smallest) smallest = num; // If the number is smaller than the maximum, it becomes the smallest.
        }
        average = total / count; //Divides the sum of user input by number of inputs recorded.
        System.out.println("For the " + count + " numbers you entered,"); //Nothing new here or below.
        System.out.println("The largest value = " + largest);
        System.out.println("The smallest value = " + smallest);
        System.out.println("The average value " + average);
    }
} //PS. I liked this assignment, took me a little while.
