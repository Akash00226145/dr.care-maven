package test_drcare.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.OTHERMSDAO;
import model.OthermsUser;

public class OthermedicalstaffTest {

	@Test
	public void testMockDB() throws SQLException{
		
		Connection con = null;
		try {
			con = OTHERMSDAO.getConnection();
			assertNotNull(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("No Exception expected .....");
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testCheckUser() throws SQLException {
		OthermsUser user = null;
		 try {
			  user = OTHERMSDAO.checkLogin("abc", "12345");
			  assertNotNull(user);
	          } catch (Exception e) {

	        	 assertSame("Invild value", e.getMessage());
	    
	 }
	 }
}
