/**

 File name: GradesGraphTest.java

 GradesGraphTest is a program to test GradesGraph class.

 GradesGraph class has these attributes:
 Number of each letter grade, A, B, C, D, and F.

 GradesGraph class has these Public methods:
 Set the number of each grade individually or as a group.
 Read the number of each grade individually or as a group.
 Return the number of each grade.
 Return the total number of grades.
 Return the percent of each grade.
 (a whole number from 0 to 100).
 Display a graph of the number of each grade (by printing
 a lines of asterisks proportional to number of grades).

 Written by: Lew Rakocy
 email address: Lrakocy@devrycols.edu
 Date: 8/20/2000
 Last changed:
 Updated for fourth edition by Brian Durney, November 2004

 */

public class GradesGraphTest
{
    public static void main(String[] args)
    {

        int numberOfAs;
        int numberOfBs;
        int numberOfCs;
        int numberOfDs;
        int numberOfFs;

        System.out.println();
        System.out.println("Test case 1: readInput() and writeOutput()");
        GradesGraph grades = new GradesGraph();
        grades.readInput();
        System.out.println();
        grades.writeOutput();
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 2:");
        System.out.println("set counts as a group: A=1, B=2, etc.");
        grades.set(1, 2, 3, 4, 5);
        System.out.println();
        System.out.println("Verify results with writeOutput():");
        grades.writeOutput();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 3:");
        System.out.println("set counts individually");
        System.out.println("A=10, B=9, etc.");
        grades.setAcount(10);
        grades.setBcount(9);
        grades.setCcount(8);
        grades.setDcount(7);
        grades.setFcount(6);
        System.out.println();
        System.out.println("Verify results with writeOutput():");
        grades.writeOutput();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 4:");
        System.out.println("write (display) counts individually:");
        System.out.println();
        System.out.println("Verify A=10, B=9, etc.");
        System.out.println();
        grades.writeAcount();
        grades.writeBcount();
        grades.writeCcount();
        grades.writeDcount();
        grades.writeFcount();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 5:");
        System.out.println("return counts individually:");
        System.out.println();
        System.out.println("Verify A=10, B=9, etc.");
        System.out.println();
        System.out.println("A count = " + grades.getAcount());
        System.out.println("B count = " + grades.getBcount());
        System.out.println("C count = " + grades.getCcount());
        System.out.println("D count = " + grades.getDcount());
        System.out.println("F count = " + grades.getFcount());
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 6:");
        System.out.println("return total number of grades");
        System.out.println();
        System.out.println("Verify total = 40");
        System.out.println();
        System.out.println("Total number of grades = "
                + grades.getTotalNumberOfGrades());
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 7:");
        System.out.println("return percentages of each grade");
        System.out.println();
        System.out.println("Verify A=25, B=23, C=20, D=18, & F=15");
        System.out.println();
        System.out.println("A = " + grades.getPercentA());
        System.out.println("B = " + grades.getPercentB());
        System.out.println("C = " + grades.getPercentC());
        System.out.println("D = " + grades.getPercentD());
        System.out.println("F = " + grades.getPercentF());
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println();
        System.out.println("Test case 8:");
        System.out.println("Draw graph of grade percentages");
        System.out.println();
        System.out.println("Verify A=25, B=23, C=20, D=18, & F=15");
        System.out.println();
        grades.draw();

        System.out.println();
        System.out.println("Test case 9:");
        System.out.println("Draw graph of grade percentages");
        System.out.println();
        System.out.println("Verify A=100%");
        grades.set(1, 0, 0, 0, 0);
        System.out.println();
        grades.draw();

        System.out.println();
        System.out.println("Test case 10:");
        System.out.println("Draw graph of grade percentages");
        System.out.println();
        System.out.println("Verify all 0%");
        grades.set(0, 0, 0, 0, 0);
        System.out.println();
        grades.draw();

    }
}