import java.io.*;
import java.util.*;

public class SortedIntegerNoDuplicates {
    public static void main(String[] args) throws IOException {
        writer();
    }

    static void writer() throws IOException {
        boolean firstNum = true;
        Scanner scn = new Scanner(System.in);
        //gives instructions for the user
        System.out.println("Enter input file name:");
        String originalFileName = scn.next();
        System.out.println("Enter output file name:");
        String newFileName = scn.next();
        try {
            File file = new File(newFileName);
            PrintWriter print = new PrintWriter((new FileWriter(file)));
            Scanner fileScanner = new Scanner(new File(originalFileName));

            int temp = 0;
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                int number = Integer.parseInt(line);
                if(firstNum){
                    print.write(line);
                    if (fileScanner.hasNextLine()) {
                        print.println();
                    }
                    temp = number;
                    firstNum = false;
                }
                else if (temp!= number){
                    print.write(line);
                    if (fileScanner.hasNextLine())
                        print.println();
                    temp = number;
                }
            }
            //closes scanners and print writers
            scn.close();
            print.close();
            fileScanner.close();
            System.out.println("Numbers from input file");
            System.out.println("copied to output file with");
            System.out.println("duplicates removed.");
        }
        catch(FileNotFoundException e){
            System.out.println("The file is not found. Let's try again.");
            writer();
        }
    }
}