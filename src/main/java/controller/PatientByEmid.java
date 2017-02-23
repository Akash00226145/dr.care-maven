package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PharmacistDAO;
import model.PatientUser;

@WebServlet("/PatientByEmid")
/**
 * Servlet implementation class PatientByEmid
 */
public class PatientByEmid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientByEmid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<PatientUser> PatientList = PharmacistDAO.instance.list();

	    request.setAttribute("PatientList",PatientList);
	    long emid=0;
         try{
		   emid= Long.parseLong(request.getParameter("emid"));
         }catch(Exception e){
        	 
        	 e.printStackTrace();
         }
	   
	      PatientUser user = PharmacistDAO.instance.getPatient(emid);
	     
	      if(user != null) {
	    	  System.out.println("it exist");
	    	  String message="Patient is exist";
	    	  request.setAttribute("patient",user);
	    	  request.setAttribute("message",message);
	          request.getRequestDispatcher("PharmacistSuccess.jsp").forward(request, response);
	         
	      } else {
	         
	         String message="Patient is not exist";
	         request.setAttribute("message",message);
	         request.getRequestDispatcher("PharmacistSuccess.jsp").forward(request, response);
	         
	}

}
}