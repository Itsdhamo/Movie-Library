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
import dto.Admin;
import dto.User;

@WebServlet("/Userlogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usermail = req.getParameter("usermail");
		String userpassword = req.getParameter("userpassword");

		Dao dao = new Dao();
		try {
			User user = dao.findbyEmailForUser(usermail);
			if (user != null) {
				if (user.getUserpassword().equals(userpassword)) {
					HttpSession session = req.getSession();
					req.setAttribute("userid",user.getUserid());
					session.setAttribute("username", user.getUsername());
					req.setAttribute("username",user.getUsername());
					req.setAttribute("movies", dao.getAllMovies());
					RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
					rd.include(req, resp);
				} else {
					req.setAttribute("message", "password is wrong...");
					RequestDispatcher rd = req.getRequestDispatcher("Ulogin.jsp");
					rd.include(req, resp);
				}

			 } else {
				req.setAttribute("message1", "email is wrong...");
				RequestDispatcher rd = req.getRequestDispatcher("Ulogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
