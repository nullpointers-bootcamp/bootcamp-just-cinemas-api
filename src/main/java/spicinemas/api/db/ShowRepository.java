package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.db.DBShow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ShowRepository {

    @Autowired
    private DSLContext dslContext;

    public List<DBShow> getShowsByDateAndMovieId(Date date, int movieId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return dslContext.select().from(DSL.table("SHOW")).where(DSL.field("DATE").eq(sdf.format(date))).and(DSL.field("MOVIE_ID").eq(movieId)).fetch().into(DBShow.class);
    }


    public DBShow getShowdById(int id) {
        return dslContext.select().from(DSL.table("SHOW")).where(DSL.field("ID").eq(id)).fetchOne().into(DBShow.class);
    }
}
