package test_drcare.dao;



import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.AdminUserDAO;
import junit.framework.TestCase;
import model.AdminUser;


public class AdminUserDAOTest extends TestCase {
	
	
	@Test
	public void testMockDB() throws SQLException{
		
		Connection con = null;
		try {
			con = AdminUserDAO.getConnection();
			assertNotNull(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("No Exception expected .....");
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCheckUser() throws SQLException {
		AdminUser user = null;
		 try {
			  user = AdminUserDAO.checkLogin("akash@ait.ie", "akash12345");
			  assertNotNull(user);
	          } catch (Exception e) {

	        	 assertSame("Invild value", e.getMessage());
	    
	 }
	 }

}
