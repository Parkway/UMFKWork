/*****************************************
 * Created by Lance Douglas on 4/14/2017
 *****************************************/
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFileInputDemo2
{
    public static void main(String[] args)
    {
        String fileName = JOptionPane.showInputDialog("Enter file name: ");
        if (!fileName.contains(".txt")) {
            fileName = fileName + ".txt";
        }

        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Error opening the file " + fileName +
                            "\nFile not found.");
            System.exit(0);
        }

        String line = inputStream.nextLine();

        JOptionPane.showMessageDialog(null,
                "The file " + fileName + "\ncontains the following lines:\n" + line);

        inputStream.close();
    }
}