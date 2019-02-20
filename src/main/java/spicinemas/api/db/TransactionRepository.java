package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.db.DBTransaction;

@Repository
@Transactional
public class TransactionRepository {

    @Autowired
    private DSLContext dslContext;

    public void saveTrasaction(DBTransaction transaction) {
        dslContext.insertInto(DSL.table("TRANSACTION"), DSL.field("EMAIL_ID"), DSL.field("BOOKING_REF_NUMBER"), DSL.field("SHOW_ID"), DSL.field("PAYMENT_TYPE"), DSL.field("IS_CANCELLED"))
                .values(transaction.getEmailId(), transaction.getBookingRefNumber(), transaction.getShowId(), transaction.getPaymentType(), transaction.isCancelled()).execute();
    }

    public DBTransaction getTransaction(String bookingRefNumber) {
        return dslContext.select().from(DSL.table("TRANSACTION")).where(DSL.field("BOOKING_REF_NUMBER").eq(bookingRefNumber)).fetchOne().into(DBTransaction.class);
    }
}
