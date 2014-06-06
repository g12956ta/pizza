package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {
	    resp.setContentType("text/plain");
	    resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    String pass = req.getParameter("pass");
	    //PersistenceManagerFactory factory = PMF.get();
	    //PersistenceManager manager = factory.getPersistenceManager();
	    /*try {
	       // manager.makePersistent(data);
	    } finally {
	        manager.close();
	    }
	    */
	    if(pass.equals("123")) {
	    resp.sendRedirect("/index3.html");
	    }
	    else {
	    	resp.sendRedirect("/index.html");
	    	
	    }
	}

	
}
