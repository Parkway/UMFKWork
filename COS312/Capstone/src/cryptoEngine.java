import java.math.BigInteger;
import java.security.*;
import java.util.*;

/*****************************************
 * Created by Lance Douglas on 2/10/2017
 *****************************************/

public class cryptoEngine {
    public static void main(String[] args) throws Exception {
        stringer();
    }
    private static void stringer() throws Exception {
        Scanner scn = new Scanner(System.in);

        System.out.println("Hi there!\n" +
                "This program is designed to take a String," +
                "\nAnd return several different hashes of it." +
                "\nPlease enter your string:");

        String ogString = scn.nextLine();

        md5(ogString);
        Thread.sleep(750);
        sha512(ogString);
        Thread.sleep(750);
        sha1(ogString);
        Thread.sleep(750);
        again();

    }
    private static void md5 (String ogString) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(ogString.getBytes(), 0, ogString.length());
            String md5 = new BigInteger (1, m.digest()).toString(16);
            System.out.println("MD5: " + md5);
            //TODO: Randomly generate string index % times, and then randomly add chars to hashed index.



        } catch (NoSuchAlgorithmException NSAE) {
            //Not empty nowwwww.
        }
        
    }
    private static void sha512 (String ogString) {
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-512");
            m.update(ogString.getBytes(), 0, ogString.length());
            String sha512 = new BigInteger (1, m.digest()).toString(16);
            System.out.println("SHA-512: " + sha512);
        } catch (NoSuchAlgorithmException NSAE) {
            //Not empty nowwww.
        }
        
    }
    private static void sha1 (String ogString) {
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-1");
            m.update(ogString.getBytes(), 0, ogString.length());
            String sha1 = new BigInteger (1, m.digest()).toString(16);
            System.out.println("SHA-1: " + sha1);
        } catch (NoSuchAlgorithmException NSAE) {
            //Fuk u
        }
    }
    private static void MiniCrypto (String md5, String sha512,
                                    String sha1) {
        try {
            MessageDigest m = MessageDigest.getInstance("PBKDF2");
            sha1 = new BigInteger(1, m.digest()).toString(16);
            System.out.println(sha1);
        } catch (NoSuchAlgorithmException NSAE) {
            System.out.println("PBKDF2 is not supported by MessageDigest.");
        }

    }
    
    private static void again() throws Exception{
        Scanner scn = new Scanner(System.in);
        System.out.println("Would you like to convert another string?");
        String repeat = scn.nextLine().toLowerCase();
        if (repeat.contains("y")) {
            System.out.println("Alright, another!");
            stringer();
        } else {
            System.out.println("Okay byeeee!");
        }
    }
}
