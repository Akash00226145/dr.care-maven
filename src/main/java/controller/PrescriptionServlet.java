package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PharmacistDAO;
import model.Pharmacist;

/**
 * Servlet implementation class PrescriptionServlet
 */
public class PrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionServlet() {
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
		   String medicine = request.getParameter("medicine");
	       String method = request.getParameter("method");
	       String video = request.getParameter("video");
	       video=video.substring(32);
	       HttpSession session = request.getSession();
	       int p_id=(Integer) session.getAttribute("p_id");
	       PharmacistDAO.instance.PrescriptionSave(medicine, method,video, p_id);
	       System.out.print(method);
	       System.out.print(medicine);
	       System.out.print(video);
	       System.out.print(p_id);
	       request.getRequestDispatcher("index.jsp").forward(request, response);
	    
	}

}
