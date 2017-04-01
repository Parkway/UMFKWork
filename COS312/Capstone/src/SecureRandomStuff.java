import java.security.SecureRandom;

/*****************************************
 * Created by Lance Douglas on 3/20/2017
 *****************************************/
public class SecureRandomStuff {
    public static void main(String[] args) throws Exception {
        SecureRandom secRan = SecureRandom.getInstanceStrong();
        byte[] values = new byte[20];
        secRan.nextBytes(values);

        System.out.println(values);
    }
}
