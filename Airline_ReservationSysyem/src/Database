import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final static String DB_URL = "jdbc:mysql://localhost/Air_Line";
    private final static String user = "root";
    private final static String password = "11011101@!!!";
    Connection connection = null;

    public Database() {
        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection Connection() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(DB_URL, user, password);
        return connection;
    }

}
