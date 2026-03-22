package model.entity;

import java.sql.Date;

public class Student {
	
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String qualification;
	private Date dob;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer id,String name, String password, String email, String gender, String qualification,
			Date dob) 
	{
		this(name,password,email,gender,qualification,dob);
		this.id = id;
		
	}


	public Student( String name, String password, String email, String gender, String qualification,
			Date dob) {
		super();
		
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.qualification = qualification;
		this.dob = dob;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", qualification=" + qualification + ", dob=" + dob + "]";
	}
	
	
	

}
