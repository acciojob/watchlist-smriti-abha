package com.driver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    public ResponseEntity<String> addMovieDirectorPair

             (@RequestParam("director") String director, @RequestParam("movie") String movie){
         movieService.addPairOfDirectorAndMovie(director,movie);
         return new ResponseEntity<>("pair created successfully",HttpStatus.CREATED);
     }

     @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
       Movie movie =movieService.getMovieByName(name);

         return new ResponseEntity<>(movie,HttpStatus.CREATED);
     }

     @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
         Director director=movieService.getDirectorByName(name);

         return new ResponseEntity<>(director,HttpStatus.CREATED);
     }

     @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
         List<String>  movies=movieService.getListOfMoviesByDirectorName(director);

         return new ResponseEntity<>(movies,HttpStatus.CREATED);
     }

     @GetMapping("/get-all-movies")
            public ResponseEntity<List<String>> findAllMovies(){
         List<String> movies=movieService.getListOfMovies();

         return new ResponseEntity<>(movies,HttpStatus.CREATED);
     }

     @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(directorName + "deleted successfully",HttpStatus.OK);

     }
     @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirectors(){

         movieService.deleteAllDirectorAndItsMovie();
         return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
     }

}
