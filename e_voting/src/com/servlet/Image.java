package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class Image
 */
@WebServlet("/Image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 

		//PrintWriter out=response.getWriter();
            // declare a connection by using Connection interface 
            Connection connection = null;

            /* Create string of connection url within specified format with machine 
			name, port number and database name. Here machine name id localhost 
			and database name is student. */

            String connectionURL = "jdbc:mysql://localhost:3306/evoting";

            /*declare a resultSet that works as a table resulted by execute a specified 
			sql query. */
            ResultSet rs = null;

            // Declare statement.
            PreparedStatement psmnt = null;
           
		    // declare InputStream object to store binary stream of given image.
			InputStream sImage;

            try {

                // Load JDBC driver "com.mysql.jdbc.Driver"
                Class.forName("com.mysql.jdbc.Driver").newInstance();

				/* Create a connection by using getConnection() method that takes 
				parameters of string type connection url, user name and password to 
				connect to database. */
                connection = DriverManager.getConnection(connectionURL, "root", "system");

				/* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */
                psmnt = connection.prepareStatement("SELECT photo FROM participant WHERE firstname = ?");

                psmnt.setString(1, "akshay");
                rs = psmnt.executeQuery();
                if(rs.next()) {
                      byte[] bytearray = new byte[1048576];
                      int size=0;
                      sImage = rs.getBinaryStream(1);
                      //response.reset();
                      response.setContentType("image/jpeg");
               while((size=sImage.read(bytearray))!= -1 ){

                            response.getOutputStream().write(bytearray,0,size);
				      }
                    
                      } 
              
		    }
		    
            catch(Exception ex){
				//out.println("error :"+ex);
            }
 
          finally {
                
                try {
                	rs.close();
					psmnt.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
		
    	
    }

}
