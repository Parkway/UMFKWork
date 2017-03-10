import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/*
    This program is designed to insert all data into a database for Lance International Airport.
    It allows users to schedule a flight from wherever to wherever else. 10/10.

    Lance Douglas, dbGUI.java, March 12th, 2017
 */
public class dbGUI implements ActionListener { //Adds actionListener natively.

    //Declare all the variables in advance to make code prettier.

    private JLabel ORIlbl,DESlbl,DOWlbl,DEPlbl,ARRlbl,PRIlbl,
                ORIlblVal,DESlblVal,DOWlblVal,DEPlblVal,ARRlblVal,PRIlblVal;
    private JTextField ORItxt,DEStxt,DOWtxt,DEPtxt,ARRtxt,PRItxt;
    private JButton btnInsert,btnUpdate,btnDelete,btnPrev,btnNext,btnClear;
    private ResultSet rs;

    public static void main(String[] args) {
        dbGUI obj = new dbGUI(); //This allows me to bypass "Can't have non static stuff in static method" nonsense.
        obj.createUI();
    }
    private void createUI()
    {
        JFrame frame = new JFrame("Lance International Airport DB Tool");

        //Layout of Main Window
        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS)); //Organize GUI in BoxLayout

        //Labels everything in the GUI
        ORIlbl = new JLabel("Origin:");
        DESlbl = new JLabel("Destination:");
        DOWlbl = new JLabel("Day of Week:");
        DEPlbl = new JLabel("Departure:");
        ARRlbl = new JLabel("Arrival:");
        PRIlbl = new JLabel("Price:");

        //Adds text fields
        ORItxt = new JTextField("",15);//To adjust width
        DEStxt = new JTextField();
        DOWtxt = new JTextField();
        DEPtxt = new JTextField();
        ARRtxt = new JTextField();
        PRItxt = new JTextField();

        JPanel pnlInput = new JPanel(new GridLayout(6,2));
        pnlInput.setBackground(Color.GREEN); //Set input panel color to green.

        //Adds elements to pnlInput
        pnlInput.add(ORIlbl); pnlInput.add(ORItxt); //Origin
        pnlInput.add(DESlbl); pnlInput.add(DEStxt); //Destination
        pnlInput.add(DOWlbl); pnlInput.add(DOWtxt); //DayOfWeek
        pnlInput.add(DEPlbl); pnlInput.add(DEPtxt); //Departure
        pnlInput.add(ARRlbl); pnlInput.add(ARRtxt); //Arrival
        pnlInput.add(PRIlbl); pnlInput.add(PRItxt); //Price

        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(this);
        btnInsert.setBackground(Color.WHITE);
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(Color.WHITE);
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        btnDelete.setBackground(Color.WHITE);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        btnClear.setBackground(Color.WHITE);

        JPanel pnlButton = new JPanel(new GridLayout(1,4));//Organizes gridlayout
        pnlButton.setBackground(Color.GREEN);

        //Adds buttons to button panel
        pnlButton.add(btnInsert);
        pnlButton.add(btnUpdate);
        pnlButton.add(btnDelete);
        pnlButton.add(btnClear);

        JPanel pnlAns = new JPanel(new GridLayout(3,2));
        pnlAns.setBackground(Color.GREEN);

        //For the lower half of the GUI, lets you view other scheduled flights.
        ORIlbl = new JLabel("Origin:");
        DESlbl = new JLabel("Destination:");
        DOWlbl = new JLabel("Day of Week:");
        DEPlbl = new JLabel("Departure:");
        ARRlbl = new JLabel("Arrival:");
        PRIlbl = new JLabel("Price:");

        ORIlblVal = new JLabel("");
        DESlblVal = new JLabel("");
        DOWlblVal = new JLabel("");
        DEPlblVal = new JLabel("");
        ARRlblVal = new JLabel("");
        PRIlblVal = new JLabel("");

        pnlAns.add(ORIlbl); pnlAns.add(ORIlblVal); //Origin Val
        pnlAns.add(DESlbl); pnlAns.add(DESlblVal); //Destination Val
        pnlAns.add(DOWlbl); pnlAns.add(DOWlblVal); //Day of Week Val
        pnlAns.add(DEPlbl); pnlAns.add(DEPlblVal); //Departure Time Val
        pnlAns.add(ARRlbl); pnlAns.add(ARRlblVal); //Arrival Time Val
        pnlAns.add(PRIlbl); pnlAns.add(PRIlblVal); //Price Val
        
        btnPrev = new JButton(" Previous ");
        btnPrev.setActionCommand("Prev");
        btnPrev.addActionListener(this);
        btnPrev.setBackground(Color.white);

        btnNext = new JButton(" Next ");
        btnNext.setActionCommand("Next");
        btnNext.addActionListener(this);
        btnNext.setBackground(Color.WHITE);

        JPanel pnlNavigate = new JPanel(new GridLayout(1,2));

        pnlNavigate.add(btnPrev);
        pnlNavigate.add(btnNext);

        frame.add(pnlInput);
        frame.add(pnlButton);
        frame.add(pnlAns);
        frame.add(pnlNavigate);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();

        //This program performs each method based on what button is clicked.

        switch (cmd) {
            case "Insert": insertData();
            break;
            case "Update": updateData();
            break;
            case "Delete": deleteData();
            break;
            case "Prev": previous();
            break;
            case "Next": next();
            break;
            case "Clear": clearControls();
            break;
            default:JOptionPane.showMessageDialog(null,"Shit is seriously broken."); //This should literally never happen. BUT, switch without default is horrendous.
        }
    }

    private void insertData() {
        //This method inserts flight data into the database.
        Connection con;
        try {
            if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Flight Information is empty. All information must be completed.");
                //If they don't at the very least enter flight origin and destination info, make them enter it all.
            } else {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");

                String sql = "Insert Into Flights (Origin,Destination,DayOfWeek,Departure,Arrival,Price)" +
                        "Values ('" + ORItxt.getText() + "','" + DEStxt.getText()
                        + "','" + DOWtxt.getText() + "','" + DEPtxt.getText() + "','"
                        + ARRtxt.getText() + "','" + PRItxt.getText() + "')";
                Statement statement = con.createStatement();
                statement.execute(sql);
                createMessageBox("Flight " + ORItxt.getText()+ " to " + DEStxt.getText() + " inserted successfully");
                clearControls();
            }
        }
        catch(Exception e) {
            createMessageBox(e.getMessage());
        }
    }
    private void updateData() {
        Connection con;
        try {
            if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Flight Information is empty. All information must be completed.");
            } else {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                String sql = "Update Flights " +
                        "Set Destination='" + DEStxt.getText() +
                        "',DayOfWeek='" + DOWtxt.getText() +
                        "',Departure='" + DEPtxt.getText() +
                        "',Arrival='" + ARRtxt.getText() +
                        "',Price='" + PRItxt.getText() +

                        "' Where Origin='" + ORItxt.getText() +
                        "' Where Destination='" + DEStxt.getText() + "'";
                Statement statement = con.createStatement();
                statement.execute(sql);
                createMessageBox("Flight " + ORItxt.getText() + " to " + DEStxt.getText() + " updated successfully");
                clearControls();
            }
        }
        catch(Exception e) {
            createMessageBox(e.getMessage());
        }
    }
    private void deleteData() {
        Connection con;
        try {
            if (ORItxt.getText().equals("") && DEStxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Flight Information is empty. All information must be completed.");
            } else {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                String sql = "delete from Flights " +
                        " Where Origin = '" + ORItxt.getText() + "'";
                /*
                        "'Where Destination='" + DEStxt.getText() +
                        "'Where DayOfWeek='" + DOWtxt.getText() +
                        "'Where Departure='" + DEPtxt.getText() +
                        "'Where Arrival='" + ARRtxt.getText() +
                        "'Where Price='" + PRItxt.getText() +
                 */
                Statement statement = con.createStatement();
                statement.execute(sql);
                createMessageBox("Record of flight " + ORItxt.getText() + " to " + DEStxt.getText() + " deleted successfully");
                clearControls();
            }
        }
        catch(Exception e) {
            createMessageBox(e.getMessage());
        }
    }

    private void previous() {
        try {
            if(rs == null) {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                String sql = "Select Origin,Destination,DayOfWeek,Departure,Arrival,Price from Flights";
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = statement.executeQuery(sql);
            }
            if(rs.previous()) {
                populateControls();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void next() {
        try {
            if(rs == null) {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://flights.accdb");
                String sql = "Select Origin,Destination,DayOfWeek,Departure,Arrival,Price from Flights";
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery(sql);
            }
            if(rs.next() && !rs.isAfterLast()) { //After Last was giving invalid cursor state error
                populateControls();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    private void createMessageBox(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    private void clearControls() {
        String empty = "";

        ORItxt.setText(empty);
        DEStxt.setText(empty);
        DOWtxt.setText(empty);
        DEPtxt.setText(empty);
        ARRtxt.setText(empty);
        PRItxt.setText(empty);

        ORIlblVal.setText(empty);
        DESlblVal.setText(empty);
        DOWlblVal.setText(empty);
        DEPlblVal.setText(empty);
        ARRlblVal.setText(empty);
        PRIlblVal.setText(empty);
    }

    private void populateControls() {
        try{
            ORIlblVal.setText(rs.getString("Origin"));
            DESlblVal.setText(rs.getString("Destination"));
            DOWlblVal.setText(rs.getString("DayOfWeek"));
            DEPlblVal.setText(rs.getString("Departure"));
            ARRlblVal.setText(rs.getString("Arrival"));
            PRIlblVal.setText(rs.getString("Price"));

            ORItxt.setText(ORIlblVal.getText());
            DEStxt.setText(DESlblVal.getText());
            DOWtxt.setText(DOWlblVal.getText());
            DEPtxt.setText(DEPlblVal.getText());
            ARRtxt.setText(ARRlblVal.getText());
            PRItxt.setText(PRIlblVal.getText());
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
