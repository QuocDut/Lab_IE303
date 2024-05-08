package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/QLSV";
        String username = "root";
        String password = "q28022003";
        JFrame mainFrame;
        ArrayList<Student> studentArrayList = new ArrayList<Student>();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseConnector connector = new DatabaseConnector(url, username, password);
            DataAccessObject dao = new DataAccessObject(connector.getConnection());

            // Assign data access object to main frame
            mainFrame = new MainFrame(connector, dao, studentArrayList);
        } catch(SQLException | ClassNotFoundException exception) {
        }
    }
}
