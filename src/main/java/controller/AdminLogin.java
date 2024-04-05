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
import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import dao.Dao;
import dto.Admin;
@WebServlet("/Adminlogin")
public class AdminLogin  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String adminmail=req.getParameter("adminmail");
		 String adminpassword=req.getParameter("adminpassword");
		 
		 Dao dao=new Dao();
		 try {
			Admin admin=dao.findbyEmail(adminmail);
			if(admin!=null) {
				if(admin.getAdminpassword().equals(adminpassword)) {
					HttpSession session=req.getSession();
					session.setAttribute("adminname",admin.getAdminname());
					req.setAttribute("adminname",admin.getAdminname());
					req.setAttribute("movies",dao.getAllMovies());
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("message","Wrong Password");
					RequestDispatcher rd=req.getRequestDispatcher("Alogin.jsp");
					rd.include(req, resp);
				}
	 
	}
	else {
		req.setAttribute("message1","email is wrong...");
		RequestDispatcher rd=req.getRequestDispatcher("Alogin.jsp");
				rd.include(req, resp);
	}
			
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
