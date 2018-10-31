package me.afua.demo.directormovie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {
    @GeneratedValue()
    @Id
    private long id;

    private String fullName;

    private String genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theDirector",fetch = FetchType.EAGER)
    private Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Director(String fullName) {
        this.fullName = fullName;
        this.movies = new HashSet<>();
    }

    public void addMovie (Movie m)
    {
        movies.add(m);
    }

    public Director() {
        this.movies = new HashSet<>();
    }



}
