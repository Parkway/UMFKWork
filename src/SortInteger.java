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
