package exo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import data.User;
import mediatek2020.items.Abonne;
import mediatek2020.items.Utilisateur;

public class AuthentificationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {   
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(true);
    	
    	out.println("<html>");
    	
    	out.println("<head>");
    	String title = "Login/passwd enregsitr�";
    	out.println("<title>" + title + "</title>");
    	out.println("</head>");
    	
    	out.println("<body bgcolor=\"white\">");
    	String login = request.getParameter("login");
       	String passwd = request.getParameter("passwd");
       	
       	
       	Utilisateur user = new Abonne(login);
       	session.setAttribute("user", user);
     	out.println("Authentification bien enregistr�e" + user.toString());
     	out.println("<A href = \"verification\"> Cliquer ici pour v�rifier</A>");
        out.println("</body>");
        
        out.println("</html>");
    }

}
