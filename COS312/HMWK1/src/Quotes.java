/* Alright, so Quotes is a simple (well, originally simple) class designed to take
    three quotes and print them out, crediting the author each time. Easy peasy.
    I spiced it up.
    Five quotes, timed output, and my favorite, randomized output with no repeats.

    Lance Douglas, HMWK1 Quotation Part 1, 1/29/2017
 */

import java.util.*;

public class Quotes {
    public static void main(String[] args) throws InterruptedException {

        String quotesList[] = {"Education is the most powerful weapon which you can use to change the world.\n\t\t- Nelson Mandela", //\n Means New line,
                "They can be silly, they can be political, whatever.\n\t\t- John Richardson", //and \t is tab, so adds newline and eight spaces.
                "An investment in knowledge pays the best interest.\n\t\t- Ben Franklin",
                "Style is a reflection of your attitude and your personality.\n\t\t- Shawn Ashmore",
                "I just spent way too much money. Why did I do that?\n\t\t- Lance Douglas"}; //Array of all five quotes, containing quote and author.

        Collections.shuffle(Arrays.asList(quotesList)); //This was annoying. It takes the array and shuffles
                                                        //the order of the elements, so as to ensure I don't
                                                        //repeat any pieces. "Shawn, Shawn, Nelson" for example.
        int quoteNum = 4; //Just a simple loop to go through all five quotes.
        while (quoteNum >= 0) {
            print(quotesList[quoteNum]); //Prints out the quote at array[Index], which has been shuffled.
            Thread.sleep(1500); //Wait 1.5 seconds for execution so I can read each quote.
            quoteNum--; //Decrement quoteNum.
        }
    }
    private static void print(String s) {
            System.out.println(s); //Nothing new here, too lazy for Sys.out.print.
    }
}

//I really liked this assignment.