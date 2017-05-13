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
	PresidentsDaoImpl president;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Welcome.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		boolean filtered = false;
		List<President> pres;
		if(req.getParameter("tracker").equals("null")){
		president.setTracker(Integer.parseInt(req.getParameter("tracker")));
		}
		int tracker = president.getTracker();
		System.out.println(req.getParameter("tracker") + " tracker value");
		
		//req.setAttribute("presPic", pres.getPic());
		//"PresidentPics/44.jpg"
		
		if(!filtered){
			pres= president.loadPresidentsFromFile(this.getServletContext());
		} else{
			//Make this the filtered lists
			pres = new ArrayList<>();
		}
		
		System.out.println(president.getTracker());
		req.setAttribute("presidents", pres);
		req.setAttribute("president", president);
		req.setAttribute("tracker", tracker);
		req.setAttribute("pres", pres.get(tracker) );
		req.getRequestDispatcher("Presidents.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		president = new PresidentsDaoImpl(this.getServletContext());
	}
	
	
	
}
