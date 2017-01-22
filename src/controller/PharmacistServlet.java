package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AdminUser;
import model.Pharmacist;
import model.PatientUser;
import dao.AdminUserDAO;
import dao.PharmacistDAO;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/PharmacistServlet")
public class PharmacistServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public PharmacistServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TOD
	   
	  
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
     
	   String username = request.getParameter("username");
       String password = request.getParameter("password");
       Pharmacist phar =PharmacistDAO.instance.checkLogin(username, password);
      if (phar != null) {
    	  System.out.println("Yes password mached");
         HttpSession session = request.getSession();
         session.setAttribute("phar", phar);
         request.getRequestDispatcher("PharmacistSuccess.jsp").forward(request, response);
      } else {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         System.out.println("not mached");
      }
   }
}
