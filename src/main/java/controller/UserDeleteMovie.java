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
@WebServlet("/userdeletemovie")
public class UserDeleteMovie extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	int userid = Integer.parseInt(req.getParameter("userid"));
    Dao dao=new Dao();
    try {
   	 HttpSession session=req.getSession();
   	 String username=(String)session.getAttribute("username");
   	 if(username!=null) {
		dao.deletepurchasedmovie(id);
		req.setAttribute("username",username);
		req.setAttribute("movies",dao.getAllMovies());
		req.setAttribute("userid",userid);
		RequestDispatcher rd=req.getRequestDispatcher("UserHome.jsp");
		rd.include(req, resp);
   	 }
   	 else {
   		 req.setAttribute("message","access denied...admin login requried...");
   		 RequestDispatcher rd=req.getRequestDispatcher("Ulogin.jsp");
   				 rd.include(req, resp);
   	 }
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
}
