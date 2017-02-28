package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MySQLUser;

public enum MySQLDAO {	
	 instance;		
		static String x ;		
		public static String getIP()		
		{
			 try
			 {				  
				 BufferedReader br = new BufferedReader(new FileReader("sql_ip.txt"));
			     try 
			     {			          
			    	 while ( (x = br.readLine()) != null ) 
			         {
			    		 br.close();
			    		 return x;			        	  
			         }
			     }
			      catch (IOException e) {
			          e.printStackTrace();
			      }
			  }
			  catch (FileNotFoundException e) {
			      System.out.println(e);
			      e.printStackTrace();
			  }			  
			  return x;			
		}	
				
		 public static Connection getConnection() 
		 
		 {
			  
			 Connection connection = null;	
			 try 
			 	{			    	
				 	Class.forName("com.mysql.jdbc.Driver");			      
				 	//connection = DriverManager.getConnection("jdbc:mysql://"+(getIP())+"/doctors_care_database_test", "DrCare_Admin", "MSc_2017");
				 	connection = DriverManager.getConnection("jdbc:mysql://"+(getIP())+"/UserDB", "root", "root");
			    } 
			    catch (Exception e)
			    {
			    	e.printStackTrace();
			    }
		    return connection;
		  }
		
		 


public void save(MySQLUser user) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("INSERT INTO USER (email, password, address) VALUES (?,?,?)");
      psmt.setString(1, user.getEmail());
      psmt.setString(2, user.getPassword());
      psmt.setString(3, user.getAddress());

      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

public void delete(MySQLUser user) {
    Connection connection = getConnection();

    try {
      PreparedStatement psmt = connection
          .prepareStatement("DELETE FROM USER WHERE email = ?");
      psmt.setString(1, user.getEmail());
      psmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



public static MySQLUser checkLogin(String email, String password) {
    Connection connection = getConnection();
    MySQLUser SQL_user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM SQLuser WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
    	  SQL_user = new MySQLUser(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return SQL_user ;
  }

public static MySQLUser insertSysAdmin(String email, String password) {
    Connection connection = getConnection();
    MySQLUser SQL_user = null ;

    try {
      PreparedStatement psmt = connection
          .prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
      psmt.setString(1, email);
      psmt.setString(2, password);
      ResultSet rs = psmt.executeQuery();
      if (rs.next()) {
    	  SQL_user = new MySQLUser(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("address")) ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return SQL_user ;
  }
}

