/**
 *
 * File name: PersonCh6Test.java
 *
 * A program to test the class PersonCh6.
 *
 * This program creates objects of class PersonCh6 and
 * exercises its methods, including the four constructors.
 * PersonCh6 objects have two data attributes, name and age.
 *
 * PersonCh6 public methods:
 * 	 constructor with name and age parameters.
 * 	 constructor with just name parameter (sets age = 0).
 * 	 constructor with just age parameter (sets name = "No name").
 * 	 default constructor (no parameters) - sets name = "No name"
 * 		and age = 0.
 *   readInput interactively assigns name and age values.
 *   writeOutput displays name and age.
 * 	 set assigns name and age.
 *   getName returns name.
 *   setName sets name.
 *   setAge sets age.
 * 	 test if two persons are equal (same name and age)l
 * 	 test if two persons have the same name.
 * 	 test if two persons have the same age.
 * 	 test if one person is older than another.
 * 	 test if one person is younger than another.
 *
 * Author: Lew Rakocy
 * email address: Lrakocy@devrycols.edu
 * Date: 8/27/2000
 * Last changed: Updated for fourth edition by Brian Durney, November 2004
 */

public class PersonCh6Test
{
    public static void main(String[] args)
    {

        System.out.println();
        System.out.println("Test case 1: default constructor and");
        System.out.println("writeOutput() method.");
        System.out.println();
        PersonCh6 secretAgent1 = new PersonCh6();
        System.out.println("Results of default constructor:");
        System.out.println("Should be name = \"No name\" and");
        System.out.println("age = 0.");
        System.out.println();
        secretAgent1.writeOutput();
        System.out.println();
        System.out.println("====================================");

        System.out.println("Test case 2: readInput() method.");
        secretAgent1.readInput();
        System.out.println();
        System.out.println("Verify name and age.");
        System.out.println("Should be whatever you just entered.");
        System.out.println();
        secretAgent1.writeOutput();
        System.out.println();
        System.out.println("====================================");

        System.out.println("Test case 3: constructor with just name.");
        PersonCh6 secretAgent2 = new PersonCh6("Boris");
        System.out.println();
        System.out.println("Verify name = Boris and age = 0.");
        System.out.println();
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("====================================");

        System.out.println("Test case 4: constructor with just age.");
        System.out.println();
        System.out.println("Verify name is \"No name\" and age = 40.");
        System.out.println();
        PersonCh6 secretAgent3 = new PersonCh6(40);
        secretAgent3.writeOutput();
        System.out.println();
        System.out.println("====================================");

        System.out.println("Test case 5: constructor with both name & age.");
        System.out.println();
        System.out.println("Verify name = Natasha & age 39.");
        System.out.println();
        PersonCh6 secretAgent4 = new PersonCh6("Natasha", 39);
        secretAgent4.writeOutput();
        System.out.println();
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 6:");
        System.out.println("getName: should be Natasha.");
        System.out.println();
        System.out.println("Verify results: "+ secretAgent4.getName());
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 7:");
        System.out.println("getAge: should be 39");
        System.out.println();
        System.out.println("Verify results: "
                + secretAgent4.getAge());
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 8:");
        System.out.println("setName to Rocky");
        secretAgent4.setName("Rocky");
        System.out.println();
        System.out.println("Verify results with getName(): "
                + secretAgent4.getName());
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 9:");
        System.out.println("setAge to 99");
        secretAgent4.setAge(99);
        System.out.println();
        System.out.println("Verify results: "
                + secretAgent4.getAge());
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 10: set method (both name & age)");
        System.out.println("and equals (both name and age)");
        System.out.println("Making two persons"
                + " with same name and age:");
        secretAgent1.set("Bullwinkle", 10);
        secretAgent2.set("Bullwinkle", 10);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 11:");
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
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 12:");
        System.out.println("equals (both name and age)");
        System.out.println("with different ages, same names.");
        secretAgent2.setName("Bullwinkle");
        secretAgent2.setAge(98);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.equals(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 13:");
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
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 14:");
        System.out.println("isSameName");
        System.out.println("with same names and ages.");
        secretAgent2.set("Bullwinkle", 10);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 15:");
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
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 16:");
        System.out.println("isSameName");
        System.out.println("with different names, same ages.");
        secretAgent2.set("Boris", 10);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 17:");
        System.out.println("isSameName");
        System.out.println("with different names, different ages.");
        secretAgent2.set("Boris", 5);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isSameName(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 18:");
        System.out.println("isOlderThan");
        System.out.println("with 1st person older than the other.");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isOlderThan(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 19:");
        System.out.println("isOlderThan");
        System.out.println("with same ages.");
        secretAgent2.setAge(10);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isOlderThan(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 20:");
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
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 21:");
        System.out.println("isYoungerThan");
        System.out.println("with 1st person younger than the other.");
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be true.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 22:");
        System.out.println("isYoungerThan");
        System.out.println("with same ages.");
        secretAgent2.setAge(10);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
        System.out.println("====================================");

        System.out.println();
        System.out.println("Test case 20:");
        System.out.println("isYoungerThan");
        System.out.println("with 1st person older than the other.");
        secretAgent2.setAge(9);
        System.out.println("First person: ");
        secretAgent1.writeOutput();
        System.out.println("Second person: ");
        secretAgent2.writeOutput();
        System.out.println();
        System.out.println("Verify results: should be false.");
        System.out.println(secretAgent1.isYoungerThan(secretAgent2));
    }
}