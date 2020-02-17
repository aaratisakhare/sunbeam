package com.sunbeam.rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.rest.dao.CartDao;
import com.sunbeam.rest.dao.ItemDao;
import com.sunbeam.rest.entities.Item;

//@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{

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
		HttpSession session = req.getSession();
		List<Integer> cart = (List<Integer>)session.getAttribute("cart");
		
		
		String[] itemIds = req.getParameterValues("item");
		for(String itemId:itemIds) {
			int id = Integer.parseInt(itemId);
			//todo save ids
			//cart.add(itemId);
		}
		try {
		RequestDispatcher rd = req.getRequestDispatcher("/categories");
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
