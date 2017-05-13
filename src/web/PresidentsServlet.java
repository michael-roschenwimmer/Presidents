package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.President;
import data.PresidentsDAO;
import data.PresidentsDaoImpl;

//@WebServlet("Presidents")
public class PresidentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Welcome.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean filtered = false;
		List<President> pres;
		PresidentsDAO president = new PresidentsDaoImpl(this.getServletContext());
		
		//req.setAttribute("presPic", pres.getPic());
		//"PresidentPics/44.jpg"
		
		if(!filtered){
			pres= president.loadPresidentsFromFile();
		} else{
			//Make this the filtered lists
			pres = new ArrayList<>();
		}
		
		int tracker = 0;
		req.setAttribute("tracker", tracker);
		req.setAttribute("pres", pres.get(tracker) );
		req.getRequestDispatcher("Presidents.jsp").forward(req, resp);
	}
	
	
	
}
