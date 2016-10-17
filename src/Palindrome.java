import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        checker(); //Opens the checker method. I did this for easier recursion.
    }
    private static void checker() { //Method checks for palindromes.
        Scanner scn = new Scanner(System.in);
        String reverse = ""; //Without that "" I get variable initialization errors.

        print("This program will test whatever text\n" +
                "you enter to see if it is a palindrome.\n" +
                "(Reads the same backwards and forwards.)\n" +
                "\nEnter text (Just letters and blanks)");
        String original = scn.nextLine().toLowerCase(); //String original means input word; nextLine().toLowerCase() means ignore case, so 'RACecaR' is still correct.

        int length = original.length() - 1; //-1 because I get IndexOutOfBounds errors. This fixes it.

        for ( int charLocation = length; charLocation >= 0; charLocation-- ) { //i = length of word, while i is greater than or equal to 0, i--
            reverse = reverse + original.charAt(charLocation); //Original - backwards + original word, one letter at a time. charAt(int) means "what is the char at this index"
        }
        if (original.equals(reverse)) { //If the original word = reversed word; yes palindrome!
            print("YES, the phrase is a palindrome!");
            repeat(); //Open repeat method to see if user has more phrases to test.
        } else {
            print("NO, the phrase is not a palindrome!");
            repeat();
        }
    }
    private static void repeat() {
        Scanner scn = new Scanner(System.in);
        print("Would you like to test another string?(y/n)");
        String again = scn.nextLine();
        if (again.equalsIgnoreCase("y")) {
            checker(); //If user says yes more phrases, reopen checker().
        } else if (again.equalsIgnoreCase("n")) {
            System.exit(0); //If user says no more, close program.
        } else {
            print("Please enter 'y' or 'n' to answer.");
            repeat();
        }
    }
    private static void print(String s) {
        System.out.println(s); //2lazy4System.out.println
    }
}