import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Everardo Ramirez on 21/05/2017.
 */
public class Ventana extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton abrirButton;
    private JRadioButton encriptarRadioButton;
    private JRadioButton desencriptarRadioButton;
    private JButton guardarButton;
    private ButtonGroup grupo;
    private File archivo;
    private JFileChooser fileChooser;
    private Scanner sc;
    private ArrayList<String> lineas;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private FileNameExtensionFilter filtro;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Viegenere");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
        grupo = new ButtonGroup();
        grupo.add(encriptarRadioButton);
        grupo.add(desencriptarRadioButton);
        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(Ventana.this);
                archivo = fileChooser.getSelectedFile();
                try {
                    lineas = new ArrayList<>();
                    sc = new Scanner(archivo);
                    guardarButton.setEnabled(true);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    while (sc.hasNextLine()) {
                        if (encriptarRadioButton.isSelected()) {
                            lineas.add(Viegenere.codificar(textField1.getText(), sc.nextLine()));
                        } else {
                            lineas.add(Viegenere.decodificar(textField1.getText(), sc.nextLine()));
                        }
                    }
                } catch (Exception e1) {
                } finally {
                    sc.close();
                }
                System.out.println(lineas.get(0));
                fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(Ventana.this);
                archivo = fileChooser.getSelectedFile();
                try {
                    fileWriter = new FileWriter(archivo);
                    printWriter = new PrintWriter(fileWriter);
                    for (String cadena : lineas) {
                        System.out.println(cadena + "hola");
                        printWriter.println(cadena);

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                            printWriter.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

}
