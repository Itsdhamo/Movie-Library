package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin;
import dto.Movie;
import dto.User;

public class Dao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movieslibraries", "root", "root");
	}

	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminmail());
		pst.setString(5, admin.getAdminpassword());

		return pst.executeUpdate();
	}

	public int saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into user values(?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2,  user.getUsername());
		pst.setLong(3,  user.getUsercontact());
		pst.setString(4,  user.getUsermail());
		pst.setString(5,  user.getUserpassword());

		return pst.executeUpdate();
	}

	public int saveMovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into movies values(?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieid());
		pst.setString(2, movie.getMoviename());
		pst.setDouble(3, movie.getMovieprice());
		pst.setDouble(4, movie.getMovieratings());
		pst.setString(5, movie.getMoviegeneres());
		pst.setString(6, movie.getMovielanguage());
		Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(7, imageBlob);
		return pst.executeUpdate();

	}

	public Admin findbyEmail(String adminmail) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from admin where adminemail=?");
		pst.setString(1, adminmail);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Admin admin = new Admin();
		admin.setAdminid(rs.getInt(1));
		admin.setAdminname(rs.getString(2));
		admin.setAdmincontact(rs.getLong(3));
		admin.setAdminmail(rs.getString(4));
		admin.setAdminpassword(rs.getString(5));
		return admin;

	}

	public List<Movie> getAllMovies() throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from movies");
		ResultSet res = pst.executeQuery();
		List<Movie> movies = new ArrayList<Movie>();
		while (res.next()) {
			Movie m = new Movie();
			m.setMovieid(res.getInt(1));
			m.setMoviename(res.getString(2));
			m.setMovieprice(res.getDouble(3));
			m.setMovieratings(res.getDouble(4));
			m.setMoviegeneres(res.getString(5));
			m.setMovielanguage(res.getString(6));
			Blob b = res.getBlob(7);
			byte[] img = b.getBytes(1, (int) b.length());
			m.setMovieimage(img);
			movies.add(m);
		}
		return movies;
	}

	public int deletemovie(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from movies where movieid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}

	public Movie findMovieByid(int movieid) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from movies where movieid=?");
		pst.setInt(1, movieid);
		ResultSet res = pst.executeQuery();
		res.next();
		Movie movie = new Movie();
		movie.setMovieid(res.getInt(1));
		movie.setMoviename(res.getString(2));
		movie.setMovieprice(res.getDouble(3));
		movie.setMovieratings(res.getDouble(4));
		movie.setMoviegeneres(res.getString(5));
		movie.setMovielanguage(res.getString(6));
		Blob b = res.getBlob(7);
		byte[] img = b.getBytes(1, (int) b.length());
		movie.setMovieimage(img);
		return movie;

	}

	public int updatemovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"update movies set moviename=?,movieprice=?,movieratings=?,moviegeneres=?,movielanguage=?,movieimage=? where movieid=?");

		pst.setString(1, movie.getMoviename());
		pst.setDouble(2, movie.getMovieprice());
		pst.setDouble(3, movie.getMovieratings());
		pst.setString(4, movie.getMoviegeneres());
		pst.setString(5, movie.getMovielanguage());
		Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(6, imageBlob);
		pst.setInt(7, movie.getMovieid());
		return pst.executeUpdate();

	}

}