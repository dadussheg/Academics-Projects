<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote(LR)</title>
<style>
body{
background-image: url(last.jpg);
}
</style>
</head>
<body>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 


      <%
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
                psmnt = connection.prepareStatement("SELECT * FROM participant WHERE post ='LR' && gender='F' ");

                //psmnt.setString(1, "aditya");
                rs = psmnt.executeQuery();
                while(rs.next()){
                %>
                	<br>Name:-&nbsp;<%=rs.getString("firstname")%>&nbsp;<%=rs.getString("lastname")%><form method="post" action="vote">
                	<input type="text" value="LR" name="post">
                	RollNo:- &nbsp;<input type="text" name="rollno" value="<%=rs.getString("rollno")%>">&nbsp;<input type="submit" value="Vote"></form><br>
                <% 
                }
              
		    }
		    
            catch(Exception ex){
				out.println("error :"+ex);
            }
            %>

</body>
</html>