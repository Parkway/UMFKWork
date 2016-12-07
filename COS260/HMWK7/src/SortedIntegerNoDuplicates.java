import java.io.*; //New thing!? Necessary components for FS I/O.
import java.util.*;

public class SortedIntegerNoDuplicates { //Disgusting class name.
    public static void main(String[] args) throws IOException { //Throws exception in method called by main method. Why?  ¯\_(ツ)_/¯
        writer();
    }
    //For reference, FN is File Name
    //In my *nix world, FS is innately understood to be File System, so F* means File Something.
    private static void writer() throws IOException { //See line five.
        boolean firstNum = true; //Needed a boolean for T/F
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter input file name:");
        String originalFN = scn.next();
        System.out.print("Enter output file name:");
        String newFN = scn.next();
        try { //For exception handling. This shouldn't be new.
            File file = new File(newFN);                                    //W     Make a new file named the value assigned to variable newFN.
            PrintWriter PW = new PrintWriter((new FileWriter(file)));       //T     Introduce a way to output to previously made file.
            Scanner fScan = new Scanner(new File(originalFN));              //F     Scanner to read input file.

            int temp = 0; //Temporary number.
            while (fScan.hasNextLine()){ //"Scan file to read next line."
                String line = fScan.nextLine();
                int number = Integer.parseInt(line); //Because numbers.txt -> String to integer.
                if(firstNum){
                    PW.write(line); //PrintWriter writes it to output file.
                    if (fScan.hasNextLine()) {
                        PW.println();
                    }
                    temp = number;
                    firstNum = false; //Moral of the story, if num = last num, it's a duplicate and therefore must DIE. :)
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
            fScan.close();  //Told the possible buffer overflow to go f*ck itself! Wait does Java have buffer overflow problems?
            System.out.println("Numbers from input file"
                + "copied to output file with"
                + "duplicates removed.");
        }
        catch(FileNotFoundException e){
            System.out.println("The file is not found. Let's try again.");
            writer(); //Restarts method. Recursion. Neato!
        }
    }
}