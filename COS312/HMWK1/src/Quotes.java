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