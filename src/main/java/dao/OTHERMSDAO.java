package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.OthermsUser;

public enum OTHERMSDAO {
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



  public static OthermsUser checkLogin(String username, String password) {
    Connection connection = getConnection();
    OthermsUser user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM otherms WHERE OMS_USERNAME = ? AND OMS_PASSWORD = ?");
      psmt.setString(1, username);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        user = new OthermsUser(rs.getInt("ID"), rs.getString("OMS_USERNAME"), rs.getString("OMS_PASSWORD"), rs.getString("OMS_ADDRESS")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user ;
  }

}
