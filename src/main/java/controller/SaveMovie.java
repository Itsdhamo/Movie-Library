package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;
@WebServlet("/savemovie")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class SaveMovie extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int movieid=Integer.parseInt(req.getParameter("movieid"));
	 String moviename=req.getParameter("moviename");
	 double movieprice=Double.parseDouble(req.getParameter("movieprice"));
	 double movieratings=Double.parseDouble(req.getParameter("movierating"));
	 String moviegeneres=req.getParameter("moviegeneres");
	 String movielanguage=req.getParameter("movielanguage");
	 Part imagepart=req.getPart("movieimage");
	 Part imagepart1=req.getPart("movieimage1");
	 Part imagepart2=req.getPart("movieimage2");		 
	 
	 Movie movie=new Movie();
	 movie.setMovieid(movieid);
	 movie.setMoviename(moviename);
	 movie.setMovieprice(movieprice);
	 movie.setMovieratings(movieratings);
	 movie.setMoviegeneres(moviegeneres);
	 movie.setMovielanguage(movielanguage);
	 movie.setMovieimage(imagepart.getInputStream().readAllBytes());
	 movie.setMovieimage1(imagepart1.getInputStream().readAllBytes());
	 movie.setMovieimage2(imagepart2.getInputStream().readAllBytes());
	 
	 Dao dao=new Dao();
	 try {
		dao.saveMovie(movie);
		req.setAttribute("movies", dao.getAllMovies());
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.include(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
