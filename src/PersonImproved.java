import java.util.*;

/* I'm not exactly sure how this works. PersonImproved supplements PersonImprovedTest.
    Holds necessary methods for PIT.j to run.
    Lance Douglas, PersonImproved, September 30, 2016
 */
class PersonImproved {
    private String name;
    private int age;
    public void writeOutput() { //Prints the name and age.
        System.out.println("Name = " + name + "\nAge = " + age);
    }
    public void readInput() { //Takes input, saves to name and age. Ensures age is more than zero.
        Scanner scn = new Scanner(System.in);
        System.out.println("What is the person's name?");
        name = scn.nextLine();

        System.out.println("What is the person's age?");
        age = scn.nextInt();
        while (age < 0)
        {
            System.out.println("Age cannot be negative." +
                    "Reenter age:");
            age = scn.nextInt();
        }
    }
    public void setName(String newName) { //variable name reassigned to newName
        name = newName;
    }
    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        } else {
            System.out.println("Error: Age is negative.");
            System.exit(0);
        }
    }
    public void set(String newName, int newAge) {
        name = newName;
        if (newAge >= 0)
            age = newAge;
        else
        {
            System.out.println("ERROR: Used a negative age.");
            System.exit(0);
        }
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isSameName (PersonImproved PI) { //Compares names in input vs PIT.j names.
        return(this.name.equalsIgnoreCase(PI.name));
    }
    public boolean isOlderThan (PersonImproved PI) { //Checks age to see if older.
        return(this.getAge() > PI.getAge());
    }
    public boolean isYoungerThan (PersonImproved PI) { //Checks age to see if younger.
        return(this.getAge() < PI.getAge());
    }
}