package courseSelectionJDBC.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import courseSelectionJDBC.DatabaseManager;
import courseSelectionJDBC.models.User;

public class LoginDao {

	public boolean validate(User user) throws ClassNotFoundException, SQLException {
		boolean status = false;
		
		DatabaseManager db = new DatabaseManager();
		PreparedStatement ps = db.getConnection().prepareStatement("select * from users where username = ? and password = ?");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		
		System.out.println(ps);
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		return status;
	}
}
