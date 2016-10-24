
import java.util.*;

public class EmployeeTest
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char repeat;

        do  // repeat if user says 'yes'
        {
            // Test the nine constructors (uses writeOutput method)

            Employee e1 = new Employee(); // default constructor
            System.out.println("Using default constructor:");
            e1.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e2 = new Employee("Mondo Kane");
            System.out.println("Using constructor with just name:");
            e2.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e3 = new Employee("Fleetis Pascal", 111111.11);
            System.out.println("Constructor with name & salary :");
            e3.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e4 = new Employee("Carl Wolf", 1968);
            System.out.println("Constructor with name and hire date:");
            e4.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e5 = new Employee("Sharon Kelly", "123-45-6789");
            System.out.println("Constructor with name and ssn:");
            e5.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e6 = new Employee("Joann Rousch", 333333.33, 1963);
            System.out.println("Constructor with name, salary & hire date:");
            e6.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e7 = new Employee("Lucy Sharp", 444444.44, "987-65-4321");
            System.out.println("Constructor with name, salary & ssn:");
            e7.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e8 = new Employee("Pierre Sokolskis", 1964, "999-99-9999");
            System.out.println("Constructor with name, hire date & ssn:");
            e8.writeOutput();
            System.out.println();
            System.out.println("===============================");

            Employee e9 = new Employee("Last One", 555.55, 1999,
                    "888-88-8888");
            System.out.println("Constructor with name, salary, hire date, and ssn:");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // Test methods to change, return and write values
            // change all
            System.out.println("Before:");
            e9.writeOutput();
            System.out.println();
            System.out.println("After method to change all:");
            System.out.println();
            e9.set("Changed Name", 1010.10, 1010, "101-10-1010");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // change name
            e9.setName("Jekyl N. Hyde");
            System.out.println("After method to change name:");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // return name
            System.out.println("Return method for name: " + e9.getName());
            System.out.println();
            // write name
            System.out.println("Write name method:");
            System.out.println();
            e9.writeName();
            System.out.println();
            // change salary
            System.out.println("Before:");
            e9.writeOutput();
            System.out.println();
            e9.setSalary(987.65);
            System.out.println("After method to change salary:");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // return salary
            System.out.println("Return method for salary: " + e9.getSalary());
            System.out.println();

            // write salary
            System.out.println("Write salary method:");
            System.out.println();
            e9.writeSalary();
            System.out.println();

            // change hire date
            System.out.println("Before:");
            e9.writeOutput();
            System.out.println();
            e9.setHireDate(2001);
            System.out.println("After method to change hire date:");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // return hire date
            System.out.println("Return method for hire date: " + e9.getHireDate());
            System.out.println();

            // write hire date
            System.out.println("Write hire date method:");
            System.out.println();
            e9.writeHireDate();
            System.out.println();

            // change social security number
            System.out.println("Before:");
            e9.writeOutput();
            System.out.println();
            e9.setSsn("777-77-7777");
            System.out.println("After method to change ssn:");
            e9.writeOutput();
            System.out.println();
            System.out.println("===============================");

            // return social security number
            System.out.println("Return method for ssn: " + e9.getSsn());
            System.out.println();

            // write social security number
            System.out.println("Write ssn method:");
            System.out.println();
            e9.writeSsn();
            System.out.println();

            // test equals

            // create e10 with the same vales as e9
            // and it should test true
            Employee e10 = new Employee("Jekyl N. Hyde", 987.65, 2001, "777-77-7777");
            System.out.println("Employee 9 data:");
            e9.writeOutput();
            System.out.println();
            System.out.println("Employee 10 data:");
            e10.writeOutput();
            System.out.println();
            if(e9.equals(e10))
                System.out.println("TRUE: e9 equals e10!");
            else
                System.out.println("FALSE: e9 does NOT equal e10.");

            System.out.println();
            e10.setSsn("777-77-777"); // create a single char difference
            System.out.println("After changing just one character"
                    + " in the social security number,");
            System.out.println("the data for the 2 employees are");
            System.out.println();
            System.out.println("Employee 9 data:");
            e9.writeOutput();
            System.out.println();
            System.out.println("Employee 10 data:");
            e10.writeOutput();
            System.out.println();
            if(e9.equals(e10))
                System.out.println("TRUE: e9 equals e10!");
            else
                System.out.println("FALSE: e9 does NOT equal e10.");

            System.out.println("Do again? (Y for Yes, or N for No)");
            repeat = keyboard.next().charAt(0);

        } while((repeat == 'y') || (repeat == 'Y'));

    }

}