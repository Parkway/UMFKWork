import javax.swing.*;

public class PalindromeTester {
    public static void main(String[] args) {
        checker(); //Opens the checker method. I did this for easier recursion.
    }
    private static void checker() { //Method checks for palindromes.

        String reverse = ""; //Without that "" I get variable initialization errors.

        String original = JOptionPane.showInputDialog(null, "This program will test whatever text\n" +
                "you enter to see if it is a palindrome.\n" +
                "(Reads the same backwards and forwards.)\n" +
                "\nEnter text (Just letters and blanks with a period at the end, please)");

        original = original.replace(".",""); //This statement removes the period.
        original = original.toLowerCase(); //This statement converts the string to all lowercase, so something like Racecar works.

        int length = original.length() - 1; //-1 because I get IndexOutOfBounds errors. This fixes it.

        for ( int charLocation = length; charLocation >= 0; charLocation-- ) { //i = length of word, while i is greater than or equal to 0, i--
            reverse = reverse + original.charAt(charLocation); //Original - backwards + original word, one letter at a time. charAt(int) means "what is the char at this index"
        }

        if (original.equals(reverse)) { //If the original word = reversed word; yes palindrome!
            JOptionPane.showMessageDialog(null, "YES, the phrase is a palindrome!");
            repeat(); //Open repeat method to see if user has more phrases to test.
        } else {
            JOptionPane.showMessageDialog(null, "NO, the phrase is not a palindrome!");
            repeat();
        }
    }
    private static void repeat() {
        String again = JOptionPane.showInputDialog(null, "Would you like to test another string?(y/n)");

        if (again.equalsIgnoreCase("y")) {
            checker(); //If user says yes more phrases, reopen checker().
        } else if (again.equalsIgnoreCase("n")) {
            System.exit(0); //If user says no more, close program.
        } else {
            JOptionPane.showMessageDialog(null, "Please enter 'y' or 'n' to answer.");
            repeat();
        }
    }
}