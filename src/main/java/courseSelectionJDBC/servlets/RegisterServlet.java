package courseSelectionJDBC.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import courseSelectionJDBC.DatabaseManager;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(8 * 1024 * 1024);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setFileSizeMax(1 * 1024 * 1024);
			upload.setSizeMax(2 * 1024 * 1024);

			String uploadPath = getServletContext().getRealPath("") + File.separator + "images";

			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			String username = null;
			String password = null;
			String uploadedFilePath = null;
			List<FileItem> formItems = null;
			try {
				formItems = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}

			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						try {
							item.write(storeFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
						uploadedFilePath = "/coursejdbc/images/" + fileName;

					} else {
						if (item.getFieldName().equals("username")) {
							username = item.getString();
						}
						if (item.getFieldName().equals("password")) {
							password = item.getString();
						}
					}

				}
			}
			try {
				DatabaseManager db = new DatabaseManager();

				String query = "INSERT INTO users(username,password,image_path) VALUES(?,?,?)";
				PreparedStatement ps = db.getConnection().prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, uploadedFilePath);

				ps.executeUpdate();

				db.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
