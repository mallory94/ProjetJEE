package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class ListeDocumentsDispoServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(true);
       	

		try  { 
			List<Document> listeDoc = Mediatheque.getInstance().tousLesDocuments();
			session.setAttribute("listeDocument", listeDoc);
		} 
		catch (Exception e) {
			out.println(e);
		}
    }
}
