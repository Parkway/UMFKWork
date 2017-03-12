import java.awt.*;
import java.awt.event.*;
import java.sql.*; //So I can do sql statements and whatnot.
import javax.swing.*;
/**
    This program is designed to insert all data into a database for Lance International Airport.
    It allows users to schedule a flight from wherever to wherever else, for
    ridiculously low prices, because I have no idea how much tickets cost! 10/10.

    Lance Douglas, JDBCAttempt.java, March 12th, 2017
 */
public class JDBCAttempt implements ActionListener { //Adds actionListener natively - required for addActionListner(this)

    //Declare all the variables in advance to make code prettier.

    private JLabel ORIlbl,DESlbl,DOWlbl,DEPlbl,ARRlbl,PRIlbl,
                ORIlblVal,DESlblVal,DOWlblVal,DEPlblVal,ARRlblVal,PRIlblVal;
    private JTextField ORItxt,DEStxt,DOWtxt,DEPtxt,ARRtxt,PRItxt;
    private JButton btnInsert,btnUpdate,btnDelete,btnPrev,btnNext,btnClear;
    private ResultSet rs;

    public static void main(String[] args) {
        JDBCAttempt obj = new JDBCAttempt(); //This allows me to bypass "Can't have non static stuff in static method" nonsense.
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
        pnlInput.setBackground(Color.WHITE); //Set input panel color to white.

        //Adds elements to pnlInput
        pnlInput.add(ORIlbl); pnlInput.add(ORItxt); ORIlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//Origin
        pnlInput.add(DESlbl); pnlInput.add(DEStxt); DESlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//Destination
        pnlInput.add(DOWlbl); pnlInput.add(DOWtxt); DOWlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//DayOfWeek
        pnlInput.add(DEPlbl); pnlInput.add(DEPtxt); DEPlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//Departure
        pnlInput.add(ARRlbl); pnlInput.add(ARRtxt); ARRlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//Arrival
        pnlInput.add(PRIlbl); pnlInput.add(PRItxt); PRIlbl.setFont(new Font("Ubuntu",Font.BOLD, 20));//Price

        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(this);
        btnInsert.setBackground(Color.GREEN);
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(Color.BLUE);
        btnUpdate.setForeground(Color.WHITE);;
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
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
        pnlAns.setBackground(Color.WHITE);

        //For the lower half of the GUI, lets you view other scheduled flights.
        ORIlbl = new JLabel("Origin:"); ORIlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));
        DESlbl = new JLabel("Destination:"); DESlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));
        DOWlbl = new JLabel("Day of Week:"); DOWlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));
        DEPlbl = new JLabel("Departure:"); DEPlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));
        ARRlbl = new JLabel("Arrival:"); ARRlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));
        PRIlbl = new JLabel("Price:"); PRIlbl.setFont(new Font("Ubuntu",Font.BOLD, 15));

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
        btnPrev.setFont(new Font("Ubuntu",Font.BOLD,20));
        btnPrev.setActionCommand("Prev");
        btnPrev.addActionListener(this);
        btnPrev.setBackground(Color.white);

        btnNext = new JButton(" Next ");
        btnNext.setFont(new Font("Ubuntu",Font.BOLD,20));
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

        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();

        //This program performs each method based on what button is clicked.

        switch (cmd) {
            case "Insert": insertData();   break;
            case "Update": updateData();   break;
            case "Delete": deleteData();   break;
            case "Prev": previous();       break;
            case "Next": next();           break;
            case "Clear": clearControls(); break;
            default:JOptionPane.showMessageDialog(null,
                    "Shit is seriously broken."); //This should literally never happen. BUT, switch without default is horrendous.
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
