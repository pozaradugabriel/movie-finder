package rrt.mf.service;


import org.springframework.stereotype.Service;
import rrt.mf.model.Movie;
import rrt.mf.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        if (movie.getTitle() != null && movie.getGenres() != null && movie.getMainActor() != null && movie.getCreator() != null && movie.getAvgRating() != 0) {
            return movieRepository.save(movie);
        }
        else return null;
    }

    public List<Movie> showAllMovies(){
        return movieRepository.findAll();
    }
}
