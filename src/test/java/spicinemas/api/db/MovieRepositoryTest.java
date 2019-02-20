package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.db.DBMovie;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    DSLContext dslContext;

    @Before
    public void initialize()
    {
        dslContext.delete(DSL.table("MOVIE")).where(DSL.field("ID").in(17,18)).execute();
    }
    @Test
    public void shouldReturnAllMoviesWithListingTypeNowShowing(){
        List<DBMovie> movies = movieRepo.getNowShowingMovies();
        Assert.assertEquals("Total now showing movies should be 6",15, movies.size());
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

    @Test
    public void shouldReturnAllMoviesWithListingTypeUpComing(){
        dslContext.insertInto(DSL.table("MOVIE"), DSL.field("id"),DSL.field("name")
                ,DSL.field("experiences"),DSL.field("listing_type"),
                DSL.field("lang"),DSL.field("image_name"),DSL.field("stills"),DSL.field("synopsis"))
                .values(17,"The Secret Life of Pets 2","RDX, Dolby Atmos, SUB","UPCOMING",1,"thesecretlifeofpets2","thesecretlifeofpets2_1, thesecretlifeofpets2_2","The Secret Life of Pets 2 will follow summer 2016s blockbuster about the lives our pets lead after we leave for work or school each day.")
                .values(18,"Toy Story 4","RDX, Dolby Atmos, SUB","UPCOMING",1,"toystory4","toystory4_1, toystory4_2","Toy Story 4 is an upcoming American 3D computer-animated comedy film, and the third sequel to Toy Story.")
                .execute();
        List<DBMovie> movies = movieRepo.getUpcomingMovies();
        Assert.assertEquals("Total upcoming movies should be 1",2, movies.size());
    }

    @Test
    public void shouldNotReturnAnyMoviesWhenThereAreNoUpComingMovies(){
        List<DBMovie> movies = movieRepo.getUpcomingMovies();
        Assert.assertEquals("Total upcoming movies should be 2",0, movies.size());
    }

}