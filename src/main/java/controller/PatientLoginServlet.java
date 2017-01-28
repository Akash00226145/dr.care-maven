package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PatientUser;
import dao.PatientUserDAO;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/PatientLoginServlet")
public class PatientLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public PatientLoginServlet() {
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
      String password = request.getParameter("password");
      PatientUser user = PatientUserDAO.instance.checkLogin(name, password);
      if (user != null) {
    	 System.out.println("Yes password matched");
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
         request.getRequestDispatcher("PatientLoginSuccess.jsp").forward(request, response);
      } else {
         request.getRequestDispatcher("index.jsp").forward(request, response);
         System.out.println("not mached");
      }
   }
}