import javax.swing.*;
import java.math.BigInteger;
import java.security.*;
/*****************************************
 * Created by Lance Douglas on 2/10/2017
 *
 * This class is meant to be a rudimentary
 * method of creating a relatively secure
 * password for the end user. Each
 * password generated is guaranteed to
 * last at least a long ass time before
 * being cracked by a password breaker.
 *
 * Basically, a user entered string is
 * hashed into an md5; the md5 is hashed
 * into a SHA-512; the SHA-512 is hashed
 * into a SHA-1. Then, each of these
 * Strings is added together, and hashed
 * once more as an MD5.
 *****************************************/

public class cryptoEngine {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null,
                "Hi there!\n" +
                        "This program is designed to take a String" +
                        "\nand return several different hashes of it.");

        starter();
    }
    private static void starter(){
        UIManager.put("OptionPane.okButtonText","Hash");
        String ogString = JOptionPane.showInputDialog(null,
                "Please enter your string:");

        if (ogString.equals("")) {
            UIManager.put("OptionPane.okButtonText","OK");
            JOptionPane.showMessageDialog(null,
                    "String can't be blank, try again!");
            starter();
        }

        UIManager.put("OptionPane.okButtonText","OK");

        encrypt(ogString);
    }
    private static void encrypt (String ogString) {
        try {
            MessageDigest m1 = MessageDigest.getInstance("MD5");
            m1.update(ogString.getBytes(), 0, ogString.length());
            String md5 = new BigInteger (1, m1.digest()).toString(32);

            MessageDigest m2 = MessageDigest.getInstance("SHA-512");
            m2.update(ogString.getBytes(), 0, ogString.length());
            String sha512 = new BigInteger (1, m2.digest()).toString(32);

            MessageDigest m3 = MessageDigest.getInstance("SHA-1");
            m3.update(ogString.getBytes(), 0, ogString.length());
            String sha1 = new BigInteger (1, m3.digest()).toString(32);


            String combohash = md5 + sha512 + sha1;

            MessageDigest mTotal = MessageDigest.getInstance("MD5");
            mTotal.update(combohash.getBytes(),0, combohash.length());
            String totalHash = new BigInteger(1, mTotal.digest()).toString(24);


            String totalHash32 = totalHash;
            String totalHash16 = totalHash.substring(8,24);

            JOptionPane.showMessageDialog(null,
                "When converted to these " +
                        "hash algorithms, the string \"" + ogString +
                        "\" returns the following hashes:" +
                        "\nMD5: " + md5 +
                        "\nSHA-512: " + sha512 +
                        "\nSHA-1: " + sha1 +
                        "\n\nFinally, your securely hashed String:" +
                        "\n32 Digits: " + totalHash32 +
                        "\n16 Digits: " + totalHash16 + ".\n" +
                        "\nFor ease of use, each of these Strings will now be displayed in the run tab.\n" +
                        "Please feel free to copy and paste as necessary.");

            System.out.println(totalHash32);
            System.out.println(totalHash16 + "\n");



        } catch (NoSuchAlgorithmException NSAE) {
            System.exit(22);
        } catch (NullPointerException NPE) {
            System.exit(12);
        }
        again();
    }
    
    private static void again() {
        int repeat = JOptionPane.showConfirmDialog(null,
                "Would you like to convert another string?", "Encrypt Another?",
                JOptionPane.YES_NO_OPTION);
        if (repeat == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Alright, another!");
            starter();
        } else if (repeat == JOptionPane.NO_OPTION) {
            UIManager.put("OptionPane.okButtonText","Bye!");

            JOptionPane.showMessageDialog(null,
                    "Okay byeeee!");
            System.exit(2);
        } else {
            System.exit(1);
        }
    }
}
