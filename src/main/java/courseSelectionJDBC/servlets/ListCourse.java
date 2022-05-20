package courseSelectionJDBC.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseSelectionJDBC.DatabaseManager;
import courseSelectionJDBC.models.Course;
import courseSelectionJDBC.models.Department;


public class ListCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultSet rs;
		try {
			DatabaseManager db = new DatabaseManager();
			Statement st = db.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM courses INNER JOIN departments ON courses.department_id = departments.id ");
			ArrayList<Course> courses = new ArrayList();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("courses.name");
				String code = rs.getString("code");
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("departments.name");
				Department d = new Department(departmentId,departmentName);
				Course c = new Course(id,name,code,d);
				courses.add(c);
			}
			
			request.setAttribute("courses", courses);
			request.getRequestDispatcher("/WEB-INF/listCourse.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
