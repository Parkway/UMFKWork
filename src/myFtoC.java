import java.util.Scanner;
//The commented code at the bottom is the actual assignment. I just think the following code will be more fun.
public class myFtoC {
    public static void main(String[] args) {
        intro();
    }
    private static void print(String s) {
        System.out.println(s);
    }
    private static void FtoC() {
        print("Please enter temperature that you wish to convert.");
        Scanner FC = new Scanner(System.in);
        double FtoC = FC.nextDouble();
        double Ctemp = (FtoC - 32) * 5/9;
        print("In Celsius, " + FtoC + "°F is " + Ctemp + "°.");
    }
    private static void CtoF() {
        print("Please enter temperature that you wish to convert");
        Scanner CF = new Scanner(System.in);
        double CtoF = CF.nextDouble();
        double Ftemp = (CtoF * 9/5) + 32;
        print("In Fahrenheit, " + CtoF + "°C is " + Ftemp + "°.");
    }
    private static void intro() {
        print("Would you like to convert from\n"
                + "Fahrenheit to Celsius, or\n"
                + "Celsius to Fahrenheit?");
        Scanner scn = new Scanner(System.in);
        String conversion = scn.nextLine();
        if(conversion.toLowerCase().equals("Fahrenheit to Celsius".toLowerCase())) {
            print("Converting Fahrenheit to Celsius.");
            FtoC();
        } else if (conversion.toLowerCase().equals("Celsius to Fahrenheit".toLowerCase())) {
            print("Converting Celsius to Fahrenheit.");
            CtoF();
        } else {
            print("Not an option, please try again.");
            intro();
        }
    }
}













/*import java.util.Scanner;
/*This program converts Fahrenheit to Celsius. Nothing exciting.
  Lance Douglas, FtoC, September 16, 2016.

public class myFtoC {
   public static void main(String[] args) {
      print("Enter a temperature (whole number) in degrees Fahrenheit.");
      Scanner scn = new Scanner(System.in);
      double fahrTemp = scn.nextInt();
      double celsTemp = (fahrTemp - 32) * 5/9; //Math for conversion.
      print(fahrTemp + " degrees Fahrenheit = " + celsTemp + " degrees Celsius."); //Sysout with multiple vars.
   }
}*/