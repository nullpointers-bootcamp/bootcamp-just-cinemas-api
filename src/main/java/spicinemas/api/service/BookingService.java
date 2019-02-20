package spicinemas.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.config.EmailService;
import spicinemas.api.db.TransactionRepository;
import spicinemas.api.dto.BookingRequest;
import spicinemas.api.dto.BookingResponse;
import spicinemas.api.model.db.DBTransaction;
import spicinemas.api.model.db.DBTransactionSeat;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    EmailService emailService;

    public BookingResponse bookTicket(BookingRequest bookingRequest) {
        DBTransaction transaction = new DBTransaction();
        BeanUtils.copyProperties(bookingRequest, transaction);
        String bookingRefNumber = UUID.randomUUID().toString();
        transaction.setBookingRefNumber(bookingRefNumber);
        transactionRepository.saveTrasaction(transaction);
        int transactionId = transactionRepository.getTransaction(bookingRefNumber).getId();
        List<DBTransactionSeat> seats = bookingRequest.getSeatNumbers().stream().map(t -> {
            DBTransactionSeat seat = new DBTransactionSeat();
            seat.setTransactionId(transactionId);
            seat.setSeat(t);
            return seat;
        }).collect(Collectors.toList());
        transactionRepository.saveTransactionSeats(seats);
        emailService.sendMail(bookingRequest.getEmailId(), "Your movie tickets are booked : Just Cinemas", "Your movie tickets are booked : Seat Numbers " + bookingRequest.getSeatNumbers() + ". Enjoy !!");
        return new BookingResponse(bookingRefNumber, bookingRequest.getSeatNumbers());
    }
}
