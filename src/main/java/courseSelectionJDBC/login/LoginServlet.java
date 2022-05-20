package courseSelectionJDBC.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import courseSelectionJDBC.models.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	private LoginDao loginDao;
     
    public void init() {
    	loginDao = new LoginDao();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		
		try {
			if(loginDao.validate(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("menu.jsp");
				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				response.sendRedirect("login.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
