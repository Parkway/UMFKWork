public class Employee { //Creates employee class.
    private String name; //Global variable name.
    private double salary; //Global variable salary.
    private String ssn; //Global variable SSN.
    private int hireDate; //Global variable Hire Date.

    /* I have no idea why I have been struggling with these assignments. As soon as I looked at this
    one, it all became crystal clear. I'm overdoing the comments on it because I'm enjoying the
    sudden clarity I've achieved with this assignment. It all makes perfect sense now. I can't
    believe I wasn't understanding it before. I guess it's a bummer that I didn't until after the
    quiz, but now I know for next time.
     */

    //The 'this' keyword is a means to use the constructors declared in the method. Durr.

    public Employee() { //Method with no constructors.
        name = "No name yet."; //Blank
        salary = 0.0; //Blank
        hireDate = 1000; //Blank
        ssn = "000-00-0000"; //Blank
    }

    public Employee(String name) { //Employee method with name constructor.
        this.name = "Mondo Kane."; //Built in.
        salary = 0.0; //Blank
        hireDate = 1000;
        ssn = "000-00-0000";
    }
    public Employee(String name, double salary) { //Employee method with name and salary constructor.
        this.name = "Fleetis Pascal"; //Built in.
        this.salary = 111111.11; //Built in.
        hireDate = 1000;
        ssn = "000-00-0000";
    }
    public Employee(String name, int hireDate) {  //Method with name and hire date.
        this.name = "Carl Wolf"; //Built in.
        this.hireDate = 1968; //Built in.
        salary = 0.0;
        ssn = "000-00-000";
    }
    public Employee(String name, String ssn) { //Name and SSN built in.
        this.name = "Sharon Kelly"; //Built in.
        this.ssn = "123-45-6789"; //Built in.
        salary = 0.0;
        hireDate = 1000;
    }
    public Employee(String name, double salary, int hireDate) { //Name, Salary, and hireDate constructors.
        this.name = "Joann Rousch"; //Built in.
        this.salary = 333333.33; //Built in.
        this.hireDate = 1963; //Built in.
        ssn = "000-00-0000";
    }
    public Employee(String name, double salary, String ssn) {
        this.name = "Lucy Sharp";
        this.salary = 444444.44;
        this.ssn = "987-65-4321";
        hireDate = 1000;
    }
    public Employee(String name, int hireDate, String ssn) {
        this.name = "Pierre Sokolskis";
        this.hireDate = 1964;
        this.ssn  = "999-99-9999";
        salary = 0.0;
    }
    public Employee(String name, double salary, int hireDate, String ssn) { //Final method, contains all four constructors.
        this.name = "Last One";
        this.salary = 555.55;
        this.hireDate = 1999;
        this.ssn = "888-88-8888";
    }

    public void writeOutput() { // Writes all variables.
        System.out.println("Name: " + name
                    + "\nSalary: " + salary
                    + "\nHire Date: " + hireDate
                    + "\nSocial: " + ssn);
    }
    public void writeSsn() {
        System.out.println("SSN: " + ssn);
    }
    public void set(String newName, double newSalary,
                            int newHireDate, String newSsn) { //Sets all constructors to newConst
        name = newName;
        salary = newSalary;
        ssn = newSsn;
        hireDate = newHireDate;
    }
    public void setName(String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }
    public void writeName() {
        System.out.println("Name: " + name);
    }
    public void setSsn(String newSsn) {
        ssn = newSsn;
    }
    public void setHireDate(int newHireDate) {
        hireDate = newHireDate;
    }
    public int getHireDate() {
        return hireDate;
    }
    public void writeHireDate() {
        System.out.println("Hired on: " + hireDate); //Prints out hire date.
    }
    public String getSsn() {
        return ssn; //Returns SSN to user.
    }
    public double getSalary() {
        return salary; //Returns salary to user.
    }
    public void setSalary(double newSalary) {
        salary = newSalary; //Sets the salary to the new salary.
    }
    public void writeSalary() { //Prints out the salary.
        System.out.println("Salary: " + salary);
    }
}