import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final Connection connection;

    public DatabaseConnector(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        System.out.println("database connected");
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("connection closed");
        }
    }
}
