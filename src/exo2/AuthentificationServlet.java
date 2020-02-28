package exo2;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;

import data.User;
import outilsBD.RequeteSQL;

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
    	
    	out.println ("<html>");
    	
    	out.println ("<head>");
    	String title = "Login/passwd enregsitré";
    	out.println ("<title>" + title + "</title>");
    	out.println ("</head>");
    	
    	out.println ("<body bgcolor=\"white\">");
    	String login = request.getParameter("login");
       	String passwd = request.getParameter("passwd");
       	// vérification sur la BD
       	String[] args = new String[2];
       	args[0] = login; args[1] = passwd;
		try  { User user = (User) RequeteSQL.execute(2,args);
		if (user==null)
			out.println ("Vous n'avez pas été reconnu");
		else {
	       	session.setAttribute("user", user);
	     	out.println("Authentification bien enregsitrée");
	     	out.println("<A href = \"verification\"> Cliquer ici pour vérifier</A");
		}
		} 
		catch (Exception e) {
			out.println(e);
		}
        out.println("</body>");

        out.println("</html>");
    }

}
