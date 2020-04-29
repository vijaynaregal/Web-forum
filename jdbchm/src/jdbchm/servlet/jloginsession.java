package jdbchm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	      Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu06";
	            String password = "bI.*X*!.";


	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select user,username, password from session where username ="+"'"+un+"'" );

	             rs.next();
                       String currentuser =  rs.getString( "user" ); 
	                   String username1 =  rs.getString( "username" ); 
	                   String password1 = rs.getString( "password" );
	                   if (un.equals(username1)&&pwd.equals(password1)) {
	          	         HttpSession session = request.getSession(true); 
	          	         session.setAttribute("username", un);
	          	         session.setAttribute("pass", pwd);
	          	         session.setAttribute("currentuser", currentuser);
	          	         session.setMaxInactiveInterval(30); 
	          	         response.sendRedirect("jforum");
	          	      } 
	          		else {
	          	    	  request.getRequestDispatcher( "/WEB-INF/session.jsp" )
	          	            .forward( request, response );	      }
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	 
	}

}
