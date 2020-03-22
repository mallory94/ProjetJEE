package services;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import mediatek2020.Mediatheque;
import mediatek2020.RechercheDocException;
import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.Utilisateur;

public class EmprunterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
    	HttpSession session = request.getSession(false);
    	
    	Utilisateur user = (Utilisateur) session.getAttribute( "user" );
       	int numDoc = Integer.parseInt(request.getParameter("numDoc"));
       	
		try  {
			
			Document doc = Mediatheque.getInstance().getDocument(numDoc); //requete qui emprunte
			if (doc == null) {
				throw new RechercheDocException();
			}
			System.out.println(" id du document dans EmprunterServlet = " + doc.data()[0]);
			Mediatheque.getInstance().emprunter(doc, user);
			response.sendRedirect("./empruntReussi.jsp");
		}
		catch (RechercheDocException re) {
			session.setAttribute("erreur", "la côte renseignée ne correspond à aucun document de la médiathèque");
			response.sendRedirect("./erreurUser.jsp");
		}
		catch (EmpruntException ex) {
			ex.printStackTrace();
			String message = "le document renseigné est déjà emprunté";
			session.setAttribute("erreur", message);
			response.sendRedirect("./erreurUser.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			String message = "une erreur s'est produite";
			session.setAttribute("erreur", message);
			response.sendRedirect("./erreurUser.jsp");
		}
		
    }

}
