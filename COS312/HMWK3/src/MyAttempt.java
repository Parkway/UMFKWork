import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/*****************************************
 * Created by Lance Douglas on 3/12/2017
 *****************************************/
public class MyAttempt {

    private JLabel ORIlbl,DESlbl,DOWlbl,DEPlbl,ARRlbl,PRIlbl;
    private JTextField ORItxt,DEStxt,DOWtxt,DEPtxt,ARRtxt,PRItxt;
    private JButton Insert,Update,Delete;
    private ResultSet rs;

    public static void main(String[] args) {
        MyAttempt obj = new MyAttempt();
        obj.firstPanel();
    }
    public void firstPanel() {
        JFrame JF = new JFrame("Database Tool");
        Container C = JF.getContentPane();
        C.setLayout(new BoxLayout(C,BoxLayout.Y_AXIS));


        Insert = new JButton("Insert");
        Insert.addActionListener((ActionEvent AE) -> {
            JF.dispose();
            insertData();
        });
        Update = new JButton("Update");
        Update.addActionListener((ActionEvent AE) -> {
            JF.dispose();
            updateData();
        });
        Delete = new JButton("Delete");
        Delete.addActionListener((ActionEvent AE) -> {
            JF.dispose();
            deleteData();
        });

        JPanel btnPanel = new JPanel(new GridLayout(3,1));
        btnPanel.add(Insert);
        btnPanel.add(Update);
        btnPanel.add(Delete);


        JF.setVisible(true);
        JF.setLocationRelativeTo(null);
        JF.add(btnPanel);
        JF.setSize(350,250);
    }
    private void insertData() {
        JFrame JF = new JFrame("Insert Data");
        Container C = JF.getContentPane();
        C.setLayout(new BoxLayout(C,BoxLayout.Y_AXIS));


        //Labels everything in the GUI
        ORIlbl = new JLabel(" Origin:");
        DESlbl = new JLabel(" Destination:");
        DOWlbl = new JLabel(" Day of Week:");
        DEPlbl = new JLabel(" Departure:");
        ARRlbl = new JLabel(" Arrival:");
        PRIlbl = new JLabel(" Price:");

        //Adds text fields
        ORItxt = new JTextField("",15);//To adjust width
        DEStxt = new JTextField();
        DOWtxt = new JTextField();
        DEPtxt = new JTextField();
        ARRtxt = new JTextField();
        PRItxt = new JTextField();

        JPanel pnlInput = new JPanel(new GridLayout(6,2));
        pnlInput.setBackground(Color.WHITE); //Set input panel color to white.

        //Adds elements to pnlInput
        pnlInput.add(ORIlbl); pnlInput.add(ORItxt);
        pnlInput.add(DESlbl); pnlInput.add(DEStxt);
        pnlInput.add(DOWlbl); pnlInput.add(DOWtxt);
        pnlInput.add(DEPlbl); pnlInput.add(DEPtxt);
        pnlInput.add(ARRlbl); pnlInput.add(ARRtxt);
        pnlInput.add(PRIlbl); pnlInput.add(PRItxt);

        Insert = new JButton("Insert");
        Insert.addActionListener((ActionEvent AE) -> {
            Connection con;
            try {
                if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Flight Information is empty. All information must be completed.");
                    //If they don't at the very least enter flight origin and destination info, make them enter it all.
                } else {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");

                    String SQLString= "Insert Into  Flights (Origin,Destination,DayOfWeek,Departure,Arrival,Price)" +
                            "Values ('" + ORItxt.getText() + "','" + DEStxt.getText()
                            + "','" + DOWtxt.getText() + "','" + DEPtxt.getText() + "','"
                            + ARRtxt.getText() + "','" + PRItxt.getText() + "')";
                    Statement statement = con.createStatement();
                    statement.execute(SQLString);
                    createMessageBox("Flight " + ORItxt.getText() + " to " + DEStxt.getText() + " inserted successfully");
                    clearControls();
                }
            }
            catch(Exception e) {
                createMessageBox(e.getMessage());
            }  
        });

        JPanel pnlButton = new JPanel(new GridLayout(1,4));//Organizes gridlayout
        //Adds buttons to button panel
        pnlButton.add(Insert);


        JPanel pnlAns = new JPanel(new GridLayout(3,2));
        pnlAns.setBackground(Color.WHITE);

        JF.add(pnlInput);
        JF.add(pnlButton);
        JF.add(pnlAns);

        JF.pack();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);

    }
    private void updateData() {
        JFrame JF = new JFrame("Update Data");
        Container C = JF.getContentPane();
        C.setLayout(new BoxLayout(C,BoxLayout.Y_AXIS));


        //Labels everything in the GUI
        ORIlbl = new JLabel(" Origin:");
        DESlbl = new JLabel(" Destination:");
        DOWlbl = new JLabel(" Day of Week:");
        DEPlbl = new JLabel(" Departure:");
        ARRlbl = new JLabel(" Arrival:");
        PRIlbl = new JLabel(" Price:");

        //Adds text fields
        ORItxt = new JTextField("",15);//To adjust width
        DEStxt = new JTextField();
        DOWtxt = new JTextField();
        DEPtxt = new JTextField();
        ARRtxt = new JTextField();
        PRItxt = new JTextField();

        JPanel pnlInput = new JPanel(new GridLayout(6,2));
        pnlInput.setBackground(Color.WHITE); //Set input panel color to white.

        //Adds elements to pnlInput
        pnlInput.add(ORIlbl); pnlInput.add(ORItxt);
        pnlInput.add(DESlbl); pnlInput.add(DEStxt);
        pnlInput.add(DOWlbl); pnlInput.add(DOWtxt);
        pnlInput.add(DEPlbl); pnlInput.add(DEPtxt);
        pnlInput.add(ARRlbl); pnlInput.add(ARRtxt);
        pnlInput.add(PRIlbl); pnlInput.add(PRItxt);

        Update = new JButton("Update");
        Update.addActionListener((ActionEvent AE) -> {
            Connection con;
            try {
                if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Flight Information is empty. All information must be completed.");
                    //If they don't at the very least enter flight origin and destination info, make them enter it all.
                } else {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                    String sql = "UPDATE Flights " +
                            "Set Departure='" + DEPtxt.getText() +
                            "',DayOfWeek='" + DOWtxt.getText() +
                            "',Arrival='" + ARRtxt.getText() +
                            "',Price='" + PRItxt.getText() +

                            "'Where Origin='" + ORItxt.getText() +
                            "'and Destination='" + DEStxt.getText() + "'";

                    Statement statement = con.createStatement();
                    statement.execute(sql);
                    createMessageBox("Flight " + ORItxt.getText() + " to " + DEStxt.getText() + " updated successfully");
                    clearControls();
                }
            }
            catch(Exception e) {
                createMessageBox(e.getMessage());
            }
        });

        JPanel pnlButton = new JPanel(new GridLayout(1,4));//Organizes gridlayout
        //Adds buttons to button panel
        pnlButton.add(Insert);


        JPanel pnlAns = new JPanel(new GridLayout(3,2));
        pnlAns.setBackground(Color.WHITE);

        JF.add(pnlInput);
        JF.add(pnlButton);
        JF.add(pnlAns);

        JF.pack();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
    }
    private void deleteData() {
        JFrame JF = new JFrame("Update Data");
        Container C = JF.getContentPane();
        C.setLayout(new BoxLayout(C,BoxLayout.Y_AXIS));


        //Labels everything in the GUI
        ORIlbl = new JLabel(" Origin:");
        DESlbl = new JLabel(" Destination:");
        DOWlbl = new JLabel(" Day of Week:");
        DEPlbl = new JLabel(" Departure:");
        ARRlbl = new JLabel(" Arrival:");
        PRIlbl = new JLabel(" Price:");

        //Adds text fields
        ORItxt = new JTextField("",15);//To adjust width
        DEStxt = new JTextField();
        DOWtxt = new JTextField();
        DEPtxt = new JTextField();
        ARRtxt = new JTextField();
        PRItxt = new JTextField();

        JPanel pnlInput = new JPanel(new GridLayout(6,2));
        pnlInput.setBackground(Color.WHITE); //Set input panel color to white.

        //Adds elements to pnlInput
        pnlInput.add(ORIlbl); pnlInput.add(ORItxt);
        pnlInput.add(DESlbl); pnlInput.add(DEStxt);
        pnlInput.add(DOWlbl); pnlInput.add(DOWtxt);
        pnlInput.add(DEPlbl); pnlInput.add(DEPtxt);
        pnlInput.add(ARRlbl); pnlInput.add(ARRtxt);
        pnlInput.add(PRIlbl); pnlInput.add(PRItxt);

        Delete = new JButton("Delete");
        Delete.addActionListener((ActionEvent AE) -> {
            Connection con;
            try {
                if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Flight Information is empty. All information must be completed.");
                } else {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                    String sql = "Delete from Flights " +
                            " Where Origin='" + ORItxt.getText() +
                            "'and Destination='" + DEStxt.getText() +
                            "'and DayOfWeek='" + DOWtxt.getText() +
                            "'and Departure='" + DEPtxt.getText() +
                            "'and Arrival='" + ARRtxt.getText() +
                            "'and Price='" + PRItxt.getText() + "'";


                    Statement statement = con.createStatement();
                    statement.execute(sql);
                    createMessageBox("Record of flight " + ORItxt.getText() + " to " + DEStxt.getText() + " deleted successfully");
                    clearControls();
                }
            }
            catch(Exception e) {
                createMessageBox(e.getMessage());
            }
        });
        JPanel pnlButton = new JPanel(new GridLayout(1,4));//Organizes gridlayout
        //Adds buttons to button panel
        pnlButton.add(Insert);


        JPanel pnlAns = new JPanel(new GridLayout(3,2));
        pnlAns.setBackground(Color.WHITE);

        JF.add(pnlInput);
        JF.add(pnlButton);
        JF.add(pnlAns);

        JF.pack();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
    }
    private void createMessageBox(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    private void clearControls() {
        ORItxt.setText("");
        DEStxt.setText("");
        DOWtxt.setText("");
        DEPtxt.setText("");
        ARRtxt.setText("");
        PRItxt.setText("");
    }
}
