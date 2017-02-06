package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MySQLUser;
import dao.MySQLDAO;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/MySQLServlet")
public class MySQLServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public  MySQLServlet() {
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
     
	  String name = request.getParameter("email");
	  
	  //System.out.println(name);
      
	   
      String password = request.getParameter("password");
      
      //System.out.println(password);
      
      MySQLUser user = MySQLDAO.instance.checkLogin(name, password);
      
      
      if (user != null) {
    	  System.out.println("Yes password mached");
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
         request.getRequestDispatcher("success_SQL.jsp").forward(request, response);
      } else {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         System.out.println("SQL Admin not mached");
      }
   }

}
