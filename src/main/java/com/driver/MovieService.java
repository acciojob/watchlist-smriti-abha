package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    static MovieRepository movieRepository;

    public static void addMovie(Movie movie){
        movieRepository.addMovieInDb(movie);
    }

    public static void addDirector(Director director){
        movieRepository.addDirectorInDb(director);
    }

    public static void addPairOfDirectorAndMovie(String director, String movie){
        movieRepository.addPairDirectorMovieInDb(director,movie);
    }

    public static Movie getMovieByName(String movie){
       return movieRepository.getMovieFromDb(movie);

    }

    public static Director getDirectorByName(String directorName){
        return movieRepository.getDirectorFromDb(directorName);

    }

    public static List<String> getListOfMoviesByDirectorName(String directorName){
        return movieRepository.getListOfMovieByDirectorName(directorName);

    }

    public List<String> getListOfMovies(){
        return movieRepository.listOfMoviesFromDb();

    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByNameInDb(directorName);
    }

    public void deleteAllDirectorAndItsMovie(){
        movieRepository.deleteAllDirectorAndItsMovie();

    }

}
