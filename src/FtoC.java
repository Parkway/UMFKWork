import java.util.Scanner;
/*This program converts Fahrenheit to Celsius. Nothing exciting.
  Lance Douglas, FtoC, September 16, 2016. */
public class FtoC {
   public static void main(String[] args) {
      System.out.println("Enter a temperature (whole number) in degrees Fahrenheit.");
      Scanner scn = new Scanner(System.in);
      double fahrTemp = scn.nextInt();
      double celsTemp = (fahrTemp - 32) * 5/9; //Math for conversion.
      System.out.println(fahrTemp + " degrees Fahrenheit = " + celsTemp + " degrees Celsius."); //Sysout with multiple vars.
   }
}
