import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;     
import java.awt.event.ActionEvent;     
import java.awt.event.ActionListener;     
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;

//Who imports like this? Just do awt.*, awt.event.*, swing.*, and the last two. That nearly halves the import statements.

public class DigitalClock {
    public static void main(String[]args) {
        ClockLabel dateLable = new ClockLabel("date"); //Creates a new label for the clock, listed as date.
        ClockLabel timeLable = new ClockLabel("time"); //Same but for time.
        ClockLabel dayLable = new ClockLabel("day"); // " " date
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("DigitalClock"); //Name of GUI is Digital Clock
        f.setSize(300,150); // set size of frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure exits program when you close the window. This is unnecessary, as it's a default.
        f.setLayout(new GridLayout(3,1));
        f.add(dateLable); //Adds lables to JFrame
        f.add(timeLable);
        f.add(dayLable);
        f.getContentPane().setBackground(Color.darkGray); //Sets background color of JFrame
        f.setVisible(true); // Invisible GUI = bad GUI.
    }
}
class ClockLabel extends JLabel implements ActionListener {
    String type; //Predefining a variable. Bleh.
    SimpleDateFormat sdf;
    public ClockLabel(String type) {
        this.type=type;
        setForeground(Color.green);

        //Switch statement to set format of clock.
        switch(type){
            case "date": sdf = new SimpleDateFormat("MMMMddyyyy"); //Sets date format
            setFont(new Font("sans-serif",Font.PLAIN,12)); //Sets font use
            setHorizontalAlignment(SwingConstants.LEFT); //Sets spawn location
            break; //Close switch statement
            case"time": sdf = new SimpleDateFormat("hh:mm:ssa"); //Sets time format
            setFont(new Font("sans-serif",Font.PLAIN,40));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;
            case"day": sdf = new SimpleDateFormat("EEEE"); //Sets day format.
            setFont(new Font("sans-serif",Font.PLAIN,16));
            setHorizontalAlignment(SwingConstants.RIGHT);
            break;
            default: sdf = new SimpleDateFormat();
            break;
        }
        Timer t = new Timer(1000,this); //Initializes the clock.
        t.start(); //Starts the clock
    }
    public void actionPerformed (ActionEvent ae) {
        Date d = new Date(); //Sets the date and format.
        setText(sdf.format(d));
    }
}