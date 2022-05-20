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

@WebServlet("/DeleteCourse")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteCourseServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/deleteCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			DatabaseManager db = new DatabaseManager();
			PreparedStatement ps = db.getConnection().prepareStatement("DELETE FROM courses where id = ?");
			ps.setInt(1, Integer.valueOf(id));
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
