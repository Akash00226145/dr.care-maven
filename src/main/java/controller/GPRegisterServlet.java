package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.GPuser;
import dao.GPRegisterDAO;


/*
 * Created by Eoghan on 02.02.17.
 */

@WebServlet("/GPRegisterServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*1, 	// 1 MB 
					maxFileSize=1024*1024*2,
					 maxRequestSize=1024*1024*2)      	// 2 MB 
public class GPRegisterServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
    
    private String fileName;
    
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "upload";
    

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
     //----------------------------------------------------------------------------
	// gets absolute path of the web application
       String applicationPath = request.getServletContext().getRealPath("");
       
       System.out.println("applicationPath : "+applicationPath);
       // constructs path of the directory to save uploaded file
       String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        
       // creates the save directory if it does not exists
       File fileSaveDir = new File(uploadFilePath);
       if (!fileSaveDir.exists()) {
           fileSaveDir.mkdirs();
       }
       System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
       
       //Get all the parts from request and write it to the file on server
       for (Part part : request.getParts()) {
    	   if(part.getName().equals("fileName"))
    	   {
    		   fileName = getFileName(part);
               part.write(uploadFilePath + File.separator + fileName);
               System.out.println("File name is:"+fileName);
    	   }
           /*String fileName = getFileName(part);
           part.write(uploadFilePath + File.separator + fileName);
           System.out.println("File name is:"+fileName);*/
          // request.setAttribute("TextValue",fileName);
       }
	 //---------------------------------------------------------------------------- 
	  String name = request.getParameter("gpusername");
	  String email = request.getParameter("gpemail");
	  String address = request.getParameter("gpaddress");
	  int phone = Integer.parseInt(request.getParameter("gpphone"));
      String password = request.getParameter("UUIDpassword");
      GPuser gpUser = new GPuser(name,email,address,phone,fileName,password);
      
      GPRegisterDAO.instance.saveGP(gpUser);
	 
      //return values.
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
   
   /**
    * Utility method to get file name from HTTP header content-disposition
    */
   private String getFileName(Part part) {
       String contentDisp = part.getHeader("content-disposition");
       System.out.println("content-disposition header= "+contentDisp);
       String[] tokens = contentDisp.split(";");
       for (String token : tokens) {
           if (token.trim().startsWith("filename")) {
               return token.substring(token.indexOf("=") + 2, token.length()-1);
           }
       }
       return "";
   }
}