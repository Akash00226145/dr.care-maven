package test_drcare.dao;



import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.PharmacistDAO;
import junit.framework.TestCase;
import model.Pharmacist;

public class PharmacistDAOTest extends TestCase {
	
	
	@Test
	public void testMockDB() throws SQLException{
		
		Connection con = null;
		try {
			con = PharmacistDAO.getConnection();
			assertNotNull(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("No Exception expected .....");
			e.printStackTrace();
		}
	}
	@Test
		public void testSave() throws SQLException{
			
			PharmacistDAO a=PharmacistDAO.instance;
			Pharmacist phar=new Pharmacist("Rachel","asd","Athlone");
			try {
				
				assertNotNull(a.save(phar));
				
			} catch (Exception e) {
				// TODO: handle exception
				fail("No Exception expected .....");
				e.printStackTrace();
			}}
				
			@Test
			public void testLoginTrue() throws SQLException{
				
				PharmacistDAO a=PharmacistDAO.instance;
				
				try {
					
					assertNotNull(a.checkLogin("abc", "12345"));
					
				} catch (Exception e) {
					// TODO: handle exception
					fail("No Exception expected .....");
					e.printStackTrace();
				}	
	}
			@Test
			public void testLoginFalse() throws SQLException{
				
				PharmacistDAO a=PharmacistDAO.instance;
				
				try {
					
					assertNotNull(a.checkLogin("Emma", "23123"));
					
				} catch (Exception e) {
					// TODO: handle exception
					fail("No Exception expected .....");
					e.printStackTrace();
				}	
	}
			@Test
			public void testPatientList() throws SQLException{
				
				PharmacistDAO a=PharmacistDAO.instance;
				
				try {
					
					assertNotNull(a.list());
					
				} catch (Exception e) {
					// TODO: handle exception
					fail("No Exception expected .....");
					e.printStackTrace();
				}	
			}
				@Test
				public void testPrescription() throws SQLException{
					
					PharmacistDAO a=PharmacistDAO.instance;
					
					try {
						
						assertEquals(1,a.PrescriptionSave("as", "asd", 8));
						
					} catch (Exception e) {
						// TODO: handle exception
						fail("No Exception expected .....");
						e.printStackTrace();
					}	
	}
}
