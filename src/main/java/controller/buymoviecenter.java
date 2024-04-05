package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao;
import dto.Movie;
import dto.User;
@WebServlet("/buymoviecenter")
public class buymoviecenter extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int movieid = Integer.parseInt(req.getParameter("id"));
	int userid = Integer.parseInt(req.getParameter("userid"));
	Dao dao = new Dao();
	try {
		User user=new User();
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			Movie m = dao.findMovieByid(movieid);
			req.setAttribute("movies",m);
	        req.setAttribute("userid",userid);
	    RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
	    	rd.include(req, resp);
}
		}
	 catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			}
	}
}
