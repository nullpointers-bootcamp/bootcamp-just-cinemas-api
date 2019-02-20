package spicinemas.api.db;

import org.jooq.DSLContext;
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
        return dslContext.select().from(DSL.table("SCREEN")).where(DSL.field("ID").eq(id)).fetchOne().into(DBScreen.class);
    }
}
