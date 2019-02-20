package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.dto.BookingRequest;
import spicinemas.api.dto.BookingResponse;
import spicinemas.api.model.db.DBTransaction;
import spicinemas.api.model.db.DBTransactionSeat;
import spicinemas.api.service.BookingService;
import spicinemas.api.service.ShowService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class BookingServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    BookingService bookingService;

    @Test
    public void shouldBookTickets() {
        DBTransaction transaction = new DBTransaction();
        transaction.setId(1);
        when(transactionRepository.getTransaction(anyString())).thenReturn(transaction);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setSeatNumbers(Arrays.asList(new String[]{"A1"}));
        bookingRequest.setEmailId("abcd.efg.com");
        bookingRequest.setPaymentType("CreditCard");
        bookingRequest.setShowId(18);
        BookingResponse bookingResponse = bookingService.bookTicket(bookingRequest);
        String bookingRefNumber = bookingResponse.getBookingRefNumber();

        Assert.assertNotNull(bookingRefNumber);
        verify(transactionRepository, times(1)).saveTrasaction(any(DBTransaction.class));
        verify(transactionRepository, times(1)).saveTransactionSeats(anyListOf(DBTransactionSeat.class));
    }

}
