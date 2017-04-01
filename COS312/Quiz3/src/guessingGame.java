import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*****************************************
 * This class is nothing more than a small
 * guessing game, in which the users needs
 * to determine whether a number is odd or
 * even. I had some fun coming up with
 * godawful methods of not trying harder
 * than I want to right now.
 * Created by Lance Douglas on 3/17/2017
 *****************************************/
public class guessingGame extends JApplet {

    //Adding instance variables.
    public JLabel guess,result;
    private JButton even,odd;
    private Container contentPane;

    public void init()  {
        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);

        //Random long.
        long secretNumber = java.util.Calendar.getInstance().getTimeInMillis() % 100;
        //int secretNumber = (int)(Math.random()*100); would work just the same, why don't we use that?

        guess = new JLabel("Guess whether or not a secret number is odd or even. Good luck!");
        /* I'm gonna level with you; I only added the good luck piece because the Even button
         * was appearing next to the JLabel, while the Odd was underneath, and that looked gross,
         * so I just came up with more fluff to use up the rest of the line space. */
        result = new JLabel(); //No text so it's effectively invisible.

        //Adds and labels the button, and then handles actionEvents.
        even = new JButton("Even");
        even.setFocusable(false); //Removes automatic highlighting of button.
        even.addActionListener((ActionEvent AE) -> {
            if (secretNumber % 2 == 0) {
                result.setText("You selected even, which is correct! The secret number was " + secretNumber + ".");
                /* Turns the buttons invisible, So the user can't change the
                 * result like a jerk. I'm too lazy to implement anything
                 * other than a poorly thought out hack.*/
                even.setVisible(false);
                odd.setVisible(false);
            } else {
                result.setText("You selected even, which is wrong! The secret number was " + secretNumber + ".");
                even.setVisible(false);
                odd.setVisible(false);
            }
        });
        odd = new JButton("Odd");
        odd.setFocusable(false);
        odd.addActionListener((ActionEvent AE) -> {
            if (secretNumber % 2 == 0) {
                result.setText("You selected odd, which is wrong! The secret number was " + secretNumber + ".");
                even.setVisible(false);
                odd.setVisible(false);
            } else {
                result.setText("You selected odd, which is correct! The secret number was " + secretNumber + ".");
                even.setVisible(false);
                odd.setVisible(false);
            }
        });
        //Adding the layout and JThings to the contentPane.
        contentPane.setLayout(new FlowLayout());
        contentPane.add(guess);
        contentPane.add(result);
        contentPane.add(even);
        contentPane.add(odd);

    }
}
