package model;

import java.sql.SQLException;
import java.sql.Statement;

public class Prescription{
	
	private int id;
	private String method;
	private String medicine;
	private int pid;

	public Prescription(int id, String method, String medicine, int pid) {
		this.id = id;
		this.method = method;
		this.medicine = medicine;
	}
	
	public Prescription(String method, String medicine) {
		this.method = method;
		this.medicine = medicine;
	}

	public String getmethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String method) {
		this.medicine = medicine;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}