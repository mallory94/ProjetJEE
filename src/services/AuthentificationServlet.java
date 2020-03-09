package services;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;

import mediatek2020.Mediatheque;
import mediatek2020.items.Utilisateur;
import persistance.MediathequeData;
import persistance.RequeteSQL;

public class AuthentificationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(true);
    	
    	out.println ("<html>");
    	
    	out.println ("<head>");
    	String title = "Login/passwd enregsitr�";
    	out.println ("<title>" + title + "</title>");
    	out.println ("</head>");
    	
    	out.println ("<body bgcolor=\"white\"> ");
    	String login = request.getParameter("pseudo");
       	String passwd = request.getParameter("mdp");
       	out.println ("<h2>Page de connexion</h2>" + " <br> login = " + login + " et mdp = " + passwd);
       	// v�rification sur la BD
       	String[] args = new String[2];
       	args[0] = login; args[1] = passwd;
		try  { 
			Utilisateur user = Mediatheque.getInstance().getUser(login, passwd);
			if (user==null)
				out.println ("Vous n'avez pas �t� reconnu");
			else {
		       	session.setAttribute("user", user);
		     	out.println("Authentification bien enregsitr�e");
		     	out.println("<A href = \"verification\"> Cliquer ici pour v�rifier</A");
			}
		} 
		catch (Exception e) {
			out.println(e);
		}
        out.println("</body>");

        out.println("</html>");
    }

}
