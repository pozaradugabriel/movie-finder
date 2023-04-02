package rrt.mf.service;


import org.springframework.stereotype.Service;
import rrt.mf.model.Movie;
import rrt.mf.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private List<Movie> filteredListByGenres = new ArrayList<Movie>();
    private List<Movie> filteredListByRatings = new ArrayList<Movie>();
    private List<Movie> filteredListByYear = new ArrayList<Movie>();
    private List<Movie> filteredListByMainActor = new ArrayList<Movie>();






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

    public List<Movie> filterByGenre(String genre){
        List<Movie> allMovies = movieRepository.findAll();
        for (Movie movie : allMovies) {
            if (movie.getGenres().contains(genre)) {
                filteredListByGenres.add(movie);
            }
        }
        return filteredListByGenres;
    }

    public List<Movie> filterByRating(float rating){
        for (Movie movie : filteredListByGenres) {
            if (movie.getAvgRating() >= rating) {
                filteredListByRatings.add(movie);
            }
        }
        return filteredListByRatings;
    }

    public List<Movie> filterByYear(int year){
        for (Movie movie : filteredListByRatings) {
            if (movie.getYear() >= year) {
                filteredListByYear.add(movie);
            }
        }
        return filteredListByYear;
    }

    public List<Movie> filterByMainActor(String mainActor){
        for (Movie movie : filteredListByYear) {
            if (movie.getMainActor().contains(mainActor)) {
                filteredListByMainActor.add(movie);
            }
        }
        return filteredListByMainActor;
    }

    public Movie showChosenMovie(){
        return filteredListByMainActor.get(0);
    }
}
