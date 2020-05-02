package jdbchm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jcreateforum")
public class jcreateforum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public jcreateforum() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		        HttpSession session=request.getSession(false);  
		       String a=(String) session.getAttribute("username");
		        session.getAttribute("currentuser");  
		        if (session != null) {
		            if (session.getAttribute("username")!=null&&a.equals("jdoe1")) {	
		          
		request.getRequestDispatcher( "/WEB-INF/jcreateforum.jsp" )
        .forward( request, response );
		            }else response.sendRedirect( "jerror" );}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";
            int a =0;
            String sql = "insert into forum (forum, topics) values (?, ?)";

            c = DriverManager.getConnection( url, username, password );
           
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getParameter( "forum" ) );
            pstmt.setInt( 2, a );
            pstmt.executeUpdate();
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

        response.sendRedirect( "jforum" );
    }

	}


