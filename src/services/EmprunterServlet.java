package services;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;

import data.User;
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
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(false);
    	
    	out.println ("<html>");
    	
    	out.println ("<head>");
    	String title = "Emprunt";
    	out.println ("<title>" + title + "</title>");
    	out.println ("</head>");
    	
    	out.println ("<body bgcolor=\"white\"> ");
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
       	int numDoc = Integer.parseInt(request.getParameter("numDoc"));
       	out.println ("<h2>Page de connexion</h2>" + " <br> login = " + login + " et mdp = " + passwd);
       	// vérification sur la BD
       	
		try  {
			
			Document doc = Mediatheque.getInstance().getDocument(numDoc); //requete qui emprunte
			Mediatheque.getInstance().emprunter(doc, user);
		}
		catch (Exception e) {
			out.println(e);
		}
        out.println("</body>");

        out.println("</html>");
    }

}
