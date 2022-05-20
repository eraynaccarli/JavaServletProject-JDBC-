package courseSelectionJDBC.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseSelectionJDBC.DatabaseManager;

@WebServlet("/addDepartment")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddDepartmentServlet() {
       
    }
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/addDepartment.jsp").forward(request,  response);
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		try {
			DatabaseManager db = new DatabaseManager();
			String query = "INSERT INTO departments(name) VALUES(?)";
			PreparedStatement ps = db.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
