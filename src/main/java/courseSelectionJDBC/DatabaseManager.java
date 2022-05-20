package courseSelectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private Connection connection;
	public DatabaseManager() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc","root", "password");
	}
	public Connection getConnection() {
		return connection;
	}
}
