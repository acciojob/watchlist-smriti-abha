package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieHashMap=new HashMap<>();
    HashMap<String,Director> directorHashMap=new HashMap<>();
    HashMap<String, List<Movie>>pairDirectorMovieMap=new HashMap<>();

    public void addMovieInDb(Movie movie){
        String key= movie.getName();
        movieHashMap.put(key,movie);
    }
    public void addDirectorInDb(Director director){
        String key= director.getName();
        directorHashMap.put(key,director);
    }

    public void addPairDirectorMovieInDb(String directorName,String movieName){
        if(directorHashMap.containsKey(directorName) && movieHashMap.containsKey(movieName)) {
            List<Movie> movieList = new ArrayList<>();

            if(pairDirectorMovieMap.containsKey(directorName)) {
                movieList= pairDirectorMovieMap.get(directorName);
            }
                movieList.add(movieHashMap.get(movieName));

                pairDirectorMovieMap.put(directorName,movieList);

        }


    }
    public Movie getMovieFromDb(String movieName){
        if(movieHashMap.containsKey(movieName)){
            return movieHashMap.get(movieName);
        }
        return null;
    }
    public Director getDirectorFromDb(String directorName){
        if(directorHashMap.containsKey(directorName)){
            directorHashMap.get(directorName);
        }
        return null;
    }
    public List<String> getListOfMovieByDirectorName(String directorName){
        if(pairDirectorMovieMap.containsKey(directorName)){
            List<String> movieName=new ArrayList<>();
            List<Movie> movieList=pairDirectorMovieMap.get(directorName);
            for(Movie movie:movieList){
                movieName.add(movie.getName());
            }
            return movieName;
        }
        return null;
    }
    public List<String> listOfMoviesFromDb(){
        List<String> movieList= new ArrayList<>();
        for(Movie EntrySet:movieHashMap.values()){
           movieList.add(EntrySet.getName());
        }
        return movieList;
    }

    public void deleteDirectorByNameInDb(String directorName){
        if(pairDirectorMovieMap.containsKey(directorName)){
            List<Movie> movieList=pairDirectorMovieMap.get(directorName);

            for(Movie movie:movieList){
                movieHashMap.remove(movie.getName());
            }
            directorHashMap.remove(directorName);
            pairDirectorMovieMap.remove(directorName);
        }
    }

    public void deleteAllDirectorAndItsMovie(){
        pairDirectorMovieMap.forEach((key,value)->{
            List<Movie> movieList=pairDirectorMovieMap.get(key);
            for(Movie movie:movieList){
                movieHashMap.remove(movie.getName());
            }
        });

        pairDirectorMovieMap.clear();
        directorHashMap.clear();
    }

}
