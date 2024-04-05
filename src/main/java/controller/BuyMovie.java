package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.Dao;
import dto.Movie;
import dto.Purchase;
import dto.User;

@WebServlet("/buymovie")
public class BuyMovie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieid = Integer.parseInt(req.getParameter("id"));
		int userid = Integer.parseInt(req.getParameter("userid"));
		Dao dao = new Dao();
		try {
			HttpSession session = req.getSession();
			String username = (String) session.getAttribute("username");
			if (username != null) {
				List<Purchase> movies = dao.purchasedmovie(userid);
				if (!movies.isEmpty()) {
					for (Purchase purchase : movies) {
						if (purchase.getPurchaseid() == movieid) {
							Movie m = dao.findMovieByid(movieid);
							req.setAttribute("movies", m);
							req.setAttribute("userid", userid);
							req.setAttribute("message", "Already Purchased...");
							RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
							rd.include(req, resp);
						}
						else if(purchase.getPurchaseid()!=movieid){
							dao.buymovie(userid, movieid);
							Movie m = dao.findMovieByid(movieid);
							req.setAttribute("movies", m);
							req.setAttribute("userid", userid);
							req.setAttribute("message", "Purchased...Enjoy Your Movie...");
							RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
							rd.include(req, resp);
						}
						}
					}
				 else {
					dao.buymovie(userid, movieid);
					Movie m = dao.findMovieByid(movieid);
					req.setAttribute("movies", m);
					req.setAttribute("userid", userid);
					req.setAttribute("message", "Purchased...Enjoy Your Movie...");
					RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
					rd.include(req, resp);
				}

			
			}
//			List<Purchase> movies = dao.purchasedmovie(userid);
//			for (Purchase purchase1 : movies) {
//				if (movieid != purchase1.getPurchaseid()) {
//					dao.buymovie(userid, movieid);
//					//User user = new User();
//					HttpSession session = req.getSession();
//					String username = (String) session.getAttribute("username");
//					if (username != null) {
//						Movie m = dao.findMovieByid(movieid);
//						req.setAttribute("movies", m);
//						req.setAttribute("userid", userid);
//						req.setAttribute("message", "Purchased...Enjoy Your Movie...");
//						RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
//						rd.include(req, resp);
//					}
//				} else {
//					Movie m = dao.findMovieByid(movieid);
//					req.setAttribute("movies", m);
//					req.setAttribute("userid", userid);
//					req.setAttribute("message", "Already Purchased...");
//					RequestDispatcher rd = req.getRequestDispatcher("buymovie.jsp");
//					rd.include(req, resp);
//				}
			// }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}