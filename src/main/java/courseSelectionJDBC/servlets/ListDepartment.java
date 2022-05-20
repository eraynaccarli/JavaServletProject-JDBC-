package courseSelectionJDBC.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseSelectionJDBC.DatabaseManager;
import courseSelectionJDBC.models.Department;

@WebServlet("/departments")
public class ListDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ResultSet rs;
		
			try {
				DatabaseManager db = new DatabaseManager();
				Statement st = db.getConnection().createStatement();
				rs = st.executeQuery("SELECT * FROM departments");
				ArrayList<Department> departments = new ArrayList();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Department dp = new Department(id,name);
					departments.add(dp);
				}
				request.setAttribute("departments",departments);
				request.getRequestDispatcher("/WEB-INF/listDepartment.jsp").forward(request, response);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	}



}
