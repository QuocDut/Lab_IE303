import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private FindStudentFrame findStudentFrame;
    private DatabaseConnector connector;
    private DataAccessObject dao;
    private ArrayList<Student> studentArrayList;
    private JTextField tfStudentId;
    private JTextField tfMath;
    private JTextField tfStudentName;
    private JTextField tfBirthDate;
    private JTextField tfPhysics;
    private JTextField tfChemistry;
    private JPanel mainPanel;
    private JTable tblStudentList;
    private JButton btnConnectDB;
    private JButton btnFindStudent;
    private JButton btnDelete;
    private JButton btnExit;
    private JButton btnAdd;
    private JButton btnEdit;

    MainFrame(DatabaseConnector connector, DataAccessObject dao, ArrayList<Student> studentArrayList)  {
        this.connector = connector;
        this.dao = dao;
        this.studentArrayList = studentArrayList;
        this.findStudentFrame = new FindStudentFrame(dao, studentArrayList, tblStudentList);

        setContentPane(mainPanel);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setSize(640, 400);
        setTitle("Quản lý sinh viên");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        tblStudentListInit();
        setVisible(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);

        tblStudentList.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(tblStudentList.getSelectedRow() >= 0) {
                    tfStudentId.setText((String) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 0));
                    tfStudentName.setText((String) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 1));
                    tfBirthDate.setText((String) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 2));
                    tfMath.setText(String.valueOf((float) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 3)));
                    tfPhysics.setText(String.valueOf((float) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 4)));
                    tfChemistry.setText(String.valueOf((float) tblStudentList.getValueAt(tblStudentList.getSelectedRow(), 5)));
                    btnEdit.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    onWindowClose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onWindowClose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnConnectDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataFromDB();
                renderDataIntoTable();
                showDialog("Load data from database successfully", "Message", "info");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mssv = tfStudentId.getText();
                String fullName = tfStudentName.getText();
                String birthDate = tfBirthDate.getText();
                String math = tfMath.getText();
                String physics = tfPhysics.getText();
                String chemistry = tfChemistry.getText();

                if(isEmpty(mssv, fullName, birthDate, math, physics, chemistry)){
                    showDialog("Please fill all fields", "Warning", "warn");
                    return;
                }
                if(isInvalidDate(birthDate)){
                    showDialog("Date is not valid", "Warning", "warn");
                    return;
                }
                if(isNotUniqueId(mssv)){
                    showDialog(String.format("Id %s is existed!", tfStudentId.getText()), "Warning", "warn");
                    return;
                }

                try {
                    addNewRow(mssv, fullName, birthDate, math, physics, chemistry);
                    addStudent(mssv, fullName, birthDate, math, physics, chemistry);
                    showDialog("Create new student successfully", "Message", "info");
                    resetField();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mssv = tfStudentId.getText();
                String fullName = tfStudentName.getText();
                String birthDate = tfBirthDate.getText();
                String math = tfMath.getText();
                String physics = tfPhysics.getText();
                String chemistry = tfChemistry.getText();

                if(isEmpty(mssv, fullName, birthDate, math, physics, chemistry)){
                    showDialog("Please fill all fields", "Warning", "warn");
                    return;
                }
                if(isInvalidDate(birthDate)){
                    showDialog("Date is not valid", "Warning", "warn");
                    return;
                }

                try {
                    editStudent(mssv, fullName, birthDate, math, physics, chemistry);
                    resetField();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mssv = tfStudentId.getText();
                try {
                    deleteStudent(mssv);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnFindStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findStudentFrame.setVisible(true);
            }
        });
    }

    private void tblStudentListInit(){
        DefaultTableModel tableModel = new DefaultTableModel(
                null,
                new String[] {"MSSV", "Tên sinh viên", "Ngày sinh", "Toán", "Lý", "Hóa"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblStudentList.setModel(tableModel);
        centerCellContent();
    }

    private void centerCellContent() {
        class CenteredTableCellRenderer extends DefaultTableCellRenderer {
            public CenteredTableCellRenderer() {
                setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
        for (int i = 0; i < tblStudentList.getColumnCount(); i++) {
            tblStudentList.getColumnModel().getColumn(i).setCellRenderer(new CenteredTableCellRenderer());
        }
    }

    private void loadDataFromDB()  {
        try {
            DefaultTableModel model  = (DefaultTableModel) tblStudentList.getModel();
            model.setRowCount(0);
            studentArrayList.clear();
            ResultSet resultSet = dao.retrieveData("SELECT * FROM SINHVIEN");
            while (resultSet.next()) {
                  String mssv = resultSet.getString(1);
                  String fullName = resultSet.getString(2);
                  String dateOfBirth = resultSet.getString(3);
                  float math = resultSet.getFloat(4);
                  float physics = resultSet.getFloat(5);
                  float chemistry = resultSet.getFloat(6);
                  studentArrayList.add(new Student(mssv, fullName, dateOfBirth, math, physics, chemistry));
            }
        } catch(SQLException e){
            e.printStackTrace();
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

    private boolean isEmpty(String... params) {
        for(String param : params){
            if(param.isEmpty()) return true;
        }
        return false;
    }

    private boolean isInvalidDate(String date){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return false;
        } catch (ParseException e) {
            return true;
        }
    }

    private boolean isNotUniqueId(String mssv){
        for(Student student : studentArrayList){
            if(mssv.equals(student.getMssv())) return true;
        }
        return false;
    }

    private void addStudent(String mssv, String fullName, String birthDate, String math, String physics, String chemistry) throws SQLException {
        studentArrayList.add(new Student(mssv, fullName, birthDate, Float.parseFloat(math), Float.parseFloat(physics), Float.parseFloat(chemistry)));
        dao.insertData("INSERT INTO SINHVIEN (MASV, HOTEN, NGSINH, DIEMTOAN, DIEMLY, DIEMHOA) " +
                "VALUES (?, ?, ?, ?, ?, ?)",
                mssv, fullName, birthDate, Float.parseFloat(math), Float.parseFloat(physics), Float.parseFloat(chemistry));
    }

    private void editStudent(String mssv, String fullName, String birthDate, String math, String physics, String chemistry) throws SQLException {
        DefaultTableModel model  = (DefaultTableModel) tblStudentList.getModel();
        Student student = getStudentIndexById(mssv);
        int index = studentArrayList.indexOf(student);

        if(student == null) {
            showDialog("ID doesn't exist!", "warning", "warn");
            return;
        }

        dao.insertData("UPDATE SINHVIEN " +
                        "SET HOTEN = ?, NGSINH = ?, DIEMTOAN = ?, DIEMLY = ?, DIEMHOA = ? " +
                        "WHERE MASV = ?",
                fullName, birthDate, Float.parseFloat(math), Float.parseFloat(physics), Float.parseFloat(chemistry), mssv);

        student.setFullName(fullName);
        student.setDateOfBirth(birthDate);
        student.setMath(Float.parseFloat(math));
        student.setPhysics(Float.parseFloat(physics));
        student.setChemistry(Float.parseFloat(chemistry));

        model.setValueAt(fullName, index, 1);
        model.setValueAt(birthDate, index, 2);
        model.setValueAt(math, index, 3);
        model.setValueAt(physics, index, 4);
        model.setValueAt(chemistry, index, 5);
    }

    private Student getStudentIndexById(String mssv){
        for(Student student : studentArrayList){
            if(student.getMssv().equals(mssv)) return student;
        }
        return null;
    }

    private void deleteStudent(String mssv) throws SQLException {
        DefaultTableModel model  = (DefaultTableModel) tblStudentList.getModel();
        Student student = getStudentIndexById(mssv);
        int index = studentArrayList.indexOf(student);

        if(student == null) {
            showDialog("ID doesn't exist!", "warning", "warn");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this student?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            dao.insertData("DELETE FROM SINHVIEN  WHERE MASV = ?", mssv);
            studentArrayList.remove(student);
            model.removeRow(index);
            showDialog("Delete student successfully", "Message", "info");
            resetField();
        }
    }

    private void resetField(){
        tfBirthDate.setText("");
        tfStudentId.setText("");
        tfStudentName.setText("");
        tfMath.setText("");
        tfPhysics.setText("");
        tfChemistry.setText("");
        tfStudentId.requestFocus();
    }

    private void onWindowClose() throws SQLException {
        connector.closeConnection();
        System.exit(0);
    }

    private void showDialog(String message, String title, String type) {
        int option;
        switch (type){
            case "info":
                option = JOptionPane.INFORMATION_MESSAGE;
                break;
            case "warn":
                option = JOptionPane.WARNING_MESSAGE;
                break;
            default:
                option = JOptionPane.DEFAULT_OPTION;
        }
        JOptionPane.showMessageDialog(this, message, title, option);
    }
}
