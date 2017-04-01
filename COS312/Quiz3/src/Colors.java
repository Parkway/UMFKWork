import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*****************************************
 * This applet is just a box that has
 * three radio buttons that correspond
 * to the colors Red, White, and Blue.
 * On each click of a button, the GUI
 * and the buttons will all change to
 * the matching color.
 * Created by Lance Douglas on 3/17/2017
 *****************************************/

public class Colors extends JApplet {

    //Adding global variables. Could be in init method, doesn't really matter.
    private JRadioButton JRB1,JRB2,JRB3;
    private Container contentPane;
    private ButtonGroup Colors = new ButtonGroup(); //ButtonGroup for RadioButtons so only one clicked at a time.

    public void init() {
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);

        //Setting new buttons.
        JRB1 = new JRadioButton("Red");
        JRB2 = new JRadioButton("White");
        JRB3 = new JRadioButton("Blue");

        //Adding buttons to frame and buttonGroup
        contentPane.add(JRB1); Colors.add(JRB1);
        contentPane.add(JRB2); Colors.add(JRB2);
        contentPane.add(JRB3); Colors.add(JRB3);

        //Setting the default background color of each button to be white - matching the contentPane
        JRB1.setBackground(Color.WHITE);
        JRB2.setBackground(Color.WHITE);
        JRB3.setBackground(Color.WHITE);

        //Adding the actionListener and whatnot for each button.
        JRB1.addActionListener((ActionEvent e) -> {
            //Setting the backgrounds of the buttons to match the other color as well.
            JRB1.setBackground(Color.RED);
            JRB2.setBackground(Color.RED);
            JRB3.setBackground(Color.RED);
            contentPane.setBackground(Color.RED);
        });
        JRB2.addActionListener((ActionEvent e) -> {
            JRB1.setBackground(Color.WHITE);
            JRB2.setBackground(Color.WHITE);
            JRB3.setBackground(Color.WHITE);
            contentPane.setBackground(Color.WHITE);
        });
        JRB3.addActionListener((ActionEvent e) -> {
            JRB1.setBackground(Color.BLUE);
            JRB2.setBackground(Color.BLUE);
            JRB3.setBackground(Color.BLUE);
            contentPane.setBackground(Color.BLUE);
        });

        contentPane.setLayout(new FlowLayout());

    }
}