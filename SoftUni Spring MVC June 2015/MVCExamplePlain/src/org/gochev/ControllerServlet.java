package org.gochev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        LoginBean bean=new LoginBean();  
	        bean.setName(name);  
	        bean.setPassword(password);  
	        
	        request.setAttribute("bean", bean);  
	          
			boolean status = bean.validate();

	        if(status){  
	            RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");  
	            rd.forward(request, response);  
	        }  
	        else{  
	            RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");  
	            rd.forward(request, response);  
	        }  
	      
	    }  
	  
	 	//this was common in the old days
	    @Override  
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
	            throws ServletException, IOException {  
	        doPost(req, resp);  
	    }  

}
