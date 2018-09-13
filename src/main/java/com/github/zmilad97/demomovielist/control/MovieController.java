package com.github.zmilad97.demomovielist.control;

import com.github.zmilad97.demomovielist.model.Movie;
import com.github.zmilad97.demomovielist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

  private MovieService movieService;

  @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    public MovieController(){

    }

    @GetMapping ("/seenlist")
    public List<Movie> seenList(){
      List<Movie> mv = new ArrayList<>(showAll());
      List<Movie> sm = new ArrayList<>();
      for (Movie movie:mv){
       if (movie.getStatus().equals("seen list"))
           sm.add(movie);
      }
      return sm;
    }

    @RequestMapping("/movies/{id}")
    public Movie getmovie(@PathVariable("id") int id){
      return movieService.findById(id).orElse(null);
    }

    @GetMapping ("/watchlist")
    public List<Movie> watchList(){
        List<Movie> mv = new ArrayList<>(showAll());
        List<Movie> wm = new ArrayList<>();
        for (Movie movie:mv){
            if (movie.getStatus().equals("watch list"))
                wm.add(movie);
        }
        return wm;
    }

    @PutMapping ("/movies")
    public void addMovie(@RequestBody Movie movie){
      movieService.save(movie);
    }

    @GetMapping ("/movies")
    public List<Movie> showAll(){
      return movieService.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
    public void delete(@PathVariable("id") int id){
      movieService.deleteById(id);
    }
}
