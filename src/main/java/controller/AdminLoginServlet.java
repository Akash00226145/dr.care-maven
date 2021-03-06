package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminUser;
import dao.AdminUserDAO;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   
   /**
    * @see HttpServlet#HttpServlet()
    */
   public AdminLoginServlet() {
      super();
     
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	   
	   
     
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
     
	   String name = request.getParameter("email");
      String password = request.getParameter("password");
      AdminUser user = AdminUserDAO.checkLogin(name, password);
      if (user != null) {
    	  System.out.println("Yes password mached");
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
        // request.getRequestDispatcher("success.jsp").forward(request, response);
         response.sendRedirect("AdminAfterLogin?action=listUser");
      } else {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         System.out.println("not mached");
      }
   }

}
