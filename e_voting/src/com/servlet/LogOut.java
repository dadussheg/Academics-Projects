package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();  
         
         request.getRequestDispatcher("index2.html").include(request, response); 
         //response.setHeader("Cache-Control", "no-cache"); 
         //response.setHeader("Pragma", "no-cache"); 
         //response.setDateHeader("Expires", 0); 
           
         HttpSession session=request.getSession();  
         session.invalidate();  
           
         out.print("You are successfully logged out!"); 
         
           
         out.close();  
	}

	
	

}
