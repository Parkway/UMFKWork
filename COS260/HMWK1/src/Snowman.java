import java.awt.*;
import java.applet.Applet;
/* This program makes a snowman!
   Lance Douglas, Snowman, September 9, 2016
 */

public class Snowman  extends Applet {

    public void paint (Graphics g)
    {
        g.drawOval(60, 60, 200, 200);
        g.drawOval(90, 120, 45, 45);
        g.drawOval(190, 120, 45, 45);
        g.drawLine(165, 125, 165, 175);
        g.drawArc(120, 130, 95, 95, 0, -180);
        g.drawOval(40, 260, 250, 250);
        g.drawOval(25, 510, 300, 300); //There has *seriously* got to be a better way of doing this than trial and error. Add a line!
    }
}    // End class Snowman