package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap = new HashMap<>();

    HashMap<String, Director> directorHashMap = new HashMap<>();

    public void addMovie(Movie movie) {
        movieHashMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorHashMap.put(director.getName(), director);
    }

    public Movie getMovieByName(String name) {
        if (movieHashMap.containsKey(name)) {
            return movieHashMap.get(name);
        }
        else {
            return new Movie(null,0,0.0);
        }
    }

    public Director getDirectorByName(String name) {
        if(directorHashMap.containsKey(name) == true){
            return directorHashMap.get(name);
        }
        else {
            return new Director(null , 0 , 0.0);
        }
    }

    public List<Movie> findAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        for(String name : movieHashMap.keySet()){
            movieList.add(movieHashMap.get(name));
        }
        return movieList;
    }
}
