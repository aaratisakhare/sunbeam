package com.sunbeam.rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.rest.dao.ItemDao;
import com.sunbeam.rest.entities.Item;

//@WebServlet("/items")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		try(ItemDao dao = new ItemDao()){
			dao.open();
			List<Item> list = dao.findItemsOfCategory(req.getParameter("category"));
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Items</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form method='post' action='addcart'>");
			for (Item item : list) {
				out.println("<input type='checkbox' name='item' value='"+item.getId()+"'>"+item.getName()+"<br/>");				
			}
			out.println("<input type='submit' value='AddtoCart'/>");
			out.println("<a href='showcart'>Show Cart</a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
