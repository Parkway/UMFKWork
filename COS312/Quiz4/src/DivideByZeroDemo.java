/*****************************************
 * Created by Lance Douglas on 4/7/2017
 *
 * This program allows the user to divide
 * any two numbers, but has an exception
 * handler for if the user tries to divide
 * by zero. Idiot users.
 *****************************************/

import javax.swing.*;
import java.text.DecimalFormat;

public class DivideByZeroDemo {
    private double quotient;
    private String numer;
    private String denom;

    DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args)
    {
        DivideByZeroDemo oneTime = new DivideByZeroDemo( );
        oneTime.doIt( );
    }

    public void doIt( )
    {
        try
        {
            numer = JOptionPane.showInputDialog("Enter numerator:","Numerator...");
            denom = JOptionPane.showInputDialog("Enter denominator:","Can't be zero...");

            int numerator = Integer.parseInt(numer);
            int denominator = Integer.parseInt(denom);

            if (denominator == 0)
                throw new DivideByZeroException( );

            quotient = numerator / (double)denominator;
            JOptionPane.showMessageDialog(null,
                    numerator + " divided by " + denominator + " is " + df.format(quotient));
        }
        catch(DivideByZeroException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Didn't I just say it can't be zero!?");
            System.out.println(e.getMessage());
            giveSecondChance( );
        }
        catch(NumberFormatException NFE) {
            System.out.println(NFE.getMessage());
            giveSecondChance();
        }

        JOptionPane.showMessageDialog(null,
                "End of program.");
    }

    public void giveSecondChance( )
    {
        try {
            JOptionPane.showMessageDialog(null,
                    "Alright, you did something incorrect." +
                            "\nLet's try once more.");
            numer = JOptionPane.showInputDialog("Try again", "Enter numerator");
            denom = JOptionPane.showInputDialog("Enter denominator:", "Better not be zero...");

            int numerator = Integer.parseInt(numer);
            int denominator = Integer.parseInt(denom);

            if (denominator == 0) {
                JOptionPane.showMessageDialog(null,
                        "I cannot do division by zero. " +
                                "Since I cannot do what you want, the program will now end.");
                System.exit(0);
            }

            quotient = ((double) numerator) / denominator;
            JOptionPane.showMessageDialog(null,
                    numerator + "/" + denominator + " = " + df.format(quotient));
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Did you even enter a number? " +
                            "I'm ending this program because of your incompetence.");
            System.exit(1);
        }
    }
}