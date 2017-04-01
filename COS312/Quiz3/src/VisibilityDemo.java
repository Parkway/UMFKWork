import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/*****************************************
 * This applet simply demonstrates the
 * setVisibility function in Applets and
 * GUIs in Java. Originally, this sets a
 * JLabel to invisible until a corresponding
 * button is clicked. I added a very simple
 * function to set the button to invisible
 * after it is clicked.
 * Created by Lance Douglas on 3/17/2017
 *****************************************/

public class VisibilityDemo extends JApplet { //means I can use applet.
    private JLabel response;
    private Container contentPane; //For the GUI

    public void init() { //Have to name applet method init
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);

        //Create button:
        JButton aButton  = new JButton("Push me!");
        aButton.addActionListener((ActionEvent AE) -> { //I did this because aButton is only in this method, not global, so I have to turn the actionListener into a specific one.
            contentPane.setBackground(Color.PINK);
            aButton.setVisible(false);//Hides the button.
            response.setVisible(true);//Show label
        });

        //Create label:
        response = new JLabel("Thanks. That felt good!");
        ImageIcon smileyFaceIcon = new ImageIcon("smiley.gif");
        response.setIcon(smileyFaceIcon);
        response.setVisible(false);//Invisible until button is clicked

        //Add button:
        contentPane.setLayout(new FlowLayout( ));
        contentPane.add(aButton);

        //Add label
        contentPane.add(response);
    }
}