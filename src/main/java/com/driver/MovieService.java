package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    static
    MovieRepository movieRepository;

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
        movieRepository.getMovieFromDb(movie);
        return null;
    }

    public static Director getDirectorByName(String directorName){
        movieRepository.getDirectorFromDb(directorName);
        return null;
    }

    public static List<String> getListOfMoviesByDirectorName(String directorName){
        movieRepository.getListOfMovieByDirectorName(directorName);
        return null;
    }

    public List<String> getListOfMovies(){
        movieRepository.listOfMoviesFromDb();
        return null;
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByNameInDb(directorName);
    }

    public List<String> deleteAllDirectorAndItsMovie(){
        movieRepository.deleteAllDirectorAndItsMovie();
        return null;
    }

}
