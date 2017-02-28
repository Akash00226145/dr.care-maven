package model;

import java.sql.SQLException;
import java.sql.Statement;

public class MySQLUser {
	private int id;
	private String email;

	private String password;
	private String address;

	public MySQLUser(int id, String email, String password, String address) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public MySQLUser(String email, String password, String address) {
		this.email = email;
		this.password = password;
		this.address = address;
	}
	
	public MySQLUser(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
