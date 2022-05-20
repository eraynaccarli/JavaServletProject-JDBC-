package courseSelectionJDBC.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
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
import courseSelectionJDBC.models.Course;

@WebServlet("/UpdateCourse")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateCourseServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs ;
		try {
			DatabaseManager db = new DatabaseManager();
			Statement st = db.getConnection().createStatement();
			ArrayList<Course> courses = new ArrayList();
			rs = st.executeQuery("SELECT * FROM courses");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name  = rs.getString("name");
				String code = rs.getString("code");
				int department_id = rs.getInt("department_id");
				Course c = new Course(id,name,code,department_id);
				courses.add(c);
				
				request.setAttribute("courses", courses);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("/WEB-INF/updateCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		try {
			DatabaseManager db = new DatabaseManager();
			PreparedStatement ps = db.getConnection().prepareStatement("UPDATE courses SET name = ?, code = ?  where id = ? ");
			ps.setString(1, name);
			ps.setString(2, code);
			ps.setInt(3, Integer.valueOf(id));
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
