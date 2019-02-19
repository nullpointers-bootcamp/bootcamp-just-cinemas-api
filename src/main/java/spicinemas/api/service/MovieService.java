package spicinemas.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.LanguageRepository;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.model.DBMovie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    LanguageRepository languageRepository;

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
        movie.setSlug(m.getName().toLowerCase().replace(" ", "-"));
        movie.setStills(Arrays.asList(m.getStills().split(",")));
        movie.setLanguage(languageRepository.getLanguageMap().get(m.getLang()));
        return movie;
    }

    public Movie getMovieById(long id) {
        DBMovie dbMovie = movieRepository.getMovieById(id);
        return transformDBMovieToMovie(dbMovie);
    }


}
