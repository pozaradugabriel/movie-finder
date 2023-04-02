package rrt.mf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rrt.mf.model.Movie;
import rrt.mf.service.MovieService;

import java.util.List;

@RestController
@RequestMapping(path="/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.showAllMovies();
    }
}
