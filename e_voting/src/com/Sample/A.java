
/*This is sample java class to understand git throughly*/
class A{
	private String name;
	private Long rollNo;
	private short age;
	private String dept;
	private String sex;
	
	A(String name,Long rollNo,short age){
		this.setName(name);
		this.setRollNo(rollNo);
		this.setAge(age);
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void getAge(){
	
		return age;
		
	}
	public short setAge(short age){
		this.age = age;
	}
	public void getRollNo(){
		return rollNo;
	}
	public Long setRollNo(Long rollNo){
		this.rollNo = rollNo;
		
	}
	
	public void setDept(String dept){
		this.dept = dept;
	}
	public String getDept(){
		return dept;
	}
	
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}

}
