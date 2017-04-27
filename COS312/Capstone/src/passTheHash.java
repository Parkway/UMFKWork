import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Random;

/************************************************************************************
 * Created by Lance Douglas on 2/10/2017 - Capstone Project                         *
 *                                                                                  *
 * This class is meant to be a rudimentary method of creating a relatively secure   *
 * password for the end user. Each password generated is guaranteed to last at      *
 * least a long ass time before being cracked by a password breaker.                *
 *                                                                                  *
 * Basically, a user entered string is hashed into an md5; the md5 is hashed        *
 * into a SHA-512; the SHA-512 is hashed into a SHA-1. Then, each of these          *
 * Strings is added together n times, and hashed once more as a SHA-512.            *
 * Finally, two Strings are stripped from the SHA-512: A 16 and 32 digit selection. *
 * These are the final hashes.                                                      *
 ************************************************************************************/

public class passTheHash {
    public static void main(String[] args) throws Exception {
        UIManager.put("OptionPane.messageFont", new Font(
                "Hack", Font.PLAIN, 14));

        JOptionPane.showMessageDialog(null,
                "Hi there!\n" +
                        "This program is designed to take a String" +
                        "\nand return several different hashes of it,\n" +
                        "including two unique strings to be used as passwords.");

        starter();
    }
    private static void starter(){
        try {
            UIManager.put("OptionPane.okButtonText", "Hash");
            String ogString = JOptionPane.showInputDialog(null,
                    "Please enter your string:");

            if (ogString.equals("")) {
                UIManager.put("OptionPane.okButtonText", "OK");
                JOptionPane.showMessageDialog(null,
                        "String can't be blank, try again!");
                starter();
            }

            UIManager.put("OptionPane.okButtonText", "OK");
            encrypt(ogString);
        } catch (NullPointerException NPE) {
            System.exit(123);
        }
    }

    private static void encrypt (String ogString) {
        try {
            Random random = new Random();
            int number = random.nextInt(10);

            MessageDigest m1 = MessageDigest.getInstance("MD5");
            m1.update(ogString.getBytes(), 0, ogString.length());
            String md5 = new BigInteger (1, m1.digest()).toString(32);

            MessageDigest m2 = MessageDigest.getInstance("SHA-512");
            m2.update(ogString.getBytes(), 0, ogString.length());
            String sha512 = new BigInteger (1, m2.digest()).toString(32);

            MessageDigest m3 = MessageDigest.getInstance("SHA-1");
            m3.update(ogString.getBytes(), 0, ogString.length());
            String sha1 = new BigInteger (1, m3.digest()).toString(32);


            String combohash = md5 + sha1 + sha512;

            StringBuilder SB = new StringBuilder(combohash);
            for (int i = 0; i < number; number--) {
                combohash += SB.append(combohash);
            }

            MessageDigest mTotal = MessageDigest.getInstance("SHA-512");
            mTotal.update(combohash.getBytes(), 0, combohash.length());
            String totalHash = new BigInteger(1, mTotal.digest()).toString(24);


            int subString =  (int) (Math.random() * (98 - 32)) + 32;
            String totalHash32 = totalHash.substring(subString-32, subString);
            String totalHash16 = totalHash.substring(subString-16,subString);

            JOptionPane.showMessageDialog(null,
                "When converted to these " +
                        "hash algorithms, the string \"" + ogString +
                        "\" returns the following hashes:" +
                        "\nMD5: " + md5 +
                        "\nSHA-512: " + sha512 +
                        "\nSHA-1: " + sha1 +
                        "\n\nFinally, your unique securely hashed String:" +
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
        } catch (IndexOutOfBoundsException IOOBE) {
            System.err.println("Something went wrong.");
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
