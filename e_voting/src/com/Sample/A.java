class A{
	private String name;
	private Long rollNo;
	private short age;
	private String dept;
	A(String name,Long rollNo,short age){
		this.name=name;
		this.rollNo = rollNo;
		this.age = age;
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
