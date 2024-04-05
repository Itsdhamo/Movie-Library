package dto;

import java.util.Arrays;

public class Movie {
private int movieid;
private String moviename;
private double movieprice;
private double movieratings;
private String moviegeneres;
private String movielanguage;
private byte[] movieimage;
private byte[] movieimage1;
private byte[] movieimage2;
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
public byte[] getMovieimage1() {
	return movieimage1;
}
public void setMovieimage1(byte[] movieimage1) {
	this.movieimage1 = movieimage1;
}
public byte[] getMovieimage2() {
	return movieimage2;
}
public void setMovieimage2(byte[] movieimage2) {
	this.movieimage2 = movieimage2;
}
@Override
public String toString() {
	return "Movie [movieid=" + movieid + ", moviename=" + moviename + ", movieprice=" + movieprice + ", movieratings="
			+ movieratings + ", moviegeneres=" + moviegeneres + ", movielanguage=" + movielanguage + ", movieimage="
			+ Arrays.toString(movieimage) + "]";
}

}
