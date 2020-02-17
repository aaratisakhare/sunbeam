package com.sunbeam.rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.rest.dao.ItemDao;

//@WebServlet("/categories")
public class CatagoriesServlet extends HttpServlet{

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
		try(ItemDao dao = new ItemDao()){
			dao.open();
			List<String> list = dao.findAllCatagorie();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Failed</title>");
			out.println("</head>");
			out.println("<body>");
			String name = "";
			Cookie[] cookies = req.getCookies();
			if(cookies!=null) {
				for(Cookie cookie:cookies) {
					
				}
			}
			out.println("<form method='post' action='items'>");
			for (String category : list) {
				out.println("<input type='radio' name='category' value='"+category+"'>"+category+"<br/>");				
			}
			out.println("<input type='submit' value='Show Items'/>");
			out.println("<a href='#'>Show Cart</a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
