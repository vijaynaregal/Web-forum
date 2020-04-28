package jdbchm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jloginsession")
public class jloginsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jloginsession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/session.jsp" )
        .forward( request, response );
	     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String un = request.getParameter("username");
	      String pwd = request.getParameter("password");
	    
		if (un.equals("candidjava")&&pwd.equals("abcd")) {
	         HttpSession session = request.getSession(true); 
	         session.setAttribute("user", un);
	         session.setAttribute("pass", pwd);
	         session.setMaxInactiveInterval(30); 
	         response.sendRedirect("jforum");
	      } 
		else {
	    	  request.getRequestDispatcher( "/WEB-INF/session.jsp" )
	            .forward( request, response );	      }
	 
	}

}
