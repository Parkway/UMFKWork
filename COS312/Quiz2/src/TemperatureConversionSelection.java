import javax.swing.*;

public class TemperatureConversionSelection {
    public static void main(String[] args) {
        intro(); //Opens intro() method. Allows for recursion.
    }
    private static void intro() {

        String conversion = JOptionPane.showInputDialog("Would you like to convert from\n"
                + "Fahrenheit to Celsius, or\n"
                + "Celsius to Fahrenheit?\n" +
                "\"Celsius to Fahrenheit or C to F,\" for example."); //Just a JOptionPane.
        if (conversion.equalsIgnoreCase("Fahrenheit to Celsius") ||
                conversion.equalsIgnoreCase("F to C")) { //If String conversion equals (ignoring capitalization), either of those choices, do whats below.
            FtoC(); // Recursive programming neato.
        } else if (conversion.equalsIgnoreCase("Celsius to Fahrenheit") || // || Is the OR operator. If this OR this.
                conversion.equalsIgnoreCase("C to F")) {
            CtoF(); //Woo recursion.
        } else {
            JOptionPane.showMessageDialog(null,
                    "Not an option, please try again.");
            intro(); //Make them start over. Take that! @Recursion
        }
    }

    /**
     *  This method converts a String into a double, and then converts that double from F to C.
     */
    private static void FtoC() { //This method converts tempF to tempC
        try {
            String FtoC = JOptionPane.showInputDialog("Please enter temperature that you wish to convert.");
            double FC = Double.parseDouble(FtoC); //JOptionPane messages are String only, so this converts the string to a double.
            JOptionPane.showMessageDialog(null,
                    "Converting Fahrenheit to Celsius.");
            double Ctemp = (FC - 32) * 5 / 9; //Maths
            JOptionPane.showMessageDialog(null,
                    "In Celsius, " + FtoC + "°F is " + Ctemp + "°.");
            System.exit(1337);
        } catch (NumberFormatException NFE) { //If the string cannot be converted to a double, tell the user to start over.
            JOptionPane.showMessageDialog(null,
                    "Please try again, and this time use numbers.");
            intro();
        }
    }

    /**
     *  This does the opposite of the first one.
     */

    private static void CtoF() {
        try {
            String CtoF = JOptionPane.showInputDialog("Please enter temperature that you wish to convert");
            double CF = Double.parseDouble(CtoF);
            JOptionPane.showMessageDialog(null,
                    "Converting Celsius to Fahrenheit.");
            double Ftemp = (CF * 9 / 5) + 32;
            JOptionPane.showMessageDialog(null,
                    "In Fahrenheit, " + CtoF + "°C is " + Ftemp + "°.");
            System.exit(0);
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null,
                    "Please try again, and this time use numbers.");
            intro();
        }
    }
}