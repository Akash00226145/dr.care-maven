package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.GPuser;

public enum GPRegisterDAO {
  instance;

  public Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/UserDB", "root", "root");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public int saveGP(GPuser gpuser) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO GPR (name, email, address, phone, filename, password) VALUES (?,?,?,?,?,?)");
      psmt.setString(1, gpuser.getName());
      psmt.setString(2, gpuser.getEmail());
      psmt.setString(3, gpuser.getAddress());
      psmt.setInt(4, gpuser.getPhone());
      psmt.setString(5, gpuser.getFileName());
      psmt.setString(6, gpuser.getPassword());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return -1;
    }
    return 1;
  }

 public GPuser checkLogin(String email, String password) {
    Connection connection = getConnection();
    GPuser gpuser = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM GPR WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        gpuser = new GPuser(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("address"),
        						rs.getInt("phone"), rs.getString("password")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return gpuser ;
  }
  
 /* public int insertGP(String name, String email, String address, int phone, String password){
	  Connection connection = getConnection();
	  GPuser gpuser = null ;

	  try {
	      PreparedStatement psmt = connection.prepareStatement("INSERT INTO GP name, email, address, "
	        		  											+ "phone, password) "
	        		  											+ "VALUES (?,?,?,?,?)");

	      psmt.setString(1, (gpuser.getName()));
	      psmt.setString(2, (gpuser.getEmail()));
	      psmt.setString(3, (gpuser.getAddress()));
	      psmt.setString(4, Integer.toString(gpuser.getPhone()));
	      psmt.setString(5, (gpuser.getPassword()));
	  } catch (SQLException e) {
	      e.printStackTrace();
	      return -1;
	  }
	  return 1;
  }*/
}