package io.javabrains.movieratingservice.model;

public class Rating {

    public Integer movieId;
    public Integer rating;

    public Rating(Integer movieId, Integer rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId='" + movieId + '\'' +
                ", rating=" + rating +
                '}';
    }
}
