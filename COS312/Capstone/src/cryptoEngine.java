import java.math.BigInteger;
import java.security.*;
import java.util.*;

/************************************
 * Created by Lance Douglas on 2/10/2017
 ************************************/
public class cryptoEngine {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Hi there!\n" +
                "This program is designed to take a String," +
                "\nAnd return several different hashes of it.");

        String ogString = scn.nextLine();

        md5(ogString);
        sha(ogString);

    }
    private static void md5 (String ogString) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(ogString.getBytes(), 0, ogString.length());
            System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
        } catch (NoSuchAlgorithmException NSAE) {

        }
    }
    private static void sha (String ogString) {
        //TODO Generate SHA algorithms.
    }
}
