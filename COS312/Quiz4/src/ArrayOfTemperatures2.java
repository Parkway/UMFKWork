/*****************************************
 * Created by Lance Douglas on 4/7/2017
 *
 * This program prompts the user to enter
 * an user-specified number of temperatures,
 * and then provides the average and other
 * fun information.
 *****************************************/

import javax.swing.*;

public class ArrayOfTemperatures2 extends JFrame
{
    public static void main(String[] args){
        String output;

        String stringSize = JOptionPane.showInputDialog("How many temperatures do you have?");
        int size = Integer.parseInt(stringSize);
        double[] temperature = new double[size];

        String firstNumber = JOptionPane.showInputDialog("Enter the first temperature:");
        temperature[0] = Double.parseDouble(firstNumber);
        double sum = temperature[0];

        for (int index = 1; index < temperature.length; index++)
        {
            String stringTemperature = JOptionPane.showInputDialog("Enter the next temperature:");
            temperature[index] = Double.parseDouble(stringTemperature);
            sum = sum + temperature[index];
        }
        double average = sum / temperature.length;
        output = "The average temperature is " + average;
        for (int index = 0; index < temperature.length; index++)
        {
            if (index>0){
                output = output +"\n" + average(temperature[index],average);
            }
            else{
                output = output + "\n The temperatures are: \n" + average(temperature[index],average);
            }
        }
        output = output + "\nHave a nice week.";
        JOptionPane.showMessageDialog(null,output);
    }
    static String average(double temperature,double average) {
        String averageTemp;
        if (temperature < average)
            averageTemp = (temperature + " is below average");
        else if (temperature > average)
            averageTemp = (temperature + " is above average");
        else
            averageTemp = (temperature + " is the average");
        return averageTemp;
    }
}
