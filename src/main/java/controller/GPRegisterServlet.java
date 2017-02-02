package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import model.GPuser;
import dao.GPRegisterDAO;


/*
 * Created by Eoghan on 02.02.17.
 */

@WebServlet("/GPRegisterServlet")
public class GPRegisterServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public GPRegisterServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
     
	  String name = request.getParameter("name");
	  String email = request.getParameter("email");
	  String address = request.getParameter("address");
	 // String phone = request.getParameter(Integer.toString(phone));
      String password = request.getParameter("password");
      GPuser gpUser = new GPuser(name,email,address,password);
      
      GPRegisterDAO.instance.saveGP(gpUser);
	  if (gpUser != null) {
		  System.out.println("Writting GP to DB");
		  HttpSession session = request.getSession();
		  session.setAttribute("user", gpUser);
		  request.getRequestDispatcher("success.jsp").forward(request, response);
	  }else{
		  request.getRequestDispatcher("GPRegister.jsp").forward(request, response);
		  System.out.println("Could not create this GP");
	  }  
   }
}