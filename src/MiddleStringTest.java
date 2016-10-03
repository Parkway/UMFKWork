public class MiddleStringTest {
    public static void main(String[] args) throws InterruptedException {
        MiddleString MS = new MiddleString();
        System.out.println("This program uses multiple methods to complete the same task.\n" +
                "In each repeat, please enter the specified amount of text.\n" +
                "In turn, the program will lexicographically organize the words.\n");

        Thread.sleep(750);
        System.out.println("This method uses an undefined array to capture the input, and then uses Array.sort to sort the input." +
                "\nEnter three words.");
        MS.threeArray();
        Thread.sleep(750);
        System.out.println("The next method uses a static array of three to accept three words, and then sorts them with Array.sort.");
        MS.forArray();
        Thread.sleep(750);
        System.out.println("KKK");
        MS.nextMethod();
        System.out.println("kkk");
    }
}
