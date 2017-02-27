package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.AdminUser;
import model.GPuser;

public class AdminUserDAO {

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

  public void save(AdminUser user) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO USER (email, password, address) VALUES (?, ?, ?)");
      psmt.setString(1, user.getEmail());
      psmt.setString(2, user.getPassword());
      psmt.setString(3, user.getAddress());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static AdminUser checkLogin(String email, String password) {
    Connection connection = getConnection();
    AdminUser user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        user = new AdminUser(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user ;
  }
  
  public List<GPuser> getAllGps() {
  	Connection connection = getConnection();
      List<GPuser> gps = new ArrayList<GPuser>();
      try {
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery("select * from GPR");
          while (rs.next()) {
        	  GPuser gPuser = new GPuser(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("address"),rs.getInt("phone"), rs.getString("filename"),rs.getString("password"));
             System.out.println(gPuser);
        	 gps.add(gPuser);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return gps;
  }
  
	  public void deleteGp(int userId) {
	  	Connection connection = getConnection();
	      try {
	          PreparedStatement preparedStatement = connection
	                  .prepareStatement("delete from GPR where id=?");
	          // Parameters start with 1
	          preparedStatement.setInt(1, userId);
	          preparedStatement.executeUpdate();
	
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  }
	  
	  public void updategp(GPuser gp) {
	    	Connection connection = getConnection();
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update GPR set name=?, email=?, address=?, phone=?, filename=?, password=?" +
	                            "where id=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, gp.getName());
	            preparedStatement.setString(2, gp.getEmail());
	            preparedStatement.setString(3, gp.getAddress());;
	            preparedStatement.setInt(4, gp.getPhone());
	            preparedStatement.setString(5,gp.getFileName());;
	            preparedStatement.setString(6, gp.getPassword());
	            preparedStatement.setInt(7, gp.getId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public GPuser getGpById(int userId) {
	    	Connection connection = getConnection();
	    	GPuser gPuser = null;
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from GPR where id=?");
	            preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	gPuser = new GPuser(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("address"),rs.getInt("phone"), rs.getString("filename"),rs.getString("password"));
	            	System.out.println("getGpById"+gPuser);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return gPuser;
	    }
	  

}
