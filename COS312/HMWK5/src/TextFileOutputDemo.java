/*****************************************
 * Created by Lance Douglas on 4/14/2017
 *****************************************/
import javax.swing.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class TextFileOutputDemo
{
    public static void main(String[] args)
    {
        String fileName = JOptionPane.showInputDialog("Enter file name to store data:");
        if(!fileName.contains(".txt")) {
            fileName = fileName + ".txt";
        }

        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(fileName);
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error opening the file " + fileName);
            System.exit(0);
        }

        String line = JOptionPane.showInputDialog("Enter text for the file:");
        outputStream.println(line);

        outputStream.close( );
        JOptionPane.showMessageDialog(null,
                "The text was written to " + fileName);
    }
}