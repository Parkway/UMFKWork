import java.util.*;

public class PersonCh6 {
    private String name;
    private int age;


    public PersonCh6(String newName, int newAge) {
        name = newName;
        if(newAge >= 0)
            age = newAge;
        else {
            System.out.println("Age can't be negative!");
            System.out.println("Age reset to 0.");
            age = 0;
        }
    }
    public PersonCh6(String newName) { //Accessor method for name
        name = newName;
        age = 0;
    }
    public PersonCh6(int newAge) { //Age accessor method
        name = "No name";
        if(newAge >= 0)
            age = newAge;
        else {
            System.out.println("Age can't be negative!" +
                    "Age reset to 0.");
            age = 0;
        }
    }
    public PersonCh6() {
        name = "No name";
        age = 0;
    }

    public void readInput() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is the person's name?");
        name = keyboard.nextLine();

        System.out.println("What is the person's age?");
        age = keyboard.nextInt();
        while (age < 0) {
            System.out.println("Age cannot be negative." +
                    "Reenter age:");
            age = keyboard.nextInt();
        }
    }

    public void writeOutput() {
        System.out.println("Name = " + name +
                "Age = " + age);
    }

    public void set(String newName, int newAge) {
        name = newName;
        if (newAge >= 0)
            age = newAge;
        else {
            System.out.println("Age cannot be negative.");
            System.exit(0);
        }
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setAge(int newAge) {
        if (newAge >= 0)
            age = newAge;
        else {
            System.out.println("Age cannot be negative.");
            System.exit(0);
        }
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean equals(PersonCh6 another) {
        return(this.name.equalsIgnoreCase(another.name)
                && this.getAge() == another.getAge());
    }
    public boolean isSameName(PersonCh6 another) {
        return(this.name.equalsIgnoreCase(another.name));
    }
    public boolean isOlderThan(PersonCh6 another) {
        return(this.getAge() > another.getAge());
    }
    public boolean isYoungerThan(PersonCh6 another) {
        return(this.getAge() < another.getAge());
    }
}