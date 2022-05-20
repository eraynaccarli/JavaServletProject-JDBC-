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

@WebServlet("/addCourseView")
public class AddCourseView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultSet rs = null;
		DatabaseManager db;
		try {
			db = new DatabaseManager();
			Statement stmt = db.getConnection().createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments");
			ArrayList<Department> departments = new ArrayList<Department>();
			while (rs.next()) {
				String departmentName = rs.getString("name");
				int DepartmentId = rs.getInt("id");
				Department d = new Department(DepartmentId, departmentName);
				departments.add(d);

				request.setAttribute("departments", departments);
				request.getRequestDispatcher("/WEB-INF/addCourse.jsp").forward(request,  response);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
