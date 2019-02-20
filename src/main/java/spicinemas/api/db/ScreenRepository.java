package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.SelectSelectStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.db.DBScreen;

@Repository
@Transactional
public class ScreenRepository {

    @Autowired
    private DSLContext dslContext;

    public DBScreen getScreenById(int id) {
        Record record = dslContext.select()
                .from(DSL.table("SCREEN"))
                .where(DSL.field("ID").eq(id)).fetchOne();
        return record != null ?
                record.into(DBScreen.class) : null;
    }


    public DBScreen getScreenByShowId(int showId) {
        Record record = dslContext.select()
                .from(DSL.table("SCREEN SN")).join(DSL.table("SHOW SW")).on("SN.ID=SW.SCREEN_ID")
                .where(DSL.field("SW.ID").eq(showId)).fetchOne();
        return record != null ?
                record.into(DBScreen.class) : null;
    }
}
