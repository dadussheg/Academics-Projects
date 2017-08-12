package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.JDBC;
import com.jdbc.User1;

public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try{   
			JDBC j=new JDBC();
		    Cookie ck[]=request.getCookies();   
		    for(Cookie c : ck){
		    	
		    	//System.out.println(c.getName());
		    	//System.out.println(c.);
		    	
		    	if(c.getName().equals("emailId")){
		    		System.out.println(c.getValue());
		    
		    		User1 us=j.details(c.getValue());
		    		//out.println(us.getName());
		    		request.getSession().setAttribute("user",us);
		    		response.sendRedirect("after_login.jsp");
		    		
		    	}
		    }
		    //out.print("Hello "+ck[0].getValue());  
		         }catch(Exception e){System.out.println(e);}  
	}

}
