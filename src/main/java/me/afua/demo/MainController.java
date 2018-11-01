package me.afua.demo;
import me.afua.demo.directormovie.Director;
import me.afua.demo.directormovie.DirectorRepository;
import me.afua.demo.directormovie.Movie;
import me.afua.demo.directormovie.MovieRepository;
import me.afua.demo.employeelaptop.Employee;
import me.afua.demo.employeelaptop.EmployeeRepository;
import me.afua.demo.employeelaptop.Laptop;
import me.afua.demo.movieactor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    @Autowired
    EmployeeRepository employees;

    @Autowired
    DirectorRepository directors;

    @Autowired
    MovieRepository movies;


    @RequestMapping("/")
    public Iterable <Employee> showAllPeople()
    {
        return employees.findAll();
       }

    @RequestMapping("/newemployee")
    public Iterable <Employee> addEmployee()
    {
        Employee me = new Employee("Samantha","Smith");
        me.setMyLaptop(new Laptop("Dell","Optilex","123456"));
        employees.save(me);
        me = new Employee("Samantha","Jones");
        me.setMyLaptop(new Laptop("HP","Don't remember","123456"));
        employees.save(me);
      return showAllPeople();
    }

    @RequestMapping("/delete")
    public Iterable <Employee> deleteSamantha()
    {
        employees.deleteById(new Long(1));
        return showAllPeople();
    }

    @RequestMapping("/addmovies")
    public Iterable <Director>  addInfo()
    {
        Director d = new Director("Steven Spielberg");
        Movie m = new Movie("Schindler's list");
        m.setTheDirector(d);
        d.addMovie(m);
        directors.save(d);
        return directors.findAll();
    }

    @RequestMapping("/dirdet")
    public Director getDetails(HttpServletRequest request)
    {
        long toGet = new Long(request.getParameter("id"));
        return directors.findById(toGet).get();
    }

    @RequestMapping("/movies")
    public Iterable <Movie> showMovies(){
        return movies.findAll();
    }

    @RequestMapping("/addactor")
    public Iterable<Movie> addActor()
    {
        Actor thisActor = new Actor();
        thisActor.setFullName("Sandra Mae Bullowski");
        thisActor.setStageName("Sandra Bullock");
        Movie theMovie = movies.findById(new Long(2)).get();
        //theMovie.setActors(thisActor);
        theMovie.getActors().add(thisActor);

        thisActor = new Actor();
        thisActor.setFullName("Somebody Else's real name");
        thisActor.setStageName("Somebody Else");
        movies.save(theMovie);
        theMovie.getActors().add(thisActor);
        return showMovies();
    }

    @RequestMapping("/showdells")
    public Iterable<Employee> listDells()
    {
        return employees.findAllByMyLaptop_Model("Optilex");
    }


}
