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

public class RendreServlet extends HttpServlet{
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
       	int numDoc = Integer.parseInt(request.getParameter("numLivreARendre"));
       	
		try  {
			
			Document doc = Mediatheque.getInstance().getDocument(numDoc); //requete qui emprunte
			System.out.println(" id du document dans RendreServlet = " + doc.data()[0]);
			doc.rendre(user);
			response.sendRedirect("./livreRendu.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
