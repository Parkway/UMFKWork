import java.util.Scanner;
/* I'm not exactly sure how this works. PersonImproved supplements PersonImprovedTest.
    Holds necessary methods for PIT.j to run.
    Lance Douglas, PersonImproved, September 30, 2016
 */
class PersonImproved {
    private String name;
    private int age;
    void writeOutput() { //Prints the name and age.
        System.out.println("Name = " + name + "\nAge = " + age);
    }
    void readInput() { //Takes input, saves to name and age. Ensures age is more than zero.
        Scanner scn = new Scanner(System.in);
        System.out.println("What is the person's name?");
        name = scn.nextLine();

        System.out.println("What is the person's age?");
        age = scn.nextInt();
        while (age < 0)
        {
            System.out.println("Age cannot be negative.");
            System.out.println("Reenter age:");
            age = scn.nextInt();
        }
    }
    void setName(String newName) { //variable name reassigned to newName
        name = newName;
    }
    void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        } else {
            System.out.println("Error: Age is negative.");
        }
    }
    void set(String newName, int newAge) {
        setName(newName);
        setAge(newAge);
    }
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    Boolean isSameName (PersonImproved PI) { //Compares names in input vs PIT.j names.
        return(this.name.equalsIgnoreCase(PI.name));
    }
    Boolean isOlderThan (PersonImproved PI) { //Checks age to see if older.
        return(this.getAge() > PI.getAge());
    }
    Boolean isYoungerThan (PersonImproved PI) { //Checks age to see if younger.
        return(this.getAge() < PI.getAge());
    }
}