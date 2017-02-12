package test_drcare.dao;

//import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;


import dao.MySQLDAO;
import junit.framework.TestCase;

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
			
		} catch (Exception e)
		{
			// TODO: handle exception
			fail("No Exception expected .....");
			e.printStackTrace();
		}		
		
	}

}