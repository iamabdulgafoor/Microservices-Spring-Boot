package io.javabrains.moviecatalogservice.model;

public class Movie {

    public Long movieId;
    public String movieName;

    public String movieDesc;

    public Movie(){
    }

    public Movie(Long movieId, String movieName, String movieDesc) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                '}';
    }

}
