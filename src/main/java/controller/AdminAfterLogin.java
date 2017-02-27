package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminUserDAO;
import dao.PharmacistDAO;
import model.GPuser;
import model.PatientUser;

/**
 * Servlet implementation class AdminAfterLogin
 */
public class AdminAfterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/gpedit.jsp";
	   private static String LIST_USER = "/success.jsp";
	   private AdminUserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAfterLogin() {
        super();
        dao = new AdminUserDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
	       String action = request.getParameter("action");

	       if (action.equalsIgnoreCase("delete")){
	           int gpId = Integer.parseInt(request.getParameter("gpId"));
	           dao.deleteGp(gpId);
	           forward = LIST_USER;
	           request.setAttribute("gps", dao.getAllGps());    
	       } else if (action.equalsIgnoreCase("edit")){
	           forward = INSERT_OR_EDIT;
	           int gpId = Integer.parseInt(request.getParameter("gpId"));
	           GPuser gp = dao.getGpById(gpId);
	           request.setAttribute("gps", gp);
	       } else if (action.equalsIgnoreCase("listUser")){
	           forward = LIST_USER;
	           List<GPuser> GPuserList = dao.getAllGps();
	           request.setAttribute("gps", GPuserList);
	       } else {
	           forward = INSERT_OR_EDIT;
	       }

	       RequestDispatcher view = request.getRequestDispatcher(forward);
	       view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GPuser user;
		int id = Integer.parseInt(request.getParameter("gpId"));
		System.out.println("id is  :" +id);
		String name = request.getParameter("gpusername");
		String email = request.getParameter("gpemail");
		String address = request.getParameter("gpaddress");
		int phone = Integer.parseInt(request.getParameter("gpphone"));
		String filename = request.getParameter("fileName");
		String hfilename = request.getParameter("hfileName");
		String password = request.getParameter("UUIDpassword");
		System.out.println("id is : "+id+" name is : "+name+"  Phone is : "+phone+ "File name : "+filename+"hiddden File name : "+hfilename);
		if(filename.equals(""))
		{
			user = new GPuser(id, name, email, address, phone, hfilename, password);
		}
		else
		{
			user = new GPuser(id, name, email, address, phone, filename, password);
		}
		
		 
		    dao.updategp(user);
	        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("gps", dao.getAllGps());
	        view.forward(request, response);
	        
		
	}

}
