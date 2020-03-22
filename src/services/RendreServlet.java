package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.RechercheDocException;
import mediatek2020.items.Document;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public class RendreServlet extends HttpServlet{
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
       	int numDoc = Integer.parseInt(request.getParameter("numLivreARendre"));
       	
		try  {
			
			Document doc = Mediatheque.getInstance().getDocument(numDoc); //requete qui emprunte
			if (doc == null) {
				throw new RechercheDocException();
			}
			doc.rendre(user);
			response.sendRedirect("./documentRendu.jsp");
		}
		catch (RechercheDocException re) {
			session.setAttribute("erreur", "la côte renseignée ne correspond à aucun document de la médiathèque");
			response.sendRedirect("./erreurUser.jsp");
		}
		catch (RetourException re) {
			session.setAttribute("erreur", "le document renseigné a déjà été retourné");
			response.sendRedirect("./erreurUser.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("erreur", "une erreur s'est produite");
			response.sendRedirect("./erreurUser.jsp");
		}
    }
}
