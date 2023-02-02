package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
     @Autowired
    MovieService movieService;

     @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
         movieService.addMovie(movie);
         return new ResponseEntity<>("movie added successfully", HttpStatus.CREATED);
     }

     @PostMapping("/add-director")
     public ResponseEntity<String> addTeacher(@RequestBody Director director){
         movieService.addDirector(director);
         return new ResponseEntity<>("director added successfully",HttpStatus.CREATED);
     }

     @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String director, @RequestParam String movie){
         movieService.addPairOfDirectorAndMovie(director,movie);
         return new ResponseEntity<>("pair created succesfully",HttpStatus.CREATED);
     }

     @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
       Movie movie = null;
         movie = movieService.getMovieByName(name);
         return new ResponseEntity<>(movie,HttpStatus.CREATED);
     }

     @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
         Director director=null;
         director=movieService.getDirectorByName(String.valueOf(name));
         return new ResponseEntity<>(director,HttpStatus.CREATED);
     }

     @GetMapping("/get-movie-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByTeacherName(@PathVariable String movie){
         List<String> movies=null;
         movies=movieService.getListOfMoviesByDirectorName(String.valueOf(movies));
         return new ResponseEntity<>(movies,HttpStatus.CREATED);
     }

     @GetMapping("/get-all-movies")
            public ResponseEntity<List<String>> findAllMovies(){
         List<String> movies=null;
         movies=movieService.getListOfMovies();
         return new ResponseEntity<>(movies,HttpStatus.CREATED);
     }

     @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(directorName,HttpStatus.NOT_FOUND);

     }
     @DeleteMapping("/delete-all-directors")
    public ResponseEntity<List<String>>deleteAllDirectors(){
         List<String> movies=null;
         movies=movieService.deleteAllDirectorAndItsMovie();
         return new ResponseEntity<>(movies,HttpStatus.CHECKPOINT);
     }

}
