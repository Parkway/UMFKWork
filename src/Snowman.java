
import java.awt.*;
import java.applet.Applet;

public class Snowman  extends Applet {

    public void paint (Graphics g)
    {
        g.drawOval(60, 60, 200, 200);
        g.drawOval(90, 120, 45, 45);
        g.drawOval(190, 120, 45, 45);
        g.drawLine(165, 125, 165, 175);
        g.drawArc(110, 130, 95, 95, 0, -180);

    }
}    // End class SnowMan