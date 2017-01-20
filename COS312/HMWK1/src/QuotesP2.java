import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //Imported a bunch of JFrame stuff. Not totally sure.

class Window extends JFrame {
    JPanel frame = new JPanel();

    String[] author = {"Select Choice","Nelson Mandela","Shawn Ashmore","John Richardson","Ben Franklin","Lance Douglas"};
    String[] quotes = {"","Education is the most powerful weapon which you can use to change the world.",
            "Style is a reflection of your attitude and your personality.","They can be silly, they can be political, whatever.",
            "An investment in knowledge pays the best interest.","I just spent way too much money. Why did I do that?"};

    JTextArea lbl = new JTextArea(30,30);

    JComboBox Spinner = new JComboBox(author);

    private Window() {
        super("Quotes");
        setSize(400, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(frame);
        setVisible(true);
        Color customColor = new Color(2,84,82);
        setBackground(customColor);

        Spinner.setSelectedIndex(0);
        frame.add(Spinner, BorderLayout.NORTH);
        frame.add(lbl, BorderLayout.SOUTH);
        frame.add(lbl, BorderLayout.CENTER);

        lbl.setWrapStyleWord(true);
        lbl.setLineWrap(true);
        lbl.setOpaque(false);
        lbl.setEditable(false);
        lbl.setFocusable(false);
        lbl.setBackground(UIManager.getColor("Label.background"));
        lbl.setFont(UIManager.getFont("Label.font"));
        lbl.setBorder(UIManager.getBorder("Label.border"));
        lbl.setFont(new Font("Ubuntu", Font.PLAIN, 16));

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