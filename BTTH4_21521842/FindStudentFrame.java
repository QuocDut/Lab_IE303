import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindStudentFrame extends JFrame{
    private DataAccessObject dao;
    private ArrayList<Student> studentArrayList;
    private JTable tblStudentList;
    private JPanel mainPanel;
    private JTextField tfStudentId;
    private JTextField tfStudentName;
    private JCheckBox cbStudentId;
    private JCheckBox cbStudentName;
    private JButton btnSubmit;
    private JButton btnCancel;

    FindStudentFrame(DataAccessObject dao, ArrayList<Student> studentArrayList, JTable tblStudentList){
        this.dao = dao;
        this.studentArrayList = studentArrayList;
        this.tblStudentList = tblStudentList;

        setContentPane(mainPanel);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setSize(400, 300);
        setTitle("Tìm kiếm sinh viên");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(false);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mssv = tfStudentId.getText();
                String fullName = tfStudentName.getText();

                boolean isMssvChecked = cbStudentId.isSelected();
                boolean isNameChecked = cbStudentName.isSelected();

                if(!isMssvChecked && !isNameChecked) {
                    JOptionPane.showMessageDialog(null, "Please choose some fields!");
                    return;
                }

                if(isMssvChecked && isEmpty(mssv)) {
                    JOptionPane.showMessageDialog(null, "Please fill all chosen fields!");
                    return;
                }

                if(isNameChecked && isEmpty(fullName)) {
                    JOptionPane.showMessageDialog(null, "Please fill all chosen fields!");
                    return;
                }

                try {
                    findStudent(isMssvChecked, isNameChecked, mssv, fullName);
                    renderDataIntoTable();
                    resetField();
                    JOptionPane.showMessageDialog(null, "Find students successfully");
                    dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private boolean isEmpty(String... params) {
        for(String param : params){
            if(param.isEmpty()) return true;
        }
        return false;
    }

    private void findStudent(boolean isMssvChecked, boolean isNameChecked, String mssv, String fullName) throws SQLException {
        DefaultTableModel model  = (DefaultTableModel) tblStudentList.getModel();
        model.setRowCount(0);
        studentArrayList.clear();
        String queryStatement = "SELECT * FROM SINHVIEN WHERE ";

        if(isMssvChecked) queryStatement += String.format("MASV LIKE \"%%%s%%\" ", mssv);
        if(isNameChecked) {
            if(isMssvChecked) {
                queryStatement += String.format("AND HOTEN LIKE \"%%%s%%\"", fullName);
            } else {
                queryStatement += String.format("HOTEN LIKE \"%%%s%%\"", fullName);
            }
        }

        System.out.println(queryStatement);


        ResultSet resultSet = dao.retrieveData(queryStatement);
        while (resultSet.next()) {
            String studentId = resultSet.getString(1);
            String studentName = resultSet.getString(2);
            String dateOfBirth = resultSet.getString(3);
            float math = resultSet.getFloat(4);
            float physics = resultSet.getFloat(5);
            float chemistry = resultSet.getFloat(6);
            studentArrayList.add(new Student(studentId, studentName, dateOfBirth, math, physics, chemistry));
        }
    }

    private void renderDataIntoTable() {
        for (Student student : studentArrayList) {
            addNewRow(student.getMssv(),
                    student.getFullName(),
                    student.getDateOfBirth(),
                    student.getMath(),
                    student.getPhysics(),
                    student.getChemistry());
        }
    }

    private void addNewRow(Object... params) {
        DefaultTableModel model  = (DefaultTableModel) tblStudentList.getModel();
        model.addRow(params);
    }

    private void resetField(){
        tfStudentId.setText("");
        tfStudentName.setText("");
    }
}
