import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

/************************************************************************************
 * Created by Lance Douglas on 4/14/2017                                            *
 *                                                                                  *
 * This class is designed to allow the user to write to or read from any local      *
 * text file. I did some fun and cool stuff with it. This program in particular     *
 * has a host of neat features that I felt were necessary.                          *
 *                                                                                  *
 * A lot of new code here, so I'm going to specify one certain statement here:      *
 *                                                                                  *
 * The JOptionPanes all follow a very specific implementation:                      *
 *                                                                                  *
 *          JOP.show***Pane(null(parent object),                                    *
 *          message(displayed to user), title                                       *
 *          (the title of the window), and then                                     *
 *          JOP.TYPE(Specifies how to info                                          *
 *          should be presented to the user.                                        *
 *                                                                                  *
 * More info in the readme.                                                         *
 *                                                                                  *
 * TextFileIO_GUI, April 16th, 2017.                                                *
 ************************************************************************************/

public class TextFileIO_GUI {

    public static void main(String[] args) {
        try {

            //Setting font and font size universally.
            UIManager.put("OptionPane.messageFont", new Font(
                    "Ubuntu", Font.PLAIN, 14));

        /*Initialize program and describe to user what it's for
        and how to use it.
         */

            JOptionPane.showMessageDialog(null,
                    "This program allows you to write to, and read from,\n" +
                            "any local text file. Please press \"OK\" to begin.", "TextFileIO", JOptionPane.PLAIN_MESSAGE);

            //Open opener method.
            opener();
        } catch (NullPointerException NPE) {
            System.exit(0);
        }
    }
    private static void opener() {
        try {

            UIManager.put("OptionPane.yesButtonText","Write");
            UIManager.put("OptionPane.noButtonText", "Read");
            UIManager.put("OptionPane.cancelButtonText", "Help");

            //Ask user what they want to do, allow for read, write, and help methods.

            int choice = JOptionPane.showConfirmDialog(null,
                    "Would you like to\nWrite to a file?\n" +
                            "Read from a file?\nOr get help using this program?",
                        "Choice", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                writer();
            } else if (choice == JOptionPane.NO_OPTION) {
                reader();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                helper();
            }
        } catch (Exception E) {
            System.exit(1);
        }
    }

    private static void writer() {
        try {
        /* This method handles the first part of writing
         * to a file - checking if the file exists,
         * and deciding if it should be overwritten.
         * Once again, adds .txt.
         */
            UIManager.put("cancelButtonText","Cancel");

            String fileName = JOptionPane.showInputDialog(null,
                    "Enter file where data will be stored:",
                    "File Name", JOptionPane.PLAIN_MESSAGE);

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
                            "Trying again.", "Whoopsie.",
                            JOptionPane.PLAIN_MESSAGE);
                    writer();
                }
            } else {
                writer2(fileName);
            }
        } catch (Exception E) {
            System.exit(3);
        }

    }
    private static void writer2(String fileName) {
        try {
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
                                "File not found.", "File Not Found Error",
                        JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

            String line = JOptionPane.showInputDialog(null,
                    "Enter text for the file:", "Enter Data",
                    JOptionPane.PLAIN_MESSAGE);
            outputStream.println(line);


            outputStream.close();
            JOptionPane.showMessageDialog(null,
                    "The text was written to " + fileName,
                    "Data Entry Complete.", JOptionPane.PLAIN_MESSAGE);

            JOptionPane.showMessageDialog(null,
                    "Good bye.", "Good bye.", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception E) {
            System.exit(4);
        }
    }

    private static void reader() {
        try {
        /* This method is responsible for reading files.
         * It automatically adds .txt to ensure search for text files,
         * and it handles filenotfound exceptions, and it even
         * word wraps longer messages! Neato!
         */
            String fileName = JOptionPane.showInputDialog(null,
                    "Enter file name:", "Reader", JOptionPane.PLAIN_MESSAGE);

            if (!fileName.contains(".txt")) {
                fileName = fileName + ".txt";
            }
            Scanner inputStream = null;

            try {
                inputStream = new Scanner(new File(fileName));
            } catch (FileNotFoundException FNFE) {
                JOptionPane.showMessageDialog(null,
                        "Error opening the file " + fileName +
                                "\nFile not found.", "Error", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

            String line = inputStream.nextLine();

            //This particular fustercluck of a JOP
            //handles WordWrap by implementing some HTML magic.
            JOptionPane.showMessageDialog(null,
                    "The file \"" + fileName + "\"\ncontains the following message:\n" +
                            "<html><body><p style='width: 250px;'>" + line + "</p></body></html>",
                    fileName, JOptionPane.PLAIN_MESSAGE);

            inputStream.close();
            JOptionPane.showMessageDialog(null,
                    "Good bye.", "Good bye.", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception E) {
            System.exit(5);
        }
    }

    private static void helper() {
        try {
        /* This just displays a help message for the less...
         * technologically inclined users.
         */

            String helpText = "Hello there,<br>" +
                    "This program is designed to facilitate in the " +
                    "reading and writing various text files on your device. " +
                    "In each section, you will be prompted on what to do.<br><br>" +
                    "Writer: This section will prompt you to create a text file " +
                    "and subsequently have you enter data to it.<br><br>" +
                    "Reader: This section prompts you to enter the name of " +
                    "a preexisting file. Then, the program will read the " +
                    "information contained within the file.<br><br>" +
                    "Press \"OK\" to return to the program.";

            JOptionPane.showMessageDialog(null,
                    "<html><body><p style='width: 250px;'>" + helpText + "</p></body></html>",
                    "Help", JOptionPane.PLAIN_MESSAGE);
            opener();
        } catch (Exception E) {
            System.exit(6);
        }
    }
}