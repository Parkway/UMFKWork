/**

 File name: PersonImprovedTest.java

 Class PersonImprovedTest: tests the class PersonImproved.

 This program creates objects of class PersonImproved and
 exercises its methods.  PersonImproved objects have two
 data attributes, name and age.

 PersonImproved class's public methods originally in Person class:
 readInput interactively assigns name and age values.
 writeOutput displays name and age.
 set assigns name and age.
 getName returns name.
 getAge returns age.

 Additional public methods of PersonImproved
 (added to create PersonImproved class):
 setName sets name.
 setAge sets age.
 test if two persons are equal (same name and age)l
 test if two persons have the same name.
 test if two persons have the same age.
 test if one person is older than another.
 test if one person is younger than another.

 Author: Lew Rakocy
 email address: Lrakocy@devrycols.edu
 Date: 8/20/2000
 Last changed:
 Updated for fourth edition by Brian Durney, November 2004
 */
import java.util.*;

public class PersonImprovedTest
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Test case 1: readInput() and writeOutput()");
        PersonImproved secretAgent1 = new PersonImproved();
        secretAgent1.readInput();
        secretAgent1.writeOutput();
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 2:");
        System.out.println("set: name = Boris & age 40");
        secretAgent1.set("Boris", 40);
        System.out.println();
        System.out.println("Verify results with writeOutput():");
        secretAgent1.writeOutput();
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 3:");
        System.out.println("getName: should be Boris");
        System.out.println();
        System.out.println("Verify results:"
                + secretAgent1.getName());
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 4:");
        System.out.println("getAge: should be 40");
        System.out.println();
        System.out.println("Verify results:"
                + secretAgent1.getAge());
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 5:");
        System.out.println("setName to Natasha");
        secretAgent1.setName("Natasha");
        System.out.println();
        System.out.println("Verify results with getName(): "
                + secretAgent1.getName());
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 6:");
        System.out.println("setAge to 99");
        secretAgent1.setAge(99);
        System.out.println();
        System.out.println("Verify results: "
                + secretAgent1.getAge());
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 7:");
        System.out.println("equals (both name and age)");
        System.out.println("Making two ImprovedPersons"
                + " with same name and age:");
        PersonImproved secretAgent2 = new PersonImproved();
        secretAgent2.set("Natasha", 99);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 8:");
        System.out.println("equals (both name and age)");
        System.out.println("with different names, same ages.");
        secretAgent2.setName("Boris");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 9:");
        System.out.println("equals (both name and age)");
        System.out.println("with different ages, same names.");
        secretAgent2.setName("Natasha");
        secretAgent2.setAge(98);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 10:");
        System.out.println("equals (both name and age)");
        System.out.println("with different names and ages.");
        secretAgent2.setName("Boris");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 11:");
        System.out.println("isSameName");
        System.out.println("with same names and ages.");
        secretAgent2.set("Natasha", 99);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 12:");
        System.out.println("isSameName");
        System.out.println("with same names, different ages.");
        secretAgent2.setAge(98);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 13:");
        System.out.println("isSameName");
        System.out.println("with different names, same ages.");
        secretAgent2.setName("Boris");
        secretAgent2.setAge(99);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 14:");
        System.out.println("isSameName");
        System.out.println("with different names, different ages.");
        secretAgent2.setAge(98);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 15:");
        System.out.println("isOlderThan");
        System.out.println("with 1st person older than the other.");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isOlderThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 16:");
        System.out.println("isOlderThan");
        System.out.println("with same ages.");
        secretAgent2.setAge(99);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isOlderThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 17:");
        System.out.println("isOlderThan");
        System.out.println("with 1st person younger than the other.");
        secretAgent2.setAge(100);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isOlderThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 18:");
        System.out.println("isYoungerThan");
        System.out.println("with 1st person younger than the other.");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 19:");
        System.out.println("isYoungerThan");
        System.out.println("with same ages.");
        secretAgent2.setAge(99);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 20:");
        System.out.println("isYoungerThan");
        System.out.println("with 1st person older than the other.");
        secretAgent2.setAge(98);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
        System.out.println("==================================");
        System.out.println();

    }
}