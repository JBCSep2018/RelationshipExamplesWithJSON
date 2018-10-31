package me.afua.demo.directormovie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.afua.demo.movieactor.Actor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @GeneratedValue()
    @Id
    private long id;

    private String title;

    @ManyToOne
    @JsonIgnore
    private Director theDirector;

    @ManyToMany(cascade = CascadeType.ALL)
//    private Actor actors;
   private Set<Actor> actors;

    public Movie(String title) {
        this.title=title;
    }

     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getTheDirector() {
        return theDirector;
    }

    public void setTheDirector(Director theDirector) {
        this.theDirector = theDirector;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Movie() {

    }
//
//    public Actor getActors() {
//        return actors;
//    }
//
//    public void setActors(Actor actors) {
//        this.actors = actors;
//    }


    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    void addActor (Actor a)
    {
        this.actors.add(a);
    }
}
