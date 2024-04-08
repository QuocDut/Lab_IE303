package BTTH3_21521842.A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton okButton;

    public LoginFrame() {
        // Set the layout manager
        setLayout(new GridLayout(3, 2));

        // Create and add the username label
        usernameLabel = new JLabel("Username:");
        add(usernameLabel);

        // Create and add the username text field
        usernameTextField = new JTextField("Enter your username here");
        add(usernameTextField);

        // Create and add the password label
        passwordLabel = new JLabel("Password:");
        add(passwordLabel);

        // Create and add the password text field
        passwordTextField = new JTextField("Enter your password here");
        add(passwordTextField);

        // Create and add the OK button
        okButton = new JButton("OK");
        add(okButton);

        // Set frame properties
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // add ActionListener
    public void addOkButtonActionListener(ActionListener actionListener) {
        okButton.addActionListener((java.awt.event.ActionListener) actionListener);
    }

    public void addWindowListener(WindowListener windowListener) {
        addWindowListener(windowListener);
        System.exit(0);
    }

    // add actionPerformed method
    public void actionPerformed(Action e) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.equals("Adminuser") && password.equals("admin")) {
            // Open the StudentDetail frame
        } else {
            int attemptCount = 0;
            attemptCount++;
            if (attemptCount > 3) {
                JOptionPane.showMessageDialog(this, "Too many failed attempts. Closing the application.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}