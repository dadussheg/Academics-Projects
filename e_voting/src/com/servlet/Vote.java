package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.NumberUp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.JDBC;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     String rollno=request.getParameter("rollno");
	     String post=request.getParameter("post");
	     System.out.println(rollno);
	     System.out.println(post);	     
	     String message=null;
	     int result=0;
	     boolean voter=false;
	     PrintWriter out=response.getWriter(); 
	     try{
	 		JDBC j=new JDBC();
	 		  Cookie ck[]=request.getCookies();   
	 		 for(Cookie c : ck){
	 			if(c.getName().equals("emailId")){
	 				voter=j.getVoter(c.getValue(),post);
	 				System.out.println(voter);
	 				if(voter==true){
	 					request.getRequestDispatcher("evoting.html").include(request, response);
	 					out.print("You have already voted"); 
	 					//response.sendRedirect("evoting.html");
	 				}else{
	 					result=j.vote(rollno,c.getValue());
	 					if(result==1){
	 			 			//message="vote given";
	 						request.getRequestDispatcher("evoting.html").include(request, response);
	 			 			out.print("Your vote has been submitted");
	 			 		}else{
	 			 			message="vote not given try after some time";
	 			 		}
	 				}
	 				
	 			}
	 		 }
	 		
	 		//System.out.println(result);
	 		
	     }catch(Exception ex){
	    	 message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
			}
	     //request.setAttribute("Message", message);
	     //getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	}

}
