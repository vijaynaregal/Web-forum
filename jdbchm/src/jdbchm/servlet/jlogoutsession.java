package jdbchm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jlogoutsession")
public class jlogoutsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jlogoutsession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session=request.getSession(false);  
	        if (session != null) {
	        	session.invalidate();
	            	response.sendRedirect( "jloginsession" );
	            }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
