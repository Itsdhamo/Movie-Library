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
@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class UpdateMovie extends HttpServlet {
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
		 if(imagepart.getSize()>0) {
			 movie.setMovieimage(imagepart.getInputStream().readAllBytes());
		dao.updatemovie(movie);
		req.setAttribute("movies", dao.getAllMovies());
		 RequestDispatcher rd1=req.getRequestDispatcher("Home.jsp");
		 rd1.include(req, resp);
		 }
		 else {
			 Movie dbmovie=dao.findMovieByid(movieid);
			 movie.setMovieimage(dbmovie.getMovieimage());
			 dao.updatemovie(movie);
			 
			 req.setAttribute("movies",dao.getAllMovies());
			 RequestDispatcher rd6=req.getRequestDispatcher("Home.jsp");
			 rd6.include(req, resp);	 
		 } 
		 if(imagepart1.getSize()>0) {	 
			 movie.setMovieimage(imagepart1.getInputStream().readAllBytes());
		dao.updatemovie(movie);
		req.setAttribute("movies", dao.getAllMovies());
		 RequestDispatcher rd2=req.getRequestDispatcher("Home.jsp");
		 rd2.include(req, resp);
		 }
		 else {
			 Movie dbmovie=dao.findMovieByid(movieid);
			 movie.setMovieimage1(dbmovie.getMovieimage1());
			 dao.updatemovie(movie);
			 
			 req.setAttribute("movies",dao.getAllMovies());
			 RequestDispatcher rd5=req.getRequestDispatcher("Home.jsp");
			 rd5.include(req, resp); 
		 }
		 if(imagepart2.getSize()>0) {
			 movie.setMovieimage(imagepart2.getInputStream().readAllBytes());
		dao.updatemovie(movie);
		req.setAttribute("movies", dao.getAllMovies());
		 RequestDispatcher rd3=req.getRequestDispatcher("Home.jsp");
		 rd3.include(req, resp);}
		 else {
			 Movie dbmovie=dao.findMovieByid(movieid);
			 movie.setMovieimage2(dbmovie.getMovieimage2());
			 dao.updatemovie(movie);
			 
			 req.setAttribute("movies",dao.getAllMovies());
			 RequestDispatcher rd4=req.getRequestDispatcher("Home.jsp");
			 rd4.include(req, resp); 
		 }
		  
		 
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 
}
}
