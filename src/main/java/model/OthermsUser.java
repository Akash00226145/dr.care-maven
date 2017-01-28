package model;

import java.sql.SQLException;
import java.sql.Statement;

public class OthermsUser {
	private int id;
	private String username;

	private String password;
	private String address;

	public OthermsUser(int id, String username, String password, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public OthermsUser(String username, String password, String address) {
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
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
