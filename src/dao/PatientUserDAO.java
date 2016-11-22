package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.PatientUser;

public enum PatientUserDAO {
  instance;

  public Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/userdb", "root", "3Jodie99");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public void save(PatientUser user) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO PATIENT (email, password, address) VALUES (?, ?, ?)");
      psmt.setString(1, user.getEmail());
      psmt.setString(2, user.getPassword());
      psmt.setString(3, user.getAddress());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public PatientUser checkLogin(String email, String password) {
    Connection connection = getConnection();
    PatientUser user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM PATIENT WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        user = new PatientUser(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user ;
  }

}