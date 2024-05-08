import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
    private final Connection connection;

    public DataAccessObject(Connection connection) {
        this.connection = connection;
    }

    public void insertData(String query, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            setParameters(statement, params);
            statement.executeUpdate();
        }
    }

    public ResultSet retrieveData(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        setParameters(statement, params);
        return statement.executeQuery();
    }

    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
