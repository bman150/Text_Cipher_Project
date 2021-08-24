// A UI for the TextCipher program.
import java.awt.*;
import javax.swing.*;

public class CipherInterface {
    public static void main (String [] args) {
        // List of ciphers
        String[] cipherList = {"Caesar", "Hill", "Monoalphabetic"};

        // Create the window frame of the UI.
        JFrame window = new JFrame("Text Cipher");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);

        // Create panel component for text entry/encryption and add sub-components.
        JPanel tp = new JPanel(); // the panel is not visible in output
        JLabel tl = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts up to 10 characters
        JButton tb = new JButton("Encrypt");
        tp.add(tl); // sub-components add using default (flow layout ?) layout
        tp.add(tf);
        tp.add(tb);

        // Create panel component for cipher selection and add sub-components.
        JPanel cp = new JPanel();
        JLabel cl = new JLabel("Select Cipher");
        JComboBox<String> cipherBox = new JComboBox<>(cipherList);
        cipherBox.setBounds(80, 50, 140, 20);
        cp.add(cl);
        cp.add(cipherBox);

        // Create panel component for encryption output and add sub-components.
        JPanel ep = new JPanel();
        JLabel el = new JLabel("Encrypted Text");
        JTextArea ea = new JTextArea();
        ea.setText("some encrypted text"); // NOTE: TEMPORARY LINE UNTIL ABLE TO EDIT VIA TEXT INTPU, ENCRYPT BUTTON, AND CIPHER SELECTION!
        ep.add(el);
        ep.add(ea);

        // Layout for the components that are added to the window frame.
        GridLayout windowLayout = new GridLayout(3,1);
        window.setLayout(windowLayout);

        // Add components to the window frame.
        window.add(tp);
        window.add(cp);
        window.add(ep);
        window.setVisible(true);

    }
}
