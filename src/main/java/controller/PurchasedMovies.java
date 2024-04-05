package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Movie;
import dto.Purchase;
@WebServlet("/PurchasedMovies")
public class PurchasedMovies extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int userid = Integer.parseInt(req.getParameter("userid"));
	Dao dao=new Dao();
	Purchase purchase=new Purchase();
	try {
	List<Purchase> movies=	dao.purchasedmovie(userid);
		for(Purchase purchase1:movies) 
		{
			List<Movie> movie = dao.findMovieByid1(purchase1.getPurchaseid());
			System.out.println(movie);
			req.setAttribute("movies",movie);
			req.setAttribute("userid",userid);
			RequestDispatcher rd=req.getRequestDispatcher("PurchasedMovies.jsp");
			rd.include(req, resp);
		}
		
	} catch (ClassNotFoundException | SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
