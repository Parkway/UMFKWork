import java.util.Scanner;

public class GradesGraph
{
    private int Acount;
    private int Bcount;
    private int Ccount;
    private int Dcount;
    private int Fcount;
    private int asteriskCount;

    /**

     Methods to set data members

     */

    //Interactively assign values to all data members
    public void readInput() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many A's?");
        Acount = keyboard.nextInt();
        Bcount = keyboard.nextInt();
        Ccount = keyboard.nextInt();
        Dcount = keyboard.nextInt();
        Fcount = keyboard.nextInt();
    }
    //The following method sets all grades to newGradeCount
    public void set(int newAcount, int newBcount,
                    int newCcount, int newDcount,
                    int newFcount) {

        Acount = newAcount;
        Bcount = newBcount;
        Ccount = newCcount;
        Dcount = newDcount;
        Fcount = newFcount;
    }

    //While these methods set individual grades to newGradeCount
    public void setAcount(int newAcount) {
            Acount = newAcount;
    }

    public void setBcount(int newBcount) {
        Bcount = newBcount;
    }

    public void setCcount(int newCcount) {
        Ccount = newCcount;
    }

    public void setDcount(int newDcount) {
        Dcount = newDcount;
    }

    public void setFcount(int newFcount) {
        Fcount = newFcount;
    }

    public void writeOutput() { //Write out all grade counts
        System.out.println("Number of A's = " + Acount);
        System.out.println("Number of B's = " + Bcount);
        System.out.println("Number of C's = " + Ccount);
        System.out.println("Number of D's = " + Dcount);
        System.out.println("Number of F's = " + Fcount);
    }

    //Display data to user
    public void writeAcount() {
        System.out.println("Number of A's = " + Acount);
    }

    public void writeBcount() {
        System.out.println("Number of B's = " + Bcount);
    }

    public void writeCcount() {
        System.out.println("Number of C's = " + Ccount);
    }

    public void writeDcount() {
        System.out.println("Number of D's = " + Dcount);
    }

    public void writeFcount() {
        System.out.println("Number of F's = " + Fcount);
    }

    //Return data for grades
    public int getAcount() {
        return Acount;
    }

    public int getBcount() {
        return Bcount;
    }

    public int getCcount() {
        return Ccount;
    }

    public int getDcount() {
        return Dcount;
    }

    public int getFcount() {
        return Fcount;
    }

    public int getTotalNumberOfGrades() { //Returns all five gradeCounts
        return (Acount + Bcount + Ccount + Dcount + Fcount);
    }

    //These get the percentages
    public int getPercentA() {
        return (int)((float)Acount/this.getTotalNumberOfGrades() * 100
                + 0.5);
    }

    public int getPercentB() {
        return (int)((float)Bcount/this.getTotalNumberOfGrades() * 100
                + 0.5);
    }

    public int getPercentC() {
        return (int)((float)Ccount/this.getTotalNumberOfGrades() * 100
                + 0.5);
    }

    public int getPercentD() {
        return (int)((float)Dcount/this.getTotalNumberOfGrades() * 100
                + 0.5);
    }

    public int getPercentF() {
        return (int)((float)Fcount/this.getTotalNumberOfGrades() * 100
                + 0.5);
    }


    public void draw() { //Draws the graph thing.
        //Draw scale
        System.out.println("2   10   20   30   40   50   60   70   80   90   100");
        System.out.println("|   |    |    |    |    |    |    |    |    |    |");
        System.out.println("**************************************************");

        //For loops count the asterisks down to get gradeCount

        for(asteriskCount = 1;
            asteriskCount <= getPercentA()/2;
            asteriskCount++) {
            System.out.print("*");
        }
        System.out.println(" A");

        for(asteriskCount = 1;
            asteriskCount <= getPercentB()/2;
            asteriskCount++) {
            System.out.print("*");
        }
        System.out.println(" B");

        for(asteriskCount = 1;
            asteriskCount <= getPercentC()/2;
            asteriskCount++) {
            System.out.print("*");
        }
        System.out.println(" C");

        for(asteriskCount = 1;
            asteriskCount <= getPercentD()/2;
            asteriskCount++) {
            System.out.print("*");
        }
        System.out.println(" D");

        for(asteriskCount = 1;
            asteriskCount <= getPercentF()/2;
            asteriskCount++) {
            System.out.print("*");
        }
        System.out.println(" F");
    }
}