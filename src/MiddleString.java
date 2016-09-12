import java.util.Scanner;
/*This returns the second word typed in a list of three words.
Unfortunately, it is static and won't work in other cases where there is more than three words.
I hard coded it to capture and return the second word.
I hope this is the way it is supposed to be done, because it looks kinda gross to me.
Lance Douglas, MiddleString, September 12, 2016.
 */
public class MiddleString {
    public static void main(String[] args) {
        System.out.println("Please enter three words separated by spaces.");
        Scanner scn = new Scanner(System.in); //Accepts user input
        String threeWords = scn.nextLine(); //Turns user input into variable. Nothing new. String is just text IO instead of number IO.
        String words[] = threeWords.split(" "); //New stuff! words[] counts words in variable. threeWords is userinputvariable, .split(" ") splits the String at each " " space.
        String middleWord = words[1]; // Returns second word in the words[] array. No idea how to get middle specifically. Google returned middle char. Not word. Not helpful.
        System.out.println("The middle word is " + middleWord);
    }
}
