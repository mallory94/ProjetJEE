package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class AjouterDocumentServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
    	String nomDoc = request.getParameter("nomDoc");
    	String autDoc = request.getParameter("autDoc");
       	
		try  {
			
			Mediatheque.getInstance().nouveauDocument(0, 
					new Object[] { nomDoc , autDoc} );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
