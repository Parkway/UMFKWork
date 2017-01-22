import java.util.*;

public class Quotes {

    public static void main(String[] args) throws InterruptedException {


        String quotesList[] = {"Education is the most powerful weapon which you can use to change the world.\n\t\t- Nelson Mandela",
                "They can be silly, they can be political, whatever.\n\t\t- John Richardson",
                "An investment in knowledge pays the best interest.\n\t\t- Ben Franklin",
                "Style is a reflection of your attitude and your personality.\n\t\t- Shawn Ashmore",
                "I just spent way too much money. Why did I do that?\n\t\t- Lance Douglas"};

        Collections.shuffle(Arrays.asList(quotesList));

        int quoteNum = 4;
        while (quoteNum >= 0) {
            print(quotesList[quoteNum]);
            Thread.sleep(1500);
            quoteNum--;
        }
    }

    private static void print(String s) {

            System.out.println(s);
    }
}

