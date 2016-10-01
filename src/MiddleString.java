import java.util.Arrays;
import java.util.Scanner;
/*This program returns the second lexicographic word in a list of three words.
Lance Douglas, MiddleString, September 12, 2016.
 */
public class MiddleString {
    public static void main(String[] args) {
        System.out.println("Please enter three words separated by spaces.");
        Scanner scn = new Scanner(System.in); //Accepts user input
        String threeWords = scn.nextLine(); //Turns user input into variable. Nothing new. String is just text IO instead of number IO.
        String words[] = threeWords.split(" ");//New stuff! words[] counts words in variable. threeWords is userinputvariable, .split(" ") splits the String at each " " space.
        Arrays.sort(words);
        System.out.println("The middle word is " + words[1]);
    }
}
