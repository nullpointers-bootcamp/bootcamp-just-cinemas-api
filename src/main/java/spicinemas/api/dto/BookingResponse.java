package spicinemas.api.dto;

import java.util.List;

public class BookingResponse {
    private String bookingRefNumber;
    private List<String> confirmedSeats;

    public BookingResponse(String bookingRefNumber, List<String> seatNumbers) {
        this.bookingRefNumber = bookingRefNumber;
        this.confirmedSeats = seatNumbers;
    }

    public String getBookingRefNumber() {
        return bookingRefNumber;
    }

    public void setBookingRefNumber(String bookingRefNumber) {
        this.bookingRefNumber = bookingRefNumber;
    }

    public List<String> getConfirmedSeats() {
        return confirmedSeats;
    }

    public void setConfirmedSeats(List<String> confirmedSeats) {
        this.confirmedSeats = confirmedSeats;
    }
}
