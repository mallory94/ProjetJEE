package exo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import data.User;

public class VerifAuthentificationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request,HttpServletResponse response) 
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession(true);
    	
    	out.println("<html>");
    	
    	out.println("<head>");
    	String title = "Vérification de l'authentification";
    	out.println("<title>" + title + "</title>");
    	out.println("</head>");
    	
    	out.println("<body bgcolor=\"white\">");
       	User user = (User) session.getAttribute("user");
       	if (user!=null)
       		out.println("Utilisateur enregistré dans la variable session user " + user);
       	else out.println("pas de variable session user");
        out.println("</body>");
        
        out.println("</html>");
    }
}
