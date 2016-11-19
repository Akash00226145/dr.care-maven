package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pharmacist;

public enum PharmacistDAO {
  instance;

  public Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/drcare", "root", "123456");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public void save(Pharmacist phar) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO Pharmacist (usename, password, address) VALUES (?, ?, ?)");
      psmt.setString(1, phar.getUsername());
      psmt.setString(2, phar.getPassword());
      psmt.setString(3, phar.getAddress());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Pharmacist checkLogin(String username, String password) {
    Connection connection = getConnection();
    Pharmacist phar = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM Pharmacist WHERE USENAME = ? AND PASSWORD = ?");
      psmt.setString(1, username);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
        phar = new Pharmacist(rs.getInt("id"), rs.getString("usename"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return phar ;
  }

}
