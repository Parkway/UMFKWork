import java.io.*;
import java.util.*;

public class SortedIntegerNoDuplicates {
    public static void main(String[] args) throws IOException {
        writer();
    }
    //For reference, FN is File Name
    private static void writer() throws IOException {
        boolean firstNum = true;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter input file name:");
        String originalFN = scn.next();
        System.out.print("Enter output file name:");
        String newFN = scn.next();
        try {
            File file = new File(newFN);                                    //W
            PrintWriter PW = new PrintWriter((new FileWriter(file)));       //T
            Scanner fScan = new Scanner(new File(originalFN));              //F

            int temp = 0;
            while (fScan.hasNextLine()){
                String line = fScan.nextLine();
                int number = Integer.parseInt(line);
                if(firstNum){
                    PW.write(line);
                    if (fScan.hasNextLine()) {
                        PW.println();
                    }
                    temp = number;
                    firstNum = false;
                }
                else if (temp!= number){
                    PW.write(line);
                    if (fScan.hasNextLine())
                        PW.println();
                    temp = number;
                }
            }
            //closes scanners and print writers
            scn.close();
            PW.close();
            fScan.close();
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