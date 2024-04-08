package BTTH3_21521842.A;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementFrame extends JFrame {
    private List<Statement> students = new ArrayList<>();
    private JTable studentTable;
    private JTextField idField, nameField, dateField;
    private JButton addButton, saveButton, editButton, deleteButton, openFileButton, saveFileButton, cancelButton,
            exitButton;
    protected Student[] student;

    public StudentManagementFrame() {
        students = new ArrayList<>();
        setTitle("Quản lý sinh viên");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Thông tin sinh viên panel
        JPanel studentInfoPanel = new JPanel(new GridLayout(4, 3));
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin sinh viên"));
        studentInfoPanel.add(new JLabel("Mã số sinh viên:"));
        idField = new JTextField();
        studentInfoPanel.add(idField);
        studentInfoPanel.add(new JLabel());
        studentInfoPanel.add(new JLabel("Tên sinh viên:"));
        nameField = new JTextField();
        studentInfoPanel.add(nameField);
        studentInfoPanel.add(new JLabel());
        studentInfoPanel.add(new JLabel("Ngày sinh: "));
        dateField = new JTextField();
        studentInfoPanel.add(dateField);
        studentInfoPanel.add(new JLabel("(dd/mm/yy)", SwingConstants.CENTER));
        // Buttons for Thông tin sinh viên
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        studentInfoPanel.add(new JLabel());

        addButton = new JButton("Thêm");
        buttonsPanel.add(addButton);
        saveButton = new JButton("Lưu");
        buttonsPanel.add(saveButton);
        editButton = new JButton("Sửa");
        buttonsPanel.add(editButton);
        deleteButton = new JButton("Xóa");
        buttonsPanel.add(deleteButton);

        studentInfoPanel.add(buttonsPanel, BorderLayout.EAST);
        studentInfoPanel.add(new JLabel());

        // Danh sách sinh viên table
        JPanel studentListPanel = new JPanel(new BorderLayout());
        studentListPanel.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));

        String[] columnNames = { "Mã số sinh viên", "Tên sinh viên", "Ngày sinh" };
        studentTable = new JTable(new Object[][] {}, columnNames);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        studentListPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom buttons
        JPanel bottomButtonsPanel = new JPanel(new FlowLayout());
        openFileButton = new JButton("Mở File");
        bottomButtonsPanel.add(openFileButton);
        saveFileButton = new JButton("Lưu File");
        bottomButtonsPanel.add(saveFileButton);
        cancelButton = new JButton("Hủy");
        bottomButtonsPanel.add(cancelButton);
        exitButton = new JButton("Thoát");
        bottomButtonsPanel.add(exitButton);

        // Adding components to the frame
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.NORTH);
        add(studentListPanel, BorderLayout.CENTER);
        add(bottomButtonsPanel, BorderLayout.SOUTH);

        // Adding action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add student logic
                String id = idField.getText();
                String name = nameField.getText();
                String text = dateField.getText();
                Object[] date = new Object[] { text };

                // Check if name field is empty
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in the name field");
                    return;
                }
                // Create a new student object
                final Statement student = new Statement(id, name, date);

                // Add the student to the list
                students.add(student);

                // Update the table
                DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                model.addRow(new Object[] { id, name, date });

                // Clear the input fields
                idField.setText("");
                nameField.setText("");
                dateField.setText("");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save student logic
                try {
                    FileWriter writer = new FileWriter("./student.txt");
                    for (Student student : student) {
                        writer.write(student.getId() + "," + student.getName() + "," + student.getDate() + "\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Students saved successfully");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving students");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Edit student logic
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete student logic
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a student to delete");
                    return;
                }

                // Get the student object from the selected row
                Statement student = students.get(selectedRow);

                // Remove the student from the list
                students.remove(student);

                // Remove the row from the table
                DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                model.removeRow(selectedRow);
            }
        });

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open file logic
                try {
                    FileReader reader = new FileReader("./student.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        Object[] parts = line.split(",");
                        String id = (String) parts[0];
                        String name = (String) parts[1];
                        Object[] date = (Object[]) parts[2];
                        students.add(new Statement(id, name, date));
                    }
                    reader.close();
                    JOptionPane.showMessageDialog(null, "Students loaded successfully");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error loading students");
                }
            }
        });

        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save file logic
                try {
                    FileWriter writer = new FileWriter("./student.txt");
                    for (Student student : student) {
                        writer.write(student.getId() + "," + student.getName() + "," + student.getDate() + "\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Students saved successfully");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving students");
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cancel logic
                JOptionPane.showMessageDialog(null, "Operation cancelled");
                idField.setText("");
                nameField.setText("");
                dateField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit logic
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementFrame frame = new StudentManagementFrame();
            frame.setVisible(true);
        });
    }
}
