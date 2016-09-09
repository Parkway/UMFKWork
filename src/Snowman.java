
import java.awt.*;
import java.applet.Applet;

public class Snowman  extends Applet {

    public void paint (Graphics frame)
    {

        final int MID = 150;	// middle of the snowman
        final int TOP = 50;		// top of the snowman

        //  draw three large snowballs to make up snowman
        frame.setColor (Color.white);

        // draw head
        frame.fillOval (MID - 20, TOP, 40, 40);
        // draw middle (upper torso)
        frame.fillOval (MID - 35, TOP + 35, 70, 50);
        // draw base (lower torso)
        frame.fillOval (MID - 50, TOP + 80, 100, 60);


        //  draw eyes
        // draw left eye
        frame.fillOval (MID - 10, TOP + 10, 5, 5);
        frame.setColor (Color.black);
        // draw right eye
        frame.fillOval (MID + 5, TOP + 10, 5, 5);
        frame.setColor (Color.black);

        // draw mouth
        frame.drawArc (MID - 10, TOP + 20, 20, 10, 190, 160);
        frame.setColor (Color.black);

    }
}    // End class SnowMan