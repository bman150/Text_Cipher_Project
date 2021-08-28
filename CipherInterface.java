// Creates a UI for the cipher program.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CipherInterface extends JPanel {
    private static JTextField textField;
    private static JComboBox<String> cipherBox;
    private static JTextField encryptField;
    private static final String[] CIPHERLIST = {"Caesar", "Hill", "Monoalphabetic"};

    private CipherInterface() {
        setLayout(new GridLayout(3, 1)); // a 3x1 grid layout for the components

        // textPanel component and its sub-components
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Enter Text");
        textField = new JTextField(15);
        textPanel.add(textLabel);
        textPanel.add(textField);
        add(textPanel);

        // cipherPanel component and its sub-components
        JPanel cipherPanel = new JPanel();
        JLabel cipherLabel = new JLabel("Select Cipher");
        cipherBox = new JComboBox<>(CIPHERLIST);
        cipherBox.setBounds(80, 50, 140, 20);
        JButton cipherButton = new JButton("Encrypt");
        cipherButton.addActionListener(new btnListener());
        cipherPanel.add(cipherLabel);
        cipherPanel.add(cipherBox);
        cipherPanel.add(cipherButton);
        add(cipherPanel);

        // encryptedPanel component and its sub-components
        JPanel encryptedPanel = new JPanel();
        JLabel encryptedLabel = new JLabel("Encrypted Text");
        encryptField = new JTextField(25);
        encryptedPanel.add(encryptedLabel);
        encryptedPanel.add(encryptField);
        add(encryptedPanel);
    }

    public static void main (String [] args) {
        //createUI();
        JFrame frame = new JFrame("UI Test");
        frame.add(new CipherInterface());
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static class btnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String key = "GYBNQKURP"; // encryption key for hill cipher
            StringBuffer resultBuffer;
            String resultString;
            String textContent = textField.getText();
            String cipherContent = cipherBox.getSelectedItem().toString();
            if (cipherContent == "Caesar") {
                resultBuffer = Caesar.caesarCipher(textContent);
                resultString = resultBuffer.toString();
                encryptField.setText(resultString);
            }
            else if (cipherContent == "Hill") {
                resultString = Hill.hillCipher(textContent, key);
                encryptField.setText(resultString);
            }
            else if (cipherContent == "Monoalphabetic") {
                resultString = Monoalphabetic.monoAlphaCipher(textContent);
                encryptField.setText(resultString);
            }
            else {
                encryptField.setText("Not valid");
            }
        }
    }
}