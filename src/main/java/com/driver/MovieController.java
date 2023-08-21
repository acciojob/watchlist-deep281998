package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie response = movieService.getMovieByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director response = movieService.getDirectorByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> response = movieService.findAllMovies();
        return ResponseEntity.ok(response);
    }

}
