package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;

public class ListeDocumentsDispoServlet extends HttpServlet{
	private final int indiceIdEmprunter = 3;
	private final int numeroDocNonEmprunte = 0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(true);
       	

		try  { 
			ArrayList<Document> listeDoc = (ArrayList<Document>) Mediatheque.getInstance().tousLesDocuments();
			ArrayList<Document> listeDocDispo = new ArrayList<>();
			int idEmprunteur;
			for (Document doc : listeDoc) {
				idEmprunteur = (int) doc.data()[indiceIdEmprunter];
				if (idEmprunteur == numeroDocNonEmprunte) {
					listeDocDispo.add(doc);
				}
			}
			session.setAttribute("listeDocumentDisponible", listeDocDispo);
			response.sendRedirect("./afficherDocumentsDispos.jsp");
			
		} 
		catch (Exception e) {
			out.println(e);
		}
    }
}
