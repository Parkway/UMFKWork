import javax.swing.*;

public class RecursionDemo {
    public static void main(String[] args) {
        runner();
    }
    private static void runner() {
        try {
            String numStr = JOptionPane.showInputDialog(null,
                    "Enter a positive integer that is less than ten: ",
                    "Title", JOptionPane.INFORMATION_MESSAGE);
            if (numStr.equals(null)) {
                System.exit(33);
            }
            int number = Integer.parseInt(numStr);

            if (number <= 0 || number >= 10) {
                JOptionPane.showMessageDialog(null,
                        "Number must be between 1-9, try again.");
                runner();
            }

            JOptionPane.showMessageDialog(null,
                    "The digit in this number is: " + getWordFromDigit(number) + "\n");

            number += 10;
            JOptionPane.showMessageDialog(null,
                    "If you add ten to that number,\n" +
                            "the digits in the new number are:\n " +
                            getWordFromDigit(number) + " " + getWordFromDigit(number - 10));
            again();
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Please enter an integer, nothing else.");
            runner();
        } catch (NullPointerException NPE) {
            System.exit(22);
        }
    }

    private static void again() {
        int again = JOptionPane.showConfirmDialog(null,
                "Would you like to go again?","Again",JOptionPane.YES_NO_OPTION);
        if (again == JOptionPane.YES_OPTION) {
            runner();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Good bye.");
            System.exit(11);
        }
    }
    /**
     Precondition: 0 <= digit <= 9
     Returns the word for the argument digit.
     */
    private  static String getWordFromDigit(int digit) {
        String result = null;

        if (digit >= 10) {
            digit /= 10;
            getWordFromDigit(digit % 10);
        }

        switch (digit) {
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