/*****************************************
 * LetterCount.java | Author: Lewis/Loftus
 *
 * The program reads a string input by the user,
 * and counts the number of times each letter
 * occurs. The letters are case sensitive,
 * so, for example, a != A.
 *
 * Modified by Lance Douglas on 4/7/2017
 *****************************************/

import javax.swing.*;

public class LetterCount {
    public static void main(String[] args) {
        final int NUMCHARS = 26;
        String output = "";
        int[] upper = new int[NUMCHARS];
        int[] lower = new int[NUMCHARS];

        char current;
        int other = 0;

        String line = JOptionPane.showInputDialog("Enter a sentence:");
        for (int ch = 0; ch < line.length(); ch++) {
            current = line.charAt(ch);
            if (current >= 'A' && current <= 'Z')
                upper[current - 'A']++;
            else if (current >= 'a' && current <= 'z')
                lower[current - 'a']++;
            else
                other++;
        }
        output = output + ('A') +
                ": " + upper[0] +
                "\t\t " + ('a') +
                ": " + lower[0];
        for (int letter = 1; letter < upper.length; letter++) {
            output = output + "\n" + (char)
                    (letter + 'A') + ": " + upper[letter] +
                    "\t\t " + (char) (letter + 'a') + ": " + lower[letter];
        }
        JOptionPane.showMessageDialog(null, output);
        JOptionPane.showMessageDialog(null, "Non-alphabetic characters: " + other);
    }
}