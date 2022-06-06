package io.javabrains.moviecatalogservice.model;

public class ItemCatalog {

    public String movieName;

    public String movieDesc;

    public Integer ratings;

    public ItemCatalog(String movieName, String movieDesc, Integer ratings) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.ratings = ratings;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public Integer getRatings() {
        return ratings;
    }
}
