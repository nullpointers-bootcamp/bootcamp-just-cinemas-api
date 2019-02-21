package spicinemas.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.LanguageRepository;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.model.db.DBMovie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private LanguageRepository languageRepository;

    public List<Movie> getNowShowingMovies() {
        List<Movie> movies = movieRepository.getNowShowingMovies().stream().map(m -> {
            Movie movie = transformDBMovieToMovie(m);
            return movie;
        }).collect(Collectors.toList());
        return movies;
    }

    private Movie transformDBMovieToMovie(DBMovie m) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(m, movie);
        movie.setImageName(m.getImageName());
        movie.setStills(Arrays.asList(m.getStills().split(",")));
        movie.setLanguage(languageRepository.getLanguageMap().get(m.getLanguage()));
        return movie;
    }

    public Movie getMovieById(long id) {
        DBMovie dbMovie = movieRepository.getMovieById(id);
        return transformDBMovieToMovie(dbMovie);
    }


    public List<Movie> getUpComingMovies() {
        List<Movie> movies = movieRepository.getUpcomingMovies().stream().map(m -> {
            Movie movie = transformDBMovieToMovie(m);
            return movie;
        }).collect(Collectors.toList());
        return movies;
    }

    public List<Movie> getUpComingMoviesByLanguage(int id) {
        List<Movie> movies = movieRepository.getUpcomingMoviesByLanguage(id).stream().map(m -> {
            Movie movie = transformDBMovieToMovie(m);
            return movie;
        }).collect(Collectors.toList());
        return movies;
    }
}
