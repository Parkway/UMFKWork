import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by parkway on 9/5/16.
 */
public class FirstProgram3 {
    public static void main(String []args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Hello out there.\n" +
                "I will add three numbers for you.\n" +
                "Enter three whole numbers on a line:");
        try
        {
            int i = scn.nextInt();
            int j = scn.nextInt();
            int f = scn.nextInt();
            int sum = i + j + f;
            System.out.println("The sum of those three numbers is \n" + sum);
        }
        catch(InputMismatchException exception)
        {
            System.out.println("This is not an integer, please try again.");
        }
    }
}
