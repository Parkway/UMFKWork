import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

/*****************************************
 * Created by Lance Douglas on 4/14/2017
 *
 * This class is designed to allow the
 * user to write to or read from any
 * local text file. I did some fun
 * and cool stuff with it. This program
 * in particular has a host of neat
 * features that I felt were necessary.
 *
 * More info in the readme.
 *
 * TextFileIO_GUI, April 16th, 2017.
 *****************************************/

public class TextFileIO_GUI {

    public static void main(String[] args) {

        //Setting font and font size universally.
        UIManager.put("OptionPane.messageFont", new Font(
                "Ubuntu", Font.PLAIN, 14));

        /*Initialize program and describe to user what it's for
        and how to use it.
         */

        JOptionPane.showMessageDialog(null,
                "This program allows you to write to, and read from,\n" +
                        "any local text file. Please press \"OK\" to begin.\n" +
                        "Side note: file names ARE case sensitive.");

        //Open opener method.
        opener();
    }
    private static void opener() {

        //Ask user what they want to do, allow for read, write, and help methods.

        String choice = JOptionPane.showInputDialog("Would you like to write text to a file\n" +
                "or read text from a file?\nEnter \"Write\" to write to one,\n" +
                "or \"Read\" to read from one.\n" +
                "For more information, enter \"Help\".").toLowerCase();

        //If{else} for choice made above.

        if (choice.equals("read")) {
            reader();
        } else if (choice.equals("write")) {
            writer();
        } else if (choice.equals("help")) {
            helper();
        } else {
            /*If they did something that wasn't accounted for,
             a new GUI is displayed offering a second chance, or exiting of program.
             Basic if{else}, nothing exciting.
             */
            String repeater = JOptionPane.showInputDialog("That was not an option. \nPlease enter \"Again\" to try again, " +
                            "or enter \"Exit\" to close the program.").toLowerCase(); //toLowerCase resolves any case issues.
            if (repeater.equals("exit")) {
                JOptionPane.showMessageDialog(null,
                        "Good bye.");
                System.exit(1337); //Lol 2haxor
            } else if (repeater.equals("again")) {
                JOptionPane.showMessageDialog(null,
                        "Alright, let's try again.");
                opener();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Whatever you typed wasn't an option.\n" +
                                "The program will close.");
                System.exit(0);
            }
        }
    }

    private static void writer() {
        /* This method handles the first part of writing
         * to a file - checking if the file exists,
         * and deciding if it should be overwritten.
         * Once again, adds .txt.
         */
        String fileName = JOptionPane.showInputDialog("Enter file where data will be stored:");

        if (!fileName.contains(".txt")) {
            fileName = fileName + ".txt";
        }

        //Declares that variable fileName is a new official File rather than just a glorified String
        File F = new File(fileName);

        /* Checks if fileName is an existing file,
         * and then offers to overwrite or begin again.
         */
        if (F.isFile()) {
            int overwrite = JOptionPane.showConfirmDialog(null,
                    "This file already exists, would you like to overwrite it?",
                    "Overwrite?", JOptionPane.YES_NO_OPTION);
                if (overwrite == JOptionPane.YES_OPTION) {
                    writer2(fileName);
                } else if (overwrite == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null,
                        "Trying again.");
                    writer();
                }
            } else {
                writer2(fileName);
        }

    }
    private static void writer2(String fileName) {
        /* This method handles the actual writing
         * of text to the txt file and accounts
         * for FNFEs.
         */

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException FNFE) {
            JOptionPane.showMessageDialog(null,
                    "Error opening the file " + fileName + ":" +
                            "File not found.");
            System.exit(0);
        }

        String line = JOptionPane.showInputDialog("Enter text for the file:");
        outputStream.println(line);


        outputStream.close();
        JOptionPane.showMessageDialog(null,
                    "The text was written to " + fileName);

        JOptionPane.showMessageDialog(null,
                    "Good bye.");
    }

    private static void reader() {
        /* This method is responsible for reading files.
         * It automatically adds .txt to ensure search for text files,
         * and it handles filenotfound exceptions, and it even
         * word wraps longer messages! Neato!
         */
        String fileName = JOptionPane.showInputDialog("Enter file name:");

        if (!fileName.contains(".txt")) {
            fileName = fileName + ".txt";
        }
        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException FNFE)
        {
            JOptionPane.showMessageDialog(null,
                    "Error opening the file " + fileName +
                            "\nFile not found.");
            System.exit(0);
        }

        String line = inputStream.nextLine();

        //This particular fustercluck of a JOP
        //handles WordWrap by implementing some HTML magic.
        JOptionPane.showMessageDialog(null,
                "The file \"" + fileName + "\"\ncontains the following message:\n" +
                        "<html><body><p style='width: 250px;'>"+line+"</p></body></html>");

        inputStream.close();
        JOptionPane.showMessageDialog(null,
                "Good bye.");
    }

    private static void helper() {

        /* This just displays a help message for the less...
         * technologically inclined users.
         */

        JOptionPane.showMessageDialog(null,
                "Hello there,\n" +
                        "This program is designed to facilitate you in\n" +
                        "reading and writing various text files on your device.\n" +
                        "In each section, you will be prompted on what to do.\n\n" +
                        "Writer: This section will prompt you to create a text file\n" +
                        "and subsequently have you enter data to it.\n" +
                        "Reader: This section prompts you to enter the name of\n" +
                        "a preexisting file. Then, the program will read the\n" +
                        "information contained within the file.\n\n" +
                        "Press \"OK\" to return to the program.");
        opener();
    }
}
