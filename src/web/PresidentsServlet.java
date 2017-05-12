package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.PresidentsDaoImpl;

//@WebServlet("Presidents")
public class PresidentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Welcome.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PresidentsDao pres = new PresidentsDaoImpl(this.getServletContext());
//		
//		req.setAttribute("presPic", arg1);
		req.getRequestDispatcher("Presidents.jsp").forward(req, resp);
	}
	
	
	
}
