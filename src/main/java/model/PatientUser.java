package model;

import java.sql.SQLException;
import java.sql.Statement;

public class PatientUser {
	
	private int id;
	//private String name;
	private String email;
	private String address;
	private String password;
	private long EMID;

	

	public PatientUser() {
		super();
	}

	public PatientUser(int id, String email, String password) {
		this.id = id;
		//this.name = name;
		this.email = email;
		//this.address = address;
		//this.phone = phone;
		this.password = password;
	}
	
	public PatientUser(int id, String email, String address, String password, long eMID) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.password = password;
		EMID = eMID;
	}

	public PatientUser(String email, String address, String password) {
		//this.name = name;
		this.email = email;
		this.address = address;
		//this.phone = phone;
		this.password = password;
	}
	
	

/*	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PatientUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getEMID() {
		return EMID;
	}

	public void setEMID(long eMID) {
		EMID = eMID;
	}
}