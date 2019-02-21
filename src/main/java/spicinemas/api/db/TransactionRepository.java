package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.InsertValuesStep2;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.db.DBTransaction;
import spicinemas.api.model.db.DBTransactionSeat;

import java.util.List;

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
        return dslContext.select().from(DSL.table("TRANSACTION")).where(DSL.field("BOOKING_REF_NUMBER").eq(bookingRefNumber)).fetchOneInto(DBTransaction.class);
    }

    public void saveTransactionSeats(List<DBTransactionSeat> dbSeats) {
        InsertValuesStep2<Record, Object, Object> insertValuesStep = dslContext.insertInto(DSL.table("TRANSACTION_SEATS"), DSL.field("TRANSACTION_ID"), DSL.field("SEAT_NUMBER"));
        for (DBTransactionSeat dbSeat : dbSeats) {
            insertValuesStep.values(dbSeat.getTransactionId(), dbSeat.getSeat());
        }
        insertValuesStep.execute();
    }

    public List<DBTransactionSeat> getTransactionSeats(int transactionId) {
        return dslContext.select().from(DSL.table("TRANSACTION_SEATS")).where(DSL.field("TRANSACTION_ID").eq(transactionId)).fetchInto(DBTransactionSeat.class);
    }
}
