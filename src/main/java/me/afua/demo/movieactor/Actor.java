package me.afua.demo.movieactor;

import me.afua.demo.directormovie.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {

    @GeneratedValue()
    @Id
    private long id;

    private String fullName;

    private String stageName;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
