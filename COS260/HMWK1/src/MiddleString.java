import java.util.*;
/*This program returns the second lexicographic word in a list of three words.
Lance Douglas, MiddleString, September 12, 2016.
 */
class MiddleString {
    private static void print(String s) {
        System.out.println(s);
    }
    static void threeArray () throws InterruptedException {
        print("Go.");
        Scanner scn = new Scanner(System.in); //Accepts user input
        String threeWords = scn.nextLine().toLowerCase(); //Turns user input into variable. Nothing new. String is just text IO instead of number IO.
        String words[] = threeWords.split(" ");//New stuff! words[] counts words in variable. threeWords is userinputvariable, .split(" ") splits the String at each " " space.
        Arrays.sort(words);
        print("Organized lexicographically, your input is: " + Arrays.toString(words) + "\n");
    }
    static void forArray() throws InterruptedException {
        print("Go.");
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of words.");
        int size = scn.nextInt();

        String[] words = new String[size];
        System.out.println("Please enter " + size + " words");
        for (int index = 0; index < size; index++) {
            words[index] = scn.next().toLowerCase();
        }
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
    static void nextMethod() {
        print("I haven't decided on another method yet. Check back soon!");
    }
}
