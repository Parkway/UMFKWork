import java.util.Scanner;
/* File name: BasicExamStatistics
    This program counts all the grades entered, assigns them to a variable, and tells me how many
    of each grade has been entered. Only new thing is if (var >/< int && var </> int) {
    Lance Douglas, BasicExamStatistics, September 30th, 2016

 */
public class BasicExamStatistics {
    private static void print(String s) {
        System.out.println(s); //Makes it so I don't need to type out six different Sysouts.
    }
    public static void main(String[] args) {
        int count = 0; //Initializes count variable with 0.
        int As = 0; //Preps to count A grades.
        int Bs = 0; //Counts B grades.
        int Cs = 0; //Counts Cs
        int Ds = 0; //Counts Ds
        int Fs = 0; //Counts Fs
        System.out.println("Enter numerical grades\n" +
                "in the range of 0 - 100 -\n" +
                "integers, only, please!");

        System.out.println("Enter -1 to terminate data entry.");

        while (true) {
            System.out.println("Please enter a score from 0 to 100, or -1 to quit.");
            Scanner scn = new Scanner(System.in);
            int newGrade = scn.nextInt();
            if (newGrade == -1) break; //If 'grade' is -1, break the loop.
            count++; //Adds one per instance.
            if (newGrade < 60) { //If grade is less than 60, it's an F.
                Fs++;
            } else if (newGrade < 70 && newGrade >= 60) { //If grade is less than 70 but 60 or higher, it's a D.
                Ds++;
            } else if (newGrade < 80 && newGrade >= 70) { //If grade is less than 80 but 70 or higher, it's a C.
                Cs++;
            } else if (newGrade < 90 && newGrade >= 80) { //If grade is less than 90 but 80 or higher, it's a B.
                Bs++;
            } else if (newGrade <= 100 && newGrade >= 90) { //If grade is higher than 90, and less than 101, it's an A.
                As++;
            }
        }
        print("Total number of grades = " + count);
        print("Number of A's = " + As);
        print("Number of B's = " + Bs);
        print("Number of C's = " + Cs);
        print("Number of D's = " + Ds);
        print("Number of F's = " + Fs);
    }
}