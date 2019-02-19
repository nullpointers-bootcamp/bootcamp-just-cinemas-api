package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Movie;
import spicinemas.api.service.MovieService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    public void shouldReturnMoviebyId() {
        long id = 1;
        Movie movie = movieService.getMovieById(id);
        Assert.assertEquals("The movie name should be ", "Iron Man 1", movie.getName());

    }

    @Test
    public void shouldReturnNowShowingMovies() {
        List<Movie> movies = movieService.getNowShowingMovies();
        Assert.assertEquals("Should fetch now showing movies", 6, movies.size());
    }
}
