package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PatientUserDAO;
import dao.PharmacistDAO;
import model.PatientUser;

/**
 * Servlet implementation class PatientListServlet
 */
@WebServlet("/PatientListServlet")
public class PatientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String p_id = request.getParameter("id");
	    HttpSession session = request.getSession();
	    session.setAttribute("p_id",Integer.parseInt(p_id));
	    request.getRequestDispatcher("Prescription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		// String phone = request.getParameter(Integer.toString(phone));
		String password = request.getParameter("password");
		PatientUser patient = new PatientUser(email, address, password);

		PatientUserDAO.instance.save(patient);

		// return values.
		if (patient != null) {
			System.out.println("Writting Patient to DB");
			HttpSession session = request.getSession();
			session.setAttribute("user", patient);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PatientRegister.jsp").forward(request, response);
			System.out.println("Could not create this Patient");
		}
	}

}
