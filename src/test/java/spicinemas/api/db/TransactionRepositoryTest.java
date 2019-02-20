package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.db.DBTransaction;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void saveTransactionTest() {
        DBTransaction dbTransaction = new DBTransaction();
        String bookingRefNumber = UUID.randomUUID().toString();
        dbTransaction.setBookingRefNumber(bookingRefNumber);
        dbTransaction.setCancelled(false);
        dbTransaction.setEmailId("abcd@efg.hij");
        dbTransaction.setPaymentType("DemandDraft");
        dbTransaction.setShowId(18);

        transactionRepository.saveTrasaction(dbTransaction);
        DBTransaction transaction = transactionRepository.getTransaction(bookingRefNumber);

        Assert.assertNotNull(transaction);
        Assert.assertEquals("Should return transaction", bookingRefNumber, dbTransaction.getBookingRefNumber());
    }
}
