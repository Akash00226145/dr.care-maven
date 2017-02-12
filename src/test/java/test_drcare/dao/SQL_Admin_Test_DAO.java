package test_drcare.dao;

//import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.MySQLDAO;
import junit.framework.TestCase;
import model.MySQLUser;

public class SQL_Admin_Test_DAO extends TestCase 
{
		
	@Test
	public void testMockDB() throws SQLException
	{
		
		Connection con = null;
		try 
		{
			con = MySQLDAO.getConnection();
			assertNotNull(con);
			
		} 
			catch (Exception e)
		{
			fail("No Exception expected .....");
			e.printStackTrace();
		}			
	}
	
	@Test
	public void testCheckUser() throws SQLException

	{
		MySQLUser user = null;
		 try
		 {
			  user = MySQLDAO.checkLogin("czata1@gmail.com", "MSc2017");
			  assertNotNull(user);
	     } 
		 
		 catch (Exception e)
		 {
			 assertSame("Invild value", e.getMessage());
	    
	     }
	}	
}
