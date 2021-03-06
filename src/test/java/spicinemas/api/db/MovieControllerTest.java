package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.controller.MovieController;
import spicinemas.api.model.Movie;
import spicinemas.api.service.MovieService;
import spicinemas.api.type.Language;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieControllerTest {

    @InjectMocks
    MovieController movieController;

    @Mock
    MovieService movieService;

    @Test
    public void shouldReturnUpComingMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toy Story 1", "RDX", MovieListingType.UPCOMING));
        movies.add(new Movie("Toy Story 2", "RDX, ATMOS", MovieListingType.UPCOMING));
        when(movieService.getUpComingMovies()).thenReturn(movies);
        List<Movie> movieList = movieController.getUpComingMovies(null);
        Assert.assertEquals("should return upcoming movies", 2, movieList.size());
        Assert.assertEquals("should return upcoming movies Toy Story 1", "Toy Story 1", movieList.get(0).getName());
        Assert.assertEquals("should return upcoming movies Toy Story 2", "Toy Story 2", movieList.get(1).getName());
    }

    @Test
    public void shouldReturnAllNowShowingMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toy Story 1", "RDX", MovieListingType.NOW_SHOWING));
        movies.add(new Movie("Toy Story 2", "RDX, ATMOS", MovieListingType.NOW_SHOWING));
        when(movieService.getNowShowingMovies()).thenReturn(movies);
        List<Movie> movieList = movieController.getNowShowingMovies(null);
        Assert.assertEquals("should return upcoming movies", 2, movieList.size());
        Assert.assertEquals("should return upcoming movies Toy Story 1", "Toy Story 1", movieList.get(0).getName());
        Assert.assertEquals("should return upcoming movies Toy Story 2", "Toy Story 2", movieList.get(1).getName());
    }
    @Test
    public void shouldReturnAllNowShowingMoviesByLanguage() {
        List<Movie> movies = new ArrayList<>();
        int id = 1;
        movies.add(new Movie("Toy Story 1", MovieListingType.NOW_SHOWING, Language.English));
        movies.add(new Movie("Toy Story 2", MovieListingType.NOW_SHOWING, Language.English));
        when(movieService.getNowShowingMoviesByLanguage(id)).thenReturn(movies);
        List<Movie> movieList = movieController.getNowShowingMovies(id);
        Assert.assertEquals("should return upcoming movies", 2, movieList.size());
        Assert.assertEquals("should return upcoming movies Toy Story 1", "Toy Story 1", movieList.get(0).getName());
        Assert.assertEquals("should return upcoming movies Toy Story 2", "Toy Story 2", movieList.get(1).getName());
    }

    @Test
    public void shouldNotMoviesWhenThereAreNoUpComingMovies() {
        when(movieService.getUpComingMovies()).thenReturn(new ArrayList<>());
        List<Movie> movieList = movieController.getUpComingMovies(null);
        Assert.assertEquals("should not return upcoming movies", 0, movieList.size());
    }

    @Test
    public void shouldReturnUpComingMoviesByLanguage() {
        List<Movie> movies = new ArrayList<>();
        int id = 2;
        movies.add(new Movie("Toy Story 1", MovieListingType.UPCOMING, Language.Tamil));
        movies.add(new Movie("Toy Story 2", MovieListingType.UPCOMING, Language.Tamil));
        when(movieService.getUpComingMoviesByLanguage(id)).thenReturn(movies);
        List<Movie> movieList = movieController.getUpComingMovies(id);
        Assert.assertEquals("should return upcoming movies", 2, movieList.size());
        Assert.assertEquals("should return upcoming movies Toy Story 1", "Toy Story 1", movieList.get(0).getName());
        Assert.assertEquals("should return upcoming movies Toy Story 2", "Toy Story 2", movieList.get(1).getName());
    }
}
