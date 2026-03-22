package model.entity;

public class Admin {
	
	private Integer id;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Admin(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password =" + password + "]";
	}
	
	

}
