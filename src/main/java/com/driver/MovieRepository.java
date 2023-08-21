package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap = new HashMap<>();

    HashMap<String, Director> directorHashMap = new HashMap<>();


    HashMap<String , List<String>> listHashMap = new HashMap<>();

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

    public void addMovieDirectorPair(String directorname, String moviename) {
        if(listHashMap.containsKey(directorname) == true){
            List<String> movies = listHashMap.get(directorname);
            movies.add(moviename);
        }
        else {
            List<String> movies = new ArrayList<>();
            movies.add(moviename);
            listHashMap.put(directorname,movies);
        }


    }

    public List<String> getMoviesByDirectorName(String name) {
        if(listHashMap.containsKey(name)){
            return listHashMap.get(name);
        }
        else{
            return new ArrayList<String>();
        }
    }

    public void deleteDirectorByName(String name) {
        List<String> moviename  = listHashMap.get(name);
        listHashMap.remove(name);
        for(String nameofmovie : moviename){
            movieHashMap.remove(nameofmovie);
        }
        directorHashMap.remove(name);
    }

    public void deleteAllDirectors() {
        for(String directorname : listHashMap.keySet()){
            List<String> mname = listHashMap.get(directorname);
            for(String name : mname){
                if(movieHashMap.containsKey(name) == true){
                    movieHashMap.remove(name);
                }
            }
            directorHashMap.remove(directorname);
            listHashMap.remove(directorname);
        }
    }
}
