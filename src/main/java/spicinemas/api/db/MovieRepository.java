package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.model.db.DBMovie;

import java.util.List;

@Repository
@Transactional
public class MovieRepository {
    @Autowired
    private DSLContext dsl;

    public List<DBMovie> getNowShowingMovies() {
        return dsl.select()
                .from(DSL.table("MOVIE M"))
                .where(DSL.field("listing_type").eq("NOW_SHOWING"))
                .fetchInto(DBMovie.class);
    }

    public void addMovie(Movie movie) {
            dsl.insertInto(DSL.table("MOVIE"), DSL.field("NAME"), DSL.field("EXPERIENCES"), DSL.field("LISTING_TYPE"))
                    .values(movie.getName(), movie.getExperiences(), movie.getListingType().toString())
                    .execute();

    }

    public DBMovie getMovie(String name) {
        return dsl.select()
                .from(DSL.table("MOVIE"))
                .where(DSL.field("MOVIE.NAME").eq(name))
                .fetchOneInto(DBMovie.class);
    }


    public DBMovie getMovieById(Long id) {
        return dsl.select()
                .from(DSL.table("MOVIE"))
                .where(DSL.field("MOVIE.ID").eq(id))
                .fetchOneInto(DBMovie.class);
    }

    public List<DBMovie> getUpcomingMovies() {
        return dsl.select()
                .from(DSL.table("MOVIE M"))
                .where(DSL.field("listing_type").eq("UPCOMING"))
                .fetchInto(DBMovie.class);
    }
}
