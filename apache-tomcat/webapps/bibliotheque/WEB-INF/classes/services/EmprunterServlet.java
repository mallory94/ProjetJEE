package services;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;
import persistance.MediathequeData;
import persistance.RequeteSQL;

public class EmprunterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
       	int numDoc = Integer.parseInt(request.getParameter("numDoc"));
       	
		try  {
			
			Document doc = Mediatheque.getInstance().getDocument(numDoc); //requete qui emprunte
			Mediatheque.getInstance().emprunter(doc, user);
		}
		catch (Exception e) {
			e.printStackTrace();;
		}
    }

}
