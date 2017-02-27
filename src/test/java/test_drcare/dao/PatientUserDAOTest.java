package test_drcare.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.PatientUserDAO;
import junit.framework.TestCase;
import model.PatientUser;


public class PatientUserDAOTest extends TestCase {
	
	
	@Test
	public void testMockDB() throws SQLException{
		
		Connection con = null;
		try {
			con = PatientUserDAO.getConnection();
			assertNotNull(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("No Exception expected .....");
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCheckUser() throws SQLException {
		PatientUser user = null;
		 try {
			  user = PatientUserDAO.checkLogin("e@g.c", "123");
			  assertNotNull(user);
	          } catch (Exception e) {

	        	 assertSame("Invild value", e.getMessage());
	    
	          }
	}

}
