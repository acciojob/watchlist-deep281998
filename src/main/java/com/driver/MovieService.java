package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "movie added succesfully";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "director added succesfully";
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);

    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String addMovieDirectorPair(String directorname, String moviename) {
        movieRepository.addMovieDirectorPair(directorname,moviename);
        return "added succesfully";
    }

    public List<String> getMoviesByDirectorName(String name){
       return movieRepository.getMoviesByDirectorName(name);
    }

    public String deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
        return "Delete succesfully";
    }

    public String deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return "Deleted succesfully";
    }
}
