package spicinemas.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.model.Movie;
import spicinemas.api.service.MovieService;

import java.util.List;

@RestController
@Api(description = "Controller for movie related operations")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting now showing movies", response = Movie.class, responseContainer = "List")
    public List<Movie> getNowShowingMovies() {
        return movieService.getNowShowingMovies();
    }


    @RequestMapping(value = "/movies/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting movie by Id", response = Movie.class)
    public Movie getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/movies/upcoming",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting upcoming movies", response = Movie.class, responseContainer = "List")
    public List<Movie> getUpComingMovies() {
        return movieService.getUpComingMovies();
    }
}
