package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.db.DBTheatre;

@Repository
@Transactional
public class TheatreRepository {

    @Autowired
    private DSLContext dslContext;

    public DBTheatre getTheatreById(int id) {
        return dslContext.select().from(DSL.table("THEATRE")).where(DSL.field("ID").eq(id)).fetchOneInto(DBTheatre.class);
    }
}
