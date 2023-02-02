package com.driver;

public class Movie {
    //String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters
    String name;
     int durationInMinutes;
     double imdbRating;

    public Movie(){

    }
    public Movie(String name,int durationInMinutes,double imdbRating){
        this.name=name;
        this.durationInMinutes=durationInMinutes;
        this.imdbRating=imdbRating;
    }

    public String getName() {
        return name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }
}
