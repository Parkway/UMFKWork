import java.util.Arrays;
import java.util.Scanner;
/* This program sorts three integers from smallest to largest. I may have overcomplicated it though,
    I'm not sure how else I would do it in this simple of code.
    Lance Douglas, SortInteger, September 30th, 2016
 */
public class SortInteger {
    public static void main(String[] args) {
        System.out.println("Enter three whole numbers:");
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int num3 = scn.nextInt();

        int oneMinTwo = Math.min(num1, num2); //Uses Math to obtain the min of the two ints.
        int twoMinThree = Math.min(num2, num3);
        int oneMaxTwo = Math.max(num1, num2); //Uses Math to obtain the max of the two ints.
        int twoMaxThree = Math.max(num2, num3);

        int lowest = Math.min(oneMinTwo, twoMinThree); //Uses Math to obtain min of mins.
        int middlest = Math.min(oneMaxTwo, twoMaxThree); //Uses Math to obtain min of maxs.
        int largest = Math.max(oneMaxTwo, twoMaxThree); //Uses Math to obtain min of all three.
        System.out.println(lowest + " " + middlest + " " + largest);
        nextTry();
    }
    public static void nextTry() {
        System.out.println("Enter three whole numbers:");
        Scanner scn = new Scanner(System.in);
        int nums[] = new int[3];
        for (int index = 0; index < 3; index++) {
            nums[index] = scn.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}