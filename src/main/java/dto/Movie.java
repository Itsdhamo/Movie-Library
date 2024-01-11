package dto;

public class Movie {
private int movieid;
private String moviename;
private double movieprice;
private double movieratings;
private String moviegeneres;
private String movielanguage;
private byte[] movieimage;
public int getMovieid() {
	return movieid;
}
public void setMovieid(int movieid) {
	this.movieid = movieid;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}
public double getMovieprice() {
	return movieprice;
}
public void setMovieprice(double movieprice) {
	this.movieprice = movieprice;
}
public double getMovieratings() {
	return movieratings;
}
public void setMovieratings(double movieratings) {
	this.movieratings = movieratings;
}
public String getMoviegeneres() {
	return moviegeneres;
}
public void setMoviegeneres(String moviegeneres) {
	this.moviegeneres = moviegeneres;
}
public String getMovielanguage() {
	return movielanguage;
}
public void setMovielanguage(String movielanguage) {
	this.movielanguage = movielanguage;
}
public byte[] getMovieimage() {
	return movieimage;
}
public void setMovieimage(byte[] movieimage) {
	this.movieimage = movieimage;
}

}
