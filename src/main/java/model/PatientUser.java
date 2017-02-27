package model;

import java.sql.SQLException;
import java.sql.Statement;

public class PatientUser {
	
	private int id;
	private String email;
	private String address;
	private String password;
	private long EMID;

	

	public PatientUser() {
		super();
	}


	public PatientUser(int id, String email, String password, String address) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	

	public PatientUser(int id, String email, String password, String address, long eMID) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
		EMID = eMID;
	}
	
 /*public PatientUser(int id, String email, String password, String address, long eMID) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
		this.EMID = eMID;
	}*/

	public PatientUser(String email, String password, String address, long eMID) {

		this.email = email;
		this.password = password;
		this.address = address;
		this.EMID = eMID;
	}
	public PatientUser(String email, String password, String address) {

		this.email = email;
		this.password = password;
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getEMID() {
		return EMID;
	}

	public void setEMID(long eMID) {
		EMID = eMID;

	}
}