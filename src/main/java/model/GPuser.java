package model;

public class GPuser {
	private int id;
	private String name;
	private String email;
	private String address;
	private int phone;
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	private String password;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public GPuser(int id, String name, String email, String address, int phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;		
	}
	
	public GPuser(String name, String email, String address, int phone,String fileName, String password) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.fileName = fileName;
		this.password = password;	
	}

	public GPuser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
