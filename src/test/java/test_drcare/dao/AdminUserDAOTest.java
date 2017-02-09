package test_drcare.dao;



import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.AdminUserDAO;
import junit.framework.TestCase;


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

}
