import java.util.Collections;

public class Quotes {
    public static void main(String[] args) throws InterruptedException {


        String quotesList[] = {"Education is the most powerful weapon which you can use to change the world.\n\t\t- Nelson Mandela",
                "They can be silly, they can be political, whatever.\n\t\t- John Richardson",
                "An investment in knowledge pays the best interest.\n\t\t- Ben Franklin",
                "Style is a reflection of your attitude and your personality.\n\t\t- Shawn Ashmore",
                "I just spent way too much money. Why did I do that?\n\t\t- Lance Douglas"};

        int quoteNum = quotesList.length;
        while (quoteNum > 0) {
            int quoteChoice = (int) (Math.random() * quoteNum);
            print(quotesList[quoteChoice]);
            quoteNum--;
            Thread.sleep(1500);
        }
    }
    private static void print(String s) {
        System.out.println(s);
    }
}

/*print("Education is the most powerful weapon which you can use to change the world." +
            "\n                 - Nelson Mandela\n"); //Also, I know how to use \" to put quotation marks in the text, but the - Name format doesn't require any.

        Thread.sleep(1500); //Delays code execution for effect. No getting spammed with quotes.

        print("They can be silly, they can be political, whatever." +
            "\n                 - John Richardson\n");

        Thread.sleep(1500);

        print("They can be silly, they can be political, whatever." +
            "\n                 - Benjamin Franklin\n");

        Thread.sleep(1500);

        print("Style is a reflection of your attitude and your personality." +
            "\n                 - Shawn Ashmore\n");

        Thread.sleep(1500);

        print("I just spent way too much money. Why did I do that?" +
                "\n                 - Lance Douglas (Hey I know him!)");

        Thread.sleep(1500);*/





