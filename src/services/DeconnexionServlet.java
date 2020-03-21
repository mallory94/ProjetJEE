package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.items.Utilisateur;

public class DeconnexionServlet extends HttpServlet{

	private static final long serialVersionUID = -1634389023286570897L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
    	HttpSession session = request.getSession(false);
       	
		try  {
			session.invalidate();
			response.sendRedirect("./");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }

}
