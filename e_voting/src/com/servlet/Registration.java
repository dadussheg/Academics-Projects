package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.JDBC;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		String fname=request.getParameter("fname");
		String rollno=request.getParameter("rollno");
		String branch=request.getParameter("branch");
		String email=request.getParameter("email");
		String mobileNo=request.getParameter("mobile_no");
		String password=request.getParameter("password");
		boolean check=false;
		//String lname=request.getParameter("lname");
		//String year=request.getParameter("year");
		
	
		
		
		
		try {
			JDBC j = new JDBC();
			PrintWriter out=response.getWriter();
			check=j.checkParticipant(rollno);
			if(check==true){
				request.getRequestDispatcher("index2.html").include(request, response); 
				out.print("You can't register!!!"); 
			}else{
			        result=j.registration(fname,branch,rollno,email,mobileNo,password);
			        if(result==1){
			     	    System.out.println("registered");
				        response.sendRedirect("index2.html");
			}       else{
				       System.out.println("not registered");
			        }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
