import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame
{
    JPanel frame = new JPanel();

    String[] author = {"Select Choice","Nelson Mandela","Shawn Ashmore","John Richardson","Ben Franklin","Lance Douglas"};
    String[] quotes = {"Quote Goes Here","Education is the most powerful weapon which you can use to change the world.",
            "Style is a reflection of your attitude and your personality.","They can be silly, they can be political, whatever.",
            "An investment in knowledge pays the best interest.","I just spent way too much money. Why did I do that?"};

    JLabel lbl = new JLabel();

    JComboBox Spinner = new JComboBox(author);

    private Window() {
        super("Quotes");
        setSize(600, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(frame);
        setVisible(true);
        Color customColor = new Color(2,84,82);
        setBackground(customColor);

        Spinner.setSelectedIndex(0);
        frame.add(Spinner, BorderLayout.NORTH);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.add(lbl, BorderLayout.SOUTH);

        lbl.setHorizontalTextPosition(JLabel.CENTER);
        lbl.setVerticalTextPosition(JLabel.CENTER);


        Spinner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JComboBox comboBox = (JComboBox) event.getSource();

                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals(author[0]))
                    lbl.setText(quotes[0]);
                else if(selected.toString().equals(author[1]))
                    lbl.setText(quotes[1]);
                else if(selected.toString().equals(author[2]))
                    lbl.setText(quotes[2]);
                else if(selected.toString().equals(author[3]))
                    lbl.setText(quotes[3]);
                else if(selected.toString().equals(author[4]))
                    lbl.setText(quotes[4]);
                else if(selected.toString().equals(author[5]))
                    lbl.setText(quotes[5]);
                else
                    lbl.setText("You shouldn't be seeing this error message. If you are, contact the dev.");

            }
        });

        setVisible(true);
    }

    public static void main (String[] args) {
        Window gui = new Window();
    }
}


   /* String nMandela = "Education is the most powerful weapon which you can use to change the world." +
            "\n                 - Nelson Mandela\n"; //Also, I know how to use \" to put quotation marks in the text, but the - Name format doesn't require any.

    Thread.sleep(1500); //Delays code execution for effect. No getting spammed with quotes.

    String jRichardson = "They can be silly, they can be political, whatever." +
            "\n                 - John Richardson\n";

    Thread.sleep(1500);

    String bFranklin = "An investment in knowledge pays the best interest." +
            "\n                 - Benjamin Franklin\n";

    Thread.sleep(1500);

    String sAshmore = "Style is a reflection of your attitude and your personality." +
            "\n                 - Shawn Ashmore\n";

    Thread.sleep(1500);

    String lDouglas = "I just spent way too much money. Why did I do that?" +
            "\n                 - Lance Douglas (Hey I know him!)";

    Thread.sleep(1500);*/




