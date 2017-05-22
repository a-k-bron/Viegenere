import javax.swing.*;

/**
 * Created by Everardo Ramirez on 21/05/2017.
 */
public class Ventana extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {

    }
}
