import java.util.Scanner;

public class ScannerTest {
   public static void main(String[] args) {
      System.out.println("Enter the first string.");
      Scanner scn = new Scanner(System.in);
      String first = scn.next();
      System.out.println("Enter second string.");
      String second = scn.next();
      String concat = first + " " + second; //Won't work, placeholder. Temporary.
      System.out.println("The first string is '" + first + "', it is " + first.length()+ " characters long.\n"
      + "The second string is '" + second + "', it is " + second.length() + " characters long.\n" 
      + "The strings combined is '" + concat + "', it is " + concat.length() + " characters long.");
   }
}
