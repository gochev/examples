package org.gochev;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeCycleExample
 */
@WebServlet("/ServletLifeCycleExample")
public class ServletLifeCycleExample extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext().log("init() called");
    }
 
    @Override
    protected void service(HttpServletRequest request, 
                        HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().log("service() called");
        response.getWriter().write("Hello world !");
    }
 
    @Override
    public void destroy() {
        getServletContext().log("destroy() called");
    }
 

}
