package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.JDBC;
import com.jdbc.User1;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean result=false;
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		//PrintWriter out=response.getWriter();
		try{
		JDBC j=new JDBC();
		result=j.loginCheck(emailId, password);
		
		System.out.println(result);
		if(result==true){
			
			User1 us=j.details(emailId);
			request.getSession().setAttribute("user",us);
			//response.addCookie(ck);
			/*out.print("Welcome "+emailId);
			out.print("<form action='servlet2' method='post'>");  
		    out.print("<input type='submit' value='go'>");  
		    //out.print("</form>"); */
			Cookie ck=new Cookie("emailId", emailId);
			response.addCookie(ck);
			response.sendRedirect("evoting.html");
			//RequestDispatcher dispatcher=request.getRequestDispatcher("post.jsp");
			//dispatcher.forward(request, response);
			//RequestDispatcher disp=request.getRequestDispatcher("post.jsp");
			//disp.forward(request, response);
			return;
		}else{
			response.sendRedirect("login_wp.html");
			
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
