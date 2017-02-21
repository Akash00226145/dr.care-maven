package test_drcare.dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.PharmacistDAO;
import junit.framework.TestCase;
import model.PatientUser;
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
	/*
	
	@Test
		public void testSave() throws SQLException{
			
		
			Pharmacist phar=new Pharmacist("Rachel","asd","Athlone");
			
			 try {
				  phar = PharmacistDAO.instance.save(phar);
				  assertNotNull(phar);
		          } catch (Exception e) {

		        	 assertSame("Invild value", e.getMessage());
		    
		 }
			
	}*/
			
			@Test
			public void testLoginTrue() throws SQLException{
				
				Pharmacist phar=null;
				
				try {
					
					phar=PharmacistDAO.instance.checkLogin("abc", "12345");
					  assertNotNull(phar);
					
				} catch (Exception e) {
					// TODO: handle exception
					fail("No Exception expected .....");
					e.printStackTrace();
				}	
	}
			/*
		@Test
			public void testLoginFalse() throws SQLException{
				
			Pharmacist phar=null;
			
			try {
				
				phar=PharmacistDAO.instance.checkLogin("abc", "345");
				  assertNotNull(phar);
				
			} catch (Exception e) {
				// TODO: handle exception
				fail("No Exception expected .....");
				e.printStackTrace();
			}	
	}*/
			@Test
			public void testPatientList() throws SQLException{
				
				
				try {
					PharmacistDAO a=PharmacistDAO.instance;
					List<PatientUser> list=a.list();
					assertNotNull(list);
					
				} catch (Exception e) {
					// TODO: handle exception
					fail("No Exception expected .....");
					e.printStackTrace();
				}	
			}
	
			@Test
				public void testPrescription() throws SQLException{
					
					PharmacistDAO a=PharmacistDAO.instance;
					int b=a.PrescriptionSave("as", "asd", 8);
					try {
						
						assertEquals(1,b);
						
					} catch (Exception e) {
						// TODO: handle exception
						fail("No Exception expected .....");
						e.printStackTrace();
					}	
	}
}
