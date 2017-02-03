import javax.swing.JOptionPane;

public class Quiz1{
    public static void main(String[] args){
        String dogString = JOptionPane.showInputDialog("Enter number of dogs:"); //Simple GUI for Input.
        //Saves text entered in OptionPane to $dogString
        int dogCount = Integer.parseInt(dogString); //Why did you do it like this? For a string to integer,
        // you can do Integer.toString. parseInt is for number strings to integers.
        String catString = JOptionPane.showInputDialog("Enter number of cats:");
        int catCount = Integer.parseInt(catString);
        String humanString = JOptionPane.showInputDialog("Enter number of humans:");
        int humanCount = Integer.parseInt(humanString);
        int totalCritterCount = dogCount + catCount + humanCount;
        JOptionPane.showMessageDialog(null,
                "The total number of fruits = " + totalCritterCount);
        System.exit(0);
    }
}