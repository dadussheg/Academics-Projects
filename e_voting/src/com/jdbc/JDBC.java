package com.jdbc;
import java.sql.*;





public class JDBC {
	Connection conn=null;
	public JDBC() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting","root","system");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User1 details(String emailId){
		ResultSet r;
		User1 user=new User1();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select name,rollno,photo from registration where rollno=?");
			mystmt.setString(1, emailId);
			r=mystmt.executeQuery();
			while(r.next()){
				
				user.setName(r.getString("name"));
				
				System.out.println(user.getName());
				user.setRollno(r.getString("rollno"));
				user.setImage( r.getBlob("photo"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	public int registration(String fname,String branch,String rollno,String email,String mobile_no,String password){
		int r = 0;
		try{
		PreparedStatement myStmt=conn.prepareStatement("insert into registration(name,rollno,branch,year,password) values(upper(?),?,?,?,md5(?))");
		myStmt.setString(1, fname);
		myStmt.setString(2, rollno);
		myStmt.setString(3, branch);
		myStmt.setString(4, email);
				myStmt.setString(5, password);
		r=myStmt.executeUpdate();
				}catch(Exception ex){
			ex.printStackTrace();
			//System.out.println(r);
		}
		return r;
		
	}
	
	
	public boolean loginCheck(String emailId,String password){
		ResultSet rset;
		boolean result = false;
		try {
			//get a connection
			//prepared statement
			PreparedStatement myStmt=conn.prepareStatement("select rollno,password from registration where rollno=? and password=md5(?)");
			myStmt.setString(1, emailId);
			myStmt.setNString(2, password);
			rset=myStmt.executeQuery();
			result=rset.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result==true){
			return true;
		}else{
			return false;
		}
	}

	public int vote(String rollno,String voter){
		int result=0;
		try {
			//get a connection
			//prepared statement
			PreparedStatement myStmt=conn.prepareStatement("update participant set vote=vote+1,voter=? where rollno=?");
			myStmt.setString(1, voter);
			myStmt.setString(2, rollno);
			//myStmt.setNString(2, password);
			result=myStmt.executeUpdate();
			//System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean getVoter(String voter,String post){
		ResultSet r;
		PreparedStatement mystmt;
		boolean result=false;
		try {
			mystmt = conn.prepareStatement("select voter from voters where voter=? && post=?");
			mystmt.setString(1, voter);
			mystmt.setString(2,post);
			r=mystmt.executeQuery();
			result=r.next();
			//System.out.println("result value "+result);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==true){
			return true;
		}else{
			return false;
		}
		
	}
	public boolean checkParticipant(String rollno){
		ResultSet r;
		PreparedStatement mystmt;
		boolean result=false;
		try {
			mystmt = conn.prepareStatement("select rollno from participant where rollno=?");
			mystmt.setString(1, rollno);
			r=mystmt.executeQuery();
			result=r.next();
			//System.out.println("result value "+result);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==true){
			return true;
		}else{
			return false;
		}
	}
	/*public int post(String p,String to_whom,String whom){
		int r=0;
		try {
			PreparedStatement myStmt=conn.prepareStatement("insert into post values(upper(?),?,?,current_date,current_time)");
			myStmt.setString(1, to_whom);
			myStmt.setString(2, whom);
			myStmt.setString(3, p);
			r=myStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return r;
	}*/
	/*public String search(String d){
		String r = null;
		ResultSet rst;
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select name from details where name like ?%");
			mystmt.setString(1, d);
			mystmt.setString(2, d);
			rst=mystmt.executeQuery();
			while(rst.next()){
				r=rst.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
		
	}*/
	
	/*public Post getPost(){
		ResultSet r;
		Post p=new Post();
		PreparedStatement mystmt;
		try {
			mystmt = conn.prepareStatement("select * from post");
			r=mystmt.executeQuery();
			while(r.next()){
				//System.out.println(r.getString("name"));
				p.setTo_whom(r.getString("to_whom"));
				//name=r.getString("name");
				//System.out.println(user.getName());
				//System.out.println(r.getString("email"));
				p.setWhom(r.getString("whom"));;
				//System.out.println(user.getEmail());
				//System.out.println(r.getString("rollno"));
				p.setPost(r.getString("what"));;
				//System.out.println(user.getRollno());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}*/

}
