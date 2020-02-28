import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthentificationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6770265831912217878L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
											throws IOException, ServletException {
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			data.User dataUser= new User(); 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			
			String title = "bonjour jeff";
			
			out.println("<title>" + title + "</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"white\">");
			
			out.println("<h1>" + title + " big boss" + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	
}
