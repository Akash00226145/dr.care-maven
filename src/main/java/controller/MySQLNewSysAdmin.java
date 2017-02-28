package controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.MySQLUser;
import model.PatientUser;
import dao.MySQLDAO;
import dao.PatientUserDAO;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/MySQLNewSysAdmin")
public class MySQLNewSysAdmin extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public  MySQLNewSysAdmin() {
      super();
     }
  
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		   throws ServletException, IOException {
		   
	   String name = request.getParameter("email");	   
	   String password = request.getParameter("password"); 
	   String address = request.getParameter("address");   
	   String email = request.getParameter("email");
	   System.out.println(email);		
	   System.out.println(password);
	   System.out.println(address);
	   System.out.println(email);
		
	  
	   try
	   {	   	
	   	// create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      //String myUrl = "jdbc:mysql://192.168.100.205/userdb";
		      String myUrl = "jdbc:mysql://34.250.167.112/UserDB";
		      Class.forName(myDriver);
		      //Connection conn = DriverManager.getConnection(myUrl, "Admin", "CZAta220696");
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "root");
		    	
	     // our SQL SELECT query. 
	     // if you only need a few columns, specify them by name instead of using "*"
	     String query = "SELECT table_name FROM information_schema.tables where table_schema='UserDB'";

	     // create the java statement
	     Statement st = (Statement) conn.createStatement();
	     
	     // execute the query, and get a java resultset
	     ResultSet rs = st.executeQuery(query);
	     
	     // iterate through the java resultset
	     System.out.println("------------");
	     while (rs.next())
	     {
	   	
	       String table_name = rs.getString("table_name");
	      	        
	       // print the results
	       
	       System.out.format("%s\n", table_name);
	     }
	     st.close();
	   }
	   catch (Exception e)
	   {
	     System.err.println("Got an exception! ");
	     System.err.println(e.getMessage());
	   }
	   System.out.println("------------");
	      
   {
     
	 
}
   
   MySQLUser user = new MySQLUser(email, password, address);
		
   MySQLDAO.instance.save(user);

 //return values.
	if (user != null)
	{
		System.out.println("Writting Sys Admin to DB");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("AddSysAdminSuccess.jsp").forward(request, response);
		System.out.println("Sys Admin Added!");
	} 
	else
	{
		request.getRequestDispatcher("AddSysAdminFailure.jsp").forward(request, response);
		System.out.println("Sys Admin writing failure");
	}
   }
   
}




