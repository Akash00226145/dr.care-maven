package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.GPuser;

public enum GploginDAO {
  instance;

  public Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/gplog", "root", "123456");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public GPuser checkLogin(String email, String password) {
    Connection connection = getConnection();
    GPuser user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM gplogin WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        user = new GPuser(rs.getInt("id"), rs.getString("email"), rs.getString("name"), rs.getString("password"), rs.getString("address")) ;

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user ;
  }

}
