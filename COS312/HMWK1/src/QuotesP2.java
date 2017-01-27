/* So, this assignment is to take Quotation Part 1 and turn it into a GUI.
    I was not prepared for the coming hardship.

    Instead of following the PDF, I used a Spinner(JComboBox? Spinner in Android Development JCB/Spinner are interchangeable below.)
    When each author within the JCB is selected, it displays the corresponding quote.
    Also, it is colored and animated. I am really proud of this, can I have extra credit or something?
    The background is a pastel teal with a crisp white Roboto font at the foreground 
                                - Hipster web dev who uses a .io site.
    Anyways, I kinda took some initiative and did this my own way,
    but I am really proud of all of it, and in my opinion I stayed within
    the guidelines to the project.
                                
    Lance Douglas, HMWK1 Quotation Part 2, 1/29/2017
*/
import javax.swing.*; //For GUI
import java.awt.*; //For JFrame
import java.awt.event.ActionEvent; //For buttons.
import java.awt.event.ActionListener; //So button clicking can happen.

class QuotesP2 extends JFrame { //Extends JFrame stuff.
    JPanel frame = new JPanel(); //Creates new JFrame

    String[] author = {"Select Choice","Nelson Mandela","Shawn Ashmore","John Richardson","Ben Franklin","Lance Douglas"}; //Author
    String[] quotes = {"","Education is the most powerful weapon which you can use to change the world.",
            "Style is a reflection of your attitude and your personality.","The quotes can be silly, they can be political, whatever.", //Quote; corresponds to author.
            "An investment in knowledge pays the best interest.","I just spent way too much money. Why did I do that?"};

    JTextArea tA = new JTextArea(30,15); //Set text area.
    /* I used a text area because I couldn't word wrap a generic JLabel.
        I made it non editable, and set the colors to match. Stealth.
     */

    JComboBox Spinner = new JComboBox(author); //Made a spinner / JCB / whatever.
    // Intellij is mad at me though. Unchecked call? I dunno. Works fine.

    private QuotesP2() { //Method for JFrame
        super("Quotes"); //Title of box.
        setSize(400, 250); //Size of box in px.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Destroy box on close.
        add(frame); //Adds frame to box
        setVisible(true); //Can't be invisible, obviously.
        Color teal = new Color(0,150,136); //Almost my favorite color!
        Color white = new Color(255,255,255); //Color.white is just too mainstream.

        //Instructions for Frame.

        frame.add(Spinner, BorderLayout.NORTH); //Puts the JCB at the top of the Frame.
        frame.add(tA, BorderLayout.SOUTH); //Puts the text area to the south of the Spinner.
        frame.add(tA, BorderLayout.CENTER); //Centers the textbox
        frame.setForeground(teal); //I like teal
        frame.setBackground(teal); //For consistency.

        //Instructions for Text Area.
        tA.setWrapStyleWord(true); //See? Can't word wrap a JLabel, and StackOverflow html tags did nothing.
        tA.setLineWrap(true);
        tA.setOpaque(false);
        tA.setEditable(false); //No editing for posterity.
        tA.setFocusable(false); //Can't highlight the text. Why? Practice.
        tA.setBackground(teal); //Background color.
        tA.setForeground(white); //Text color.
        tA.setFont(new Font("Roboto", Font.BOLD, 20)); //Just experimenting with constraints.


        //Instructions for Spinner.

        Spinner.setForeground(white); //Sets text color in JCB to white, for contrast.
        Spinner.setBackground(teal); //Sets the JCB background to teal to match the JFrame.
        Spinner.setFocusable(false); //Oooh I figured this out myself. Can't scroll with keys now. Broke my implementation.
        Spinner.setSelectedIndex(0); //Predetermine where Spinner spawns
        Spinner.addActionListener(new ActionListener() { //IntelliJ is mad at me. Says AL call can be replaced with Lambda expression. Googled it. Even more confused.
            //Anyways, puts AL on Spinner for clicking indexes.
            public void actionPerformed(ActionEvent event) { //Thing to do on Click.

                JComboBox comboBox = (JComboBox) event.getSource(); //I don't know what this does or what it's for.

                Object selected = comboBox.getSelectedItem(); // Or this.
                if(selected.toString().equals(author[0])) //If else to put matching quotes to author name in Spinner box.
                    tA.setText(quotes[0]);
                else if(selected.toString().equals(author[1]))
                    tA.setText(quotes[1]);
                else if(selected.toString().equals(author[2]))
                    tA.setText(quotes[2]); //If Author two, use Quote two. Bad coding practices, but I don't know any better way.
                else if(selected.toString().equals(author[3]))
                    tA.setText(quotes[3]);
                else if(selected.toString().equals(author[4]))
                    tA.setText(quotes[4]);
                else if(selected.toString().equals(author[5]))
                    tA.setText(quotes[5]);
                else
                    tA.setText("You shouldn't be seeing this error message. If you are, I have no idea."); //This shouldn't appear.

            }
        });

        setVisible(true); //Can't have a frackin invisible window.
    }

    public static void main (String[] args) {
        Window gui = new QuotesP2();
    } //This Initializes the GUI
}