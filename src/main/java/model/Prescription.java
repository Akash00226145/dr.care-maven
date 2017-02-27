package model;

import java.sql.SQLException;
import java.sql.Statement;

public class Prescription{
	
	private int id;
	private String method;
	private String medicine;
	private int pid;
	private String video;

	public Prescription(int id, String method, String medicine, int pid, String video) {
		this.id = id;
		this.method = method;
		this.medicine = medicine;
		this.pid = id;
		this.video = video;
	}
	
	public Prescription(String method, String medicine, String video) {
		this.method = method;
		this.medicine = medicine;
		this.video = video;
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
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}