package spicinemas.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.service.MovieService;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies() {
        return movieService.getNowShowingMovies();
    }


    @RequestMapping(value = "/movies/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/movies/upcoming",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getUpComingMovies() {
        return movieService.getUpComingMovies();
    }
}
