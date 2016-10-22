import java.util.InputMismatchException; // Exception handling
import java.util.Scanner; // Adds Scanner for input.
/* File name: FirstProgram3.java
    This program takes three integers from the user and adds them together, and returns the sum as output.
    For example, if I enter 5, 10, and 5, the program returns 20.
    Lance Douglas, FirstProgram3, September 7, 2016.
*/

public class FirstProgram3 { //Identifies class name
    public static void main(String []args) { // Method name
        Scanner scn = new Scanner(System.in); // Scanner, allows for user input.
        System.out.println("Hello out there.\n" +
                "I will add three numbers for you.\n" +
                "Enter three whole numbers on a line:"); // What the program displays.
        try {
            int firstNum = scn.nextInt(); // The first number
            int secondNum = scn.nextInt(); // The second number
            int thirdNum = scn.nextInt(); // The third number
            int sum = firstNum + secondNum + thirdNum; // Adds the three numbers
            System.out.println("The sum of those three numbers is \n" + sum); // Displays the sum.
        }
        catch(InputMismatchException exception) {
            System.out.println("This is not an integer, please try again.");
        } // try / catch is to catch any errors if the user enters something that isn't an integer.
    }
} //End code.