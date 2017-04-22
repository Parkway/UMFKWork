import javax.swing.*;

public class RecursionDemo {
    public static void main(String[] args) {
        try {
            String numStr = JOptionPane.showInputDialog("Enter a positive integer:");
            int number = Integer.parseInt(numStr);

            if (number <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Number can't be less than one, try again.");
                main(args);
            }

            JOptionPane.showMessageDialog(null,
                    "The digits in that number are:");
            displayAsWords(number);

            JOptionPane.showMessageDialog(null,
                    "If you add ten to that number,\n" +
                            "the digits in the new number are:");
            number = number + 10;
            displayAsWords(number);

            JOptionPane.showMessageDialog(null,
                    "Good bye.");
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a number, not text.");
            main(args);
        }
    }

    /**
     Precondition: number >= 0
     Displays the digits in number as words.
     */
    public static void displayAsWords(int number)
    {
        if (number < 10)
            JOptionPane.showMessageDialog(null,
                    getWordFromDigit(number));
        else //number has two or more digits
        {
            displayAsWords(number / 10);
            JOptionPane.showMessageDialog(null,
                    getWordFromDigit(number % 10) + " ");
        }
    }

    /**
     Precondition: 0 <= digit <= 9
     Returns the word for the argument digit.
     */
    private static String getWordFromDigit(int digit)
    {
        String result = null;
        switch (digit)
        {
            case 0: result = "zero";  break;
            case 1: result = "one";   break;
            case 2: result = "two";   break;
            case 3: result = "three"; break;
            case 4: result = "four";  break;
            case 5: result = "five";  break;
            case 6: result = "six";   break;
            case 7: result = "seven"; break;
            case 8: result = "eight"; break;
            case 9: result = "nine";  break;
            default:
                System.out.println("Fatal Error.");
                System.exit(0);
                break;
        }
        return result;
    }
}