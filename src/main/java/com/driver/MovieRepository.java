package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
   public HashMap<String,Movie> movieHashMap=new HashMap<>();
  public HashMap<String,Director> directorHashMap=new HashMap<>();
   public HashMap<String, List<String>>pairDirectorMovieMap=new HashMap<>();

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
            List<String> movieList = new ArrayList<>();

            if(pairDirectorMovieMap.containsKey(directorName)) {
                movieList= pairDirectorMovieMap.get(directorName);
            }
                movieList.add(movieName);

                pairDirectorMovieMap.put(directorName,movieList);

        }


    }
    public Movie getMovieFromDb(String movieName){

            return movieHashMap.get(movieName);

    }
    public Director getDirectorFromDb(String directorName){

           return directorHashMap.get(directorName);

    }
    public List<String> getListOfMovieByDirectorName(String directorName){

            List<String> movieList=new ArrayList<>();
            if(pairDirectorMovieMap.containsKey(directorName)){
                movieList=pairDirectorMovieMap.get(directorName);
            }
        return movieList;

    }
    public List<String> listOfMoviesFromDb(){

        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirectorByNameInDb(String directorName){
        if(pairDirectorMovieMap.containsKey(directorName)) {
            List<String> movieList = pairDirectorMovieMap.get(directorName);

            for (String movie : movieList) {
                if (movieHashMap.containsKey(movie))
                    movieHashMap.remove(movie);
            }
        }
           if(directorHashMap.containsKey(directorName)){
               directorHashMap.remove(directorName);
           }
        }


    public void deleteAllDirectorAndItsMovie(){
        HashSet<String> movieSet=new HashSet<>();
        directorHashMap=new HashMap<>();
        for(String director:pairDirectorMovieMap.keySet()){
            for(String movie: pairDirectorMovieMap.get(director)){
                movieSet.add(movie);

            }
        }
        for (String movie:movieSet
             ) {
            if (movieHashMap.containsKey(movie)){
                movieHashMap.remove(movie);
            }

        }
        pairDirectorMovieMap=new HashMap<>();
    }

}
