package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.model.ItemCatalog;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<ItemCatalog> getCatalog(@PathVariable("userId") String userId) throws URISyntaxException {

// Step1: Get all the RatingId from the Rating-MS

         UserRating userRating = restTemplate.getForObject(
                "http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

         return userRating.getUserRatings().stream().map(rating -> {

             // Step2: Pass the RatingId to get the MovieInfo from the Movie-MS
                     // Movie[] movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie[].class);
                     Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            // Step3: Collect all the info in one object and display it.
                     return new ItemCatalog(movie.getMovieName(), movie.getMovieDesc(), rating.getRating());
                })
         .collect(Collectors.toList());
    }
}

 /*Movie[] movie = webClientBuilder.build()
         .get()
         .uri("http://localhost:9092/movies/" + rating.getMovieId())
         .retrieve()
         .bodyToMono(Movie[].class)
         .block();*/
