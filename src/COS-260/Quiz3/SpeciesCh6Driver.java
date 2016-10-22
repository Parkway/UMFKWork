/**

 File name: SpeciesCh6Driver.java

 Test each of SpeciesCh6's 5 constructors and four set methods.

 Author: Lew Rakocy
 email address: Lrakocy@devrycols.edu
 Date: 8/27/00
 Last changed: Updated for fourth edition by Brian Durney, November 2004

 */
import java.util.*;

public class SpeciesCh6Driver
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        // Program loop control to repeat or stop
        char ans;

        do // Repeat entire test loop if user answered yes
        {
            System.out.println("Testing 1st constructor");
            System.out.println("    - initialize all 3 parameters.");
            System.out.println();
            System.out.println("Name should be Crepek.");
            System.out.println("Initial population should be 11.");
            System.out.println("Growth rate should be 2.2.");
            System.out.println();
            SpeciesCh6 s1 = new SpeciesCh6("Crepek", 11, 2.2);
            System.out.println("Values after constructor:");
            s1.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing 2nd constructor");
            System.out.println("    - specify only the name.");
            System.out.println();
            System.out.println("Name should be Foobar.");
            System.out.println("Initial population should be 0.");
            System.out.println("Growth rate should be 0.");
            System.out.println();
            SpeciesCh6 s2 = new SpeciesCh6("Foobar");
            System.out.println("Values after constructor:");
            s2.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing 3rd constructor");
            System.out.println("    - specify only the population.");
            System.out.println();
            System.out.println("Name should be \"No name, yet\".");
            System.out.println("Initial population should be 33.");
            System.out.println("Growth rate should be 0.");
            System.out.println();
            SpeciesCh6 s3 = new SpeciesCh6(33);
            System.out.println("Values after constructor:");
            s3.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing 4th constructor");
            System.out.println("    - specify just the growth rate.");
            System.out.println();
            System.out.println("Name should be \"No name, yet\".");
            System.out.println("Initial population should be 0.");
            System.out.println("Growth rate should be 44.4.");
            System.out.println();
            SpeciesCh6 s4 = new SpeciesCh6(44.4);
            System.out.println("Values after constructor:");
            s4.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing default constructor");
            System.out.println("    - specify no parameters.");
            System.out.println();
            System.out.println("Name should be \"No name, yet\".");
            System.out.println("Initial population should be 0.");
            System.out.println("Growth rate should be 0.");
            System.out.println();
            SpeciesCh6 s5 = new SpeciesCh6();
            System.out.println("Values after constructor:");
            s5.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Test to set all parameters");
            System.out.println();
            System.out.println("Name should be Yosarian.");
            System.out.println("Initial population should be 55.");
            System.out.println("Growth rate should be 66.6.");
            System.out.println();
            s1.set("Yosarian", 55, 66.6);
            s1.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing set name only");
            System.out.println();
            System.out.println("Name should be Milo.");
            System.out.println("Initial population should be 55.");
            System.out.println("Growth rate should be 66.6.");
            System.out.println();
            s1.set("Milo");
            s1.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing set population only");
            System.out.println();
            System.out.println("Name should be Milo.");
            System.out.println("Initial population should be 77.");
            System.out.println("Growth rate should be 66.6.");
            System.out.println();
            s1.set(77);
            s1.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println("Testing set growth rate");
            System.out.println();
            System.out.println("Name should be Milo.");
            System.out.println("Initial population should be 77.");
            System.out.println("Growth rate should be 88.8.");
            System.out.println();
            s1.set(88.8);
            s1.writeOutput();
            System.out.println();
            System.out.println("==============================");

            System.out.println();
            System.out.println("Test again?(y/n)");
            ans = keyboard.next().charAt(0);
        }while ((ans == 'y') || (ans == 'Y'));

        System.out.println("End of test.");
    }
}

