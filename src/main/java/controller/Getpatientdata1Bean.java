package controller;

import dao.PatientUserDAO;
import model.PatientUser;

public class Getpatientdata1Bean {

	private static final long serialVersionUID = 1L;
	private PatientUser pu;
	private String msg;
	public Getpatientdata1Bean(){
//		this.pu=new .uniqueCurrentTimeMS();
		pu=new PatientUser();
		msg="";
	}
	private void saveEmid(){
		if(pu.getEmail()==null||pu.getEmail().length()==0){
			// no email input, do nothing.
			return ;
		}else{
			// generate emid and save it into db
			pu=PatientUserDAO.getPatient(pu.getEmail());
			if(pu==null){
				msg="Patient doesn't exist.";
				return ;
			}
			if(pu.getEMID()==0){
				// no emid, we have to generate a new one
				long emid=GenerateEMID.getEmid();
				pu.setEMID(emid);
				PatientUserDAO.updateEmid(pu);
				msg="New EMID generated for this patient.";
			}else{
				// emid already exist
				msg="This patient already have an EMID.";
			}
			
		}
	}
	public void setEmail(String email){
		pu.setEmail(email);
		saveEmid();
	}
	public String getEmail(){
		
		if(pu==null||pu.getEmail()==null||pu.getEmail().length()==0)
			return "<empty email>";
		else
			return pu.getEmail();
		
	}
	public String getAddress(){
		return (pu==null)?"":pu.getAddress();
	}
	public String getPassword(){
		return (pu==null)?"":pu.getPassword();
	}
	public long getEmid(){
		return (pu==null)?0:pu.getEMID();
	}
	public String getMsg(){
		return msg;
	}
	public PatientUser getPu(){
		return pu;
	}
//	public String getResult(){
//
//		if(getEmail()==null||pu.getEmail().length()==0){
//			return "<Empty Email>";
//		}else return getEmail()+"@@@@";
//	}
}
