import java.util.Random;
// This program offers two ways to generate random numbers in java. Math.random(), and java.util.Random;.
public class randomNumberGen {
    public static void main(String[] args) {
        double i = 10;
        while (i > 0) {
            i--;
            double random = Math.random() * 50 + 1; //Random doubles. From 1-50.
            System.out.println(random);
        }
        System.out.println("\n");
        while (i < 20) {
            i++;
            Random rand = new Random();
            int randNum = rand.nextInt(50) + 1; //Random integers. From 1-50.
            System.out.println(randNum);
        }
    }
}
