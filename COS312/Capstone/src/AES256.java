import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/*****************************************
 * Created by Lance Douglas on 4/19/2017
 *****************************************/
public class AES256 {
    public static void main(String[] args) {
        try {

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(256);


            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();

            System.out.println(raw);

        } catch (NoSuchAlgorithmException NSAE) {
            System.out.println("Shit ain't no gud.");
        }
    }
}
