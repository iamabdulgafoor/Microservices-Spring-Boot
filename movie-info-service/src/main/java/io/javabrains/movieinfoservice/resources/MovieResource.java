package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.model.Movie;
import io.javabrains.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String api_key;

    /*    @RequestMapping("/{userId}")
        public List<Movie> getMovieInfo(@PathVariable("userId") String userId){

       return Arrays.asList(
                new Movie(100L, "DDLG","SRK Movie"),
               new Movie(200L,"PK","Aamir Movie")
        );
    }*/

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Long movieId){
        String URI = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key="+api_key;
        System.out.println("URL: "+URI);
        MovieSummary movieSummary = restTemplate.getForObject(URI, MovieSummary.class);
        return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
    }
}
