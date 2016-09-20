import java.util.Scanner;
/*This program calculates what year you will turn a specified age,
  based on your birth year.
  Lance Douglas, BirthdayWizard, September 16, 2016. */
public class myBirthdayWizard {
    public static void main(String[] args) {
        System.out.println("Greetings.\nWhat year were you born?");
        Scanner scn = new Scanner(System.in);
        int birthYear = scn.nextInt(); //Year of birth.
        System.out.println("Choose any age.");
        int age = scn.nextInt(); //The age in which you want to find out when you will become.
        System.out.println("You will turn " + age + " in the year");
        int ageInYear = birthYear + age; //Adds age to birthyear to get answer.
        System.out.println(ageInYear);
    }
}