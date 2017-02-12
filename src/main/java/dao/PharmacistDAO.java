package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pharmacist;
import model.PatientUser;
public enum PharmacistDAO {
  instance;

  public static Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
    		  "jdbc:mysql://34.250.167.112:3306/UserDB", "root", "root");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public Pharmacist save(Pharmacist phar) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO Pharmacist (username, password, address) VALUES (?, ?, ?)");
      psmt.setString(1, phar.getUsername());
      psmt.setString(2, phar.getPassword());
      psmt.setString(3, phar.getAddress());

      psmt.executeUpdate();
      ResultSet rs = psmt.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      phar.setId(id);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return phar;
  }
  
  public int PrescriptionSave(String method,String medicine,int id) {
	    Connection connection = getConnection();

	    try {
	      PreparedStatement psmt = connection
	          .prepareStatement("INSERT INTO prescription (method, medicine, p_id) VALUES (?, ?, ?)",
	        	        Statement.RETURN_GENERATED_KEYS);
	      psmt.setString(1, method);
	      psmt.setString(2, medicine);
	      psmt.setInt(3, id);

	      psmt.executeUpdate();
	      ResultSet rs = psmt.getGeneratedKeys();
	      rs.next();
	     
	     
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      	    }
	   return 1;
	  }
	    
	  
  public Pharmacist checkLogin(String username, String password) {
    Connection connection = getConnection();
    Pharmacist phar = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM pharmacist WHERE USERNAME = ? AND PASSWORD = ?");
      psmt.setString(1, username);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        phar = new Pharmacist(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return phar ;
  }
  public List<PatientUser> list() {
	    Connection connection = getConnection();
	    List<PatientUser>  PatientUser= new ArrayList<PatientUser>();
   
	    try {
	      PreparedStatement psmt = connection
	          .prepareStatement("SELECT * FROM patient");
	     
	      ResultSet rs = psmt.executeQuery();
	      while (rs.next()) {
	    	  PatientUser p = new PatientUser(rs.getInt("id"), rs.getString("email"), rs.getString("password")) ;
	    	  PatientUser.add(p);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return PatientUser;
	  }


}
