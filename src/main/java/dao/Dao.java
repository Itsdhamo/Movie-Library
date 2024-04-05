package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.QueryReturnType;

import controller.PurchasedMovies;
import dto.Admin;
import dto.Movie;
import dto.Purchase;
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
		PreparedStatement pst = conn.prepareStatement("insert into movies values(?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieid());
		pst.setString(2, movie.getMoviename());
		pst.setDouble(3, movie.getMovieprice());
		pst.setDouble(4, movie.getMovieratings());
		pst.setString(5, movie.getMoviegeneres());
		pst.setString(6, movie.getMovielanguage());
		Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(7, imageBlob);
		Blob imageBlob1 = new SerialBlob(movie.getMovieimage1());
		pst.setBlob(8, imageBlob1);
		Blob imageBlob2 = new SerialBlob(movie.getMovieimage2());
		pst.setBlob(9, imageBlob2);
		System.out.println(movie.getMoviename());
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
	
	public User findbyEmailForUser(String usermail) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from user where useremail=?");
		pst.setString(1, usermail);
		ResultSet rs = pst.executeQuery();
		rs.next();
		User user = new User();
		user.setUserid(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setUsercontact(rs.getLong(3));
		user.setUsermail(rs.getString(4));
		user.setUserpassword(rs.getString(5));
		return user;
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
			Blob b1 = res.getBlob(8);
			byte[] img1 = b1.getBytes(1, (int) b1.length());
			m.setMovieimage1(img1);
			Blob b2 = res.getBlob(9);
			byte[] img2 = b2.getBytes(1, (int) b2.length());
			m.setMovieimage2(img2);
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
		Blob b1 = res.getBlob(8);
		byte[] img1 = b1.getBytes(1, (int) b1.length());
		movie.setMovieimage1(img1);
		Blob b2 = res.getBlob(9);
		byte[] img2 = b2.getBytes(1, (int) b2.length());
		movie.setMovieimage2(img2);
		return movie;
	}

	public List<Movie> findMovieByid1(int movieid) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		List<Movie> l1=new ArrayList<Movie>();
		PreparedStatement pst = conn.prepareStatement("select * from movies where movieid=?");
		pst.setInt(1, movieid);
	    Movie movie=null;
		ResultSet res = pst.executeQuery();
		while(res.next())
		{
			movie = new Movie();
			movie.setMovieid(res.getInt(1));
			movie.setMoviename(res.getString(2));
			movie.setMovieprice(res.getDouble(3));
			movie.setMovieratings(res.getDouble(4));
			movie.setMoviegeneres(res.getString(5));
			movie.setMovielanguage(res.getString(6));
			Blob b = res.getBlob(7);
			byte[] img = b.getBytes(1, (int) b.length());
			movie.setMovieimage(img);
			Blob b1 = res.getBlob(8);
			byte[] img1 = b1.getBytes(1, (int) b1.length());
			movie.setMovieimage1(img1);
			Blob b2 = res.getBlob(9);
			byte[] img2 = b2.getBytes(1, (int) b2.length());
			movie.setMovieimage2(img2);
			l1.add(movie);
		}
		return l1;
	}

	public int updatemovie(Movie movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"update movies set moviename=?,movieprice=?,movieratings=?,moviegeneres=?,movielanguage=?,movieimage=?,movieimage1=?,movieimage2=? where movieid=?");

		pst.setString(1, movie.getMoviename());
		pst.setDouble(2, movie.getMovieprice());
		pst.setDouble(3, movie.getMovieratings());
		pst.setString(4, movie.getMoviegeneres());
		pst.setString(5, movie.getMovielanguage());
		Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(6, imageBlob);
		Blob imageBlob1 = new SerialBlob(movie.getMovieimage1());
		pst.setBlob(7, imageBlob1);
		Blob imageBlob2 = new SerialBlob(movie.getMovieimage2());
		pst.setBlob(8, imageBlob2);
		pst.setInt(9, movie.getMovieid());
		return pst.executeUpdate();
	}
	
	public int buymovie(int userid,int id) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into purchasedmovie values(?,?)");
		pst.setInt(1,userid);
		pst.setInt(2,id);
		return pst.executeUpdate();	
	}
	
	public List<Purchase> purchasedmovie(int userid) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		Purchase p1=null;
		List<Purchase> l1=new ArrayList<Purchase>();
		PreparedStatement pst=conn.prepareStatement("select movieid from purchasedmovie where userid=?");
		pst.setInt(1, userid);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			p1=new Purchase();
			p1.setPurchaseid(rs.getInt(1));
			l1.add(p1);
		}
		return l1;
	}
	
	public int deletepurchasedmovie(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from purchasedmovie where movieid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}

	public List<User> findbyEmailForUser1() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from user");
		List<User> l1=new ArrayList<User>();
		User user=null;
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
		user = new User();
		user.setUserid(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setUsercontact(rs.getLong(3));
		user.setUsermail(rs.getString(4));
		user.setUserpassword(rs.getString(5));
		l1.add(user);
		}
		return l1;
	}
	
   public int deleteuser(int id) throws SQLException, ClassNotFoundException {
	   Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from user where userid=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
   }
}