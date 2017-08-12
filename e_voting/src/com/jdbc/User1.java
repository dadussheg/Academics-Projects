package com.jdbc;

import com.mysql.jdbc.Blob;

public class User1 {
	private String name;
	private String rollno;
	private String email;
	private java.sql.Blob image;
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setImage(java.sql.Blob image){
		this.image = image;
	}
	public java.sql.Blob getImage(){
		return image;
	}
	
}
