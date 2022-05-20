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



@WebServlet("/addCourse")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CourseServlet() {

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String department_id = request.getParameter("department_id");
		DatabaseManager db;
		try {
			db = new DatabaseManager();
			 String query = "INSERT INTO courses(name,code,department_id) VALUES(?,?,?)";
			    PreparedStatement ps = db.getConnection().prepareStatement(query);
			    ps.setString(1, name);
			    ps.setString(2, code);
			    ps.setInt(3, Integer.valueOf(department_id));
			    ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
		

	}

}
