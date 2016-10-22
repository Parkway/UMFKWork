/**

 File name: TruncatedBankAccount.java

 This program does the following:
 Reads in a bank account balance and interest rate then
 displays the value of the account after 10 years for 3 methods
 of compounding interest:
 annually,
 monthly, and
 daily.
 After displaying the results it asks the user
 if she/he wants to repeat the calculations for different
 initial deposit and interest rate.

 All calculated dollar amounts are truncated to two decimal
 places when they are displayed (using the method
 TruncatedDollarFormatFormat.write(amount).

 Assumptions & restrictions:
 Does not take into account leap years.
 Assumes 365 days per year.
 Annual interest is posted at exactly one year intervals from
 date of deposit.
 Monthly interest is posted at exactly one month intervals from
 date of deposit.
 The monthly interest = interestRate/12 regardless of the number
 of days are in the month.
 Calculations are done per period inside loops that repeat once per
 time period until the 10-year span is reached.
 Dollars are entered as type double (floating point) as dollars.cents.
 At least one set of initial balance and interest rate values must be
 entered;
 The program does not allow for zero iterations.

 Note:
 The input data is repeated in output statements preceding the calculations
 so the user can confirm the data has been entered correctly.
 It also makes the program output more meaningful.
 See how the printout statements were arranged - the calculated results are
 printed immediately and not saved in separate variables to be printed
 after all the calculations are done.  This reduces the number of
 variables used and is more efficient, but no more correct, than code
 that uses separate variables for each of the three calculated new
 balances.

 Based on BankAccount.java from Chapter 4 Programming Project 10.
 Author: Lew Rakocy
 email address: Lrakocy@devrycols.edu
 Date: 9/1/2000
 Last changed: Updated for fourth edition by Brian Durney, November 2004

 */
import java.util.*;

public class TruncatedBankAccount
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        double initialBalance;
        double interestRate;
        double newBalance; // after 10 years
        char answer; // sentinel to repeat or end program
        int iteration; // loop counter

        do // repeat entire program if user says yes
        {
            System.out.println("Please enter an initial balance "
                    + "(dollars.cents):");
            initialBalance = keyboard.nextDouble();

            System.out.println
                    ("Please enter an interest rate in percent "
                            + "(e.g. 5.25):");
            interestRate = keyboard.nextDouble();

            System.out.print("In ten years an initial balance of ");
            TruncatedDollarFormat.writeln(initialBalance);
            System.out.println(" at an interest rate of "
                    + interestRate + "% will be worth:");

            // compound annually
            newBalance = initialBalance;
            for(iteration =1; iteration <= 10; ++iteration)
                newBalance = newBalance
                        + (interestRate/100) * newBalance;
            TruncatedDollarFormat.write(newBalance);
            System.out.println(" compounded annually");

            // compound monthly
            newBalance = initialBalance;
            for(iteration =1; iteration <= 120; ++iteration)
                newBalance = newBalance
                        + (interestRate/12) * (newBalance/100);
            TruncatedDollarFormat.write(newBalance);
            System.out.println(" compounded monthly");

            // compound daily
            newBalance = initialBalance;
            for(iteration =1; iteration <= 3650; ++iteration)
                newBalance = newBalance
                        + (interestRate/365) * (newBalance/100);
            TruncatedDollarFormat.write(newBalance);
            System.out.println(" compounded daily");

            System.out.println();
            System.out.println("Do you want to do it again?");
            System.out.println("Enter y for yes or n for no.");
            answer = keyboard.next().charAt(0);
        }while ((answer == 'y') || (answer == 'Y'));
    }
}
