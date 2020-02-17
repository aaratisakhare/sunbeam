package com.sunbeam.rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.rest.dao.CustomerDao;
import com.sunbeam.rest.entities.Customer;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processReq(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processReq(request,response);
	}
	protected void processReq(HttpServletRequest request, HttpServletResponse response) {
		String inEmail = request.getParameter("email");
		String inPassword = request.getParameter("password");
		try (CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = dao.findCustomerByEmail(inEmail);
			if(cust!=null && cust.getPassword().equals(inPassword)) {
				Cookie c = new Cookie("uname", cust.getName());
				c.setMaxAge(3600);
				response.addCookie(c);
				
				HttpSession session = request.getSession();
				List cart = new ArrayList<Integer>();
				session.setAttribute("cart", cart);
				
				response.sendRedirect("categories");
			}else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<p>Invalid email or password.</p>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
