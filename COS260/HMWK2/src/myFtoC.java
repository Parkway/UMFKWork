import javax.swing.*;
//The commented code at the bottom is the actual assignment. I just think the following code will be more fun.
public class myFtoC {
    public static void main(String[] args) {
        intro();
    }
    private static void intro() {
        String conversion = JOptionPane.showInputDialog("Would you like to convert from\n"
                + "Fahrenheit to Celsius, or\n"
                + "Celsius to Fahrenheit?");
        if(conversion.toLowerCase().equals("Fahrenheit to Celsius".toLowerCase())) {
            FtoC();
        } else if (conversion.toLowerCase().equals("Celsius to Fahrenheit".toLowerCase())) {
            CtoF();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Not an option, please try again.");
            intro();
        }
    }
    private static void FtoC() {
        String FtoC = JOptionPane.showInputDialog("Please enter temperature that you wish to convert.");
        double FC = Double.parseDouble(FtoC);
        JOptionPane.showMessageDialog(null,
                "Converting Fahrenheit to Celsius.");
        double Ctemp = (FC - 32) * 5/9;
        JOptionPane.showMessageDialog(null,
                "In Celsius, " + FtoC + "°F is " + Ctemp + "°.");
        System.exit(0);
    }
    private static void CtoF() {
        String CtoF = JOptionPane.showInputDialog("Please enter temperature that you wish to convert");
        double CF = Double.parseDouble(CtoF);
        JOptionPane.showMessageDialog(null,
                "Converting Celsius to Fahrenheit.");
        double Ftemp = (CF * 9/5) + 32;
        JOptionPane.showMessageDialog(null,
                "In Fahrenheit, " + CtoF + "°C is " + Ftemp + "°.");
        System.exit(0);
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
