import java.util.Arrays;
import java.util.Scanner;

public class SortInteger {
    public static void main(String[] args) {
        System.out.println("Enter three whole numbers:");
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int num3 = scn.nextInt();

        int oneMinTwo = Math.min(num1, num2);
        int twoMinThree = Math.min(num2, num3);
        int oneMaxTwo = Math.max(num1, num2);
        int twoMaxThree = Math.max(num2, num3);

        int lowest = Math.min(oneMinTwo, twoMinThree);
        int middlest = Math.min(oneMaxTwo, twoMaxThree);
        int largest = Math.max(oneMaxTwo, twoMaxThree);
        System.out.println(lowest + " " + middlest + " " + largest);
    }
}
