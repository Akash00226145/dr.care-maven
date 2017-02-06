package controller;

import java.io.Serializable;

public class GenerateUUIDBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String UUID;
	public GenerateUUIDBean(){
		this.UUID=generateUUID.shortUUID();
	}
	public String getUUID(){
		return UUID;
	}
}
