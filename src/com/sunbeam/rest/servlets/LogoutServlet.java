package com.sunbeam.rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.rest.dao.CartDao;
import com.sunbeam.rest.dao.ItemDao;
import com.sunbeam.rest.entities.Item;

//@WebServlet("/showcart")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		PrintWriter out;
		try {
			out = resp.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Thank you!");
		
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
