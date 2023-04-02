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
        for(int i=0; i < allMovies.size(); i++){
            Movie m;
            m = allMovies.get(i);
            if(m.getGenres().contains(genre)){
                filteredListByGenres.add(m);
            }
        }
        return filteredListByGenres;
    }

    public List<Movie> filterByRating(float rating){
        for(int i=0; i<filteredListByGenres.size();i++){
            Movie m;
            m = filteredListByGenres.get(i);
            if(m.getAvgRating() >= rating){
                filteredListByRatings.add(m);
            }
        }
        return filteredListByRatings;
    }
}
