package spicinemas.api.model.db;

public class DBTransaction {

    private int id;
    private String emailId;
    private String bookingRefNumber;
    private int showId;
    private String paymentType;
    private boolean isCancelled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBookingRefNumber() {
        return bookingRefNumber;
    }

    public void setBookingRefNumber(String bookingRefNumber) {
        this.bookingRefNumber = bookingRefNumber;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
