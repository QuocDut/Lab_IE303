package BTTH3_21521842;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// StudentDetail class
public class StudentDetail extends JFrame {
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel genderLabel;
    private JLabel courseLabel;
    private JLabel facilitiesLabel;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextArea addressTextArea;
    private JComboBox<String> courseComboBox;
    private JButton okButton;
    private JButton closeButton;

    public StudentDetail() {
        initComponents();
    }

    // actionPerformed method
    public void actionPerformed(Action e) {
        System.exit(0);
    }

    // add ActionListener
    public void addOkButtonActionListener(ActionListener actionListener) {
        okButton.addActionListener((java.awt.event.ActionListener) actionListener);
    }

    private void initComponents() {
        nameLabel = new JLabel("Name:");
        ageLabel = new JLabel("Age:");
        addressLabel = new JLabel("Address:");
        genderLabel = new JLabel("Gender:");
        courseLabel = new JLabel("Course:");
        facilitiesLabel = new JLabel("Facilities:");
        nameTextField = new JTextField();
        ageTextField = new JTextField();
        addressTextArea = new JTextArea();

        JPanel genderPanel = new JPanel();
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();

        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        courseComboBox = new JComboBox<>(new String[] { "Web Application Developer", "Database Administrator",
                "Network Administrator", "Windows Application Developer" });
        JPanel facilitiesPanel = new JPanel();
        JCheckBox ComputerDromeCheckBox = new JCheckBox("Computer Drome");
        JCheckBox libraryCheckBox = new JCheckBox("Library");

        facilitiesPanel.add(ComputerDromeCheckBox);
        facilitiesPanel.add(libraryCheckBox);
        okButton = new JButton("OK");
        closeButton = new JButton("Close");

        // Set the layout manager
        setLayout(new GridLayout(7, 2));

        // Add components to the frame
        add(nameLabel);
        add(nameTextField);
        add(ageLabel);
        add(ageTextField);
        add(addressLabel);
        add(addressTextArea);
        add(genderLabel);
        add(genderPanel);
        add(courseLabel);
        add(courseComboBox);
        add(facilitiesLabel);
        add(facilitiesPanel);
        add(okButton);
        add(closeButton);

        // Add action listener to the OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate input and display error message if invalid
                if (nameTextField.getText().isEmpty() || ageTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(StudentDetail.this, "Please enter name and age.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener to the Close button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the frame
                dispose();
            }
        });

        // Set frame properties
        setTitle("Student Detail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentDetail();
            }
        });
    }
}