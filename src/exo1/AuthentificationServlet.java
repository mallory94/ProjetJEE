package exo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import data.User;

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
    	String title = "Login/passwd enregsitré";
    	out.println("<title>" + title + "</title>");
    	out.println("</head>");
    	
    	out.println("<body bgcolor=\"white\">");
    	String login = request.getParameter("login");
       	String passwd = request.getParameter("passwd");
       	
       	
       	User user = new User(login, passwd);
       	session.setAttribute("user", user);
     	out.println("Authentification bien enregistrée");
     	out.println("<A href = \"verification\"> Cliquer ici pour vérifier</A>");
        out.println("</body>");
        
        out.println("</html>");
    }

}
