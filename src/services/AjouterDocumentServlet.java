package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Utilisateur;

public class AjouterDocumentServlet extends HttpServlet{

	private static final long serialVersionUID = -7981051592619907988L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
    	String nomDoc = request.getParameter("nomDoc");
    	String autDoc = request.getParameter("autDoc");
    	String typeDoc = request.getParameter("typeDoc");
       	System.out.println("typeDoc = " + typeDoc);
		try  {
			
			Mediatheque.getInstance().nouveauDocument(0, 
					new Object[] { nomDoc , autDoc, typeDoc});
			response.sendRedirect("./documentAjoute.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			String message = "une erreur empechant l'ajout s'est produite";
			session.setAttribute("erreur", message);
			response.sendRedirect("./erreurBibliothecaire.jsp");
		}
    }
}
