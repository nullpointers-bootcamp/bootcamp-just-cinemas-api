package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.DBMovie;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldReturnAllMoviesWithListingTypeNowShowing(){
        List<DBMovie> movies = movieRepo.getNowShowingMovies();
        Assert.assertEquals("Total now showing movies should be 6",6, movies.size());
    }

    @Test
    public void shouldReturnAMovieByName(){
        DBMovie movie = movieRepo.getMovie("Iron Man 1");
        Assert.assertEquals("Get movie should return Iron Man 1","Iron Man 1", movie.getName());
    }

    @Test
    public void shouldReturnAMovieDetails(){
        DBMovie movie = movieRepo.getMovie("Iron Man 1");
        DBMovie movieResult = movieRepo.getMovieById(movie.getId());
        Assert.assertEquals("Get movie should return Iron Man 1", movie.getId(), movieResult.getId());
    }
}