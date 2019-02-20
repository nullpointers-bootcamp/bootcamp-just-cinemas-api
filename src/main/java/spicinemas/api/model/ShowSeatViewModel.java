package spicinemas.api.model;

public class ShowSeatViewModel {
    private int noOfRows;
    private int noOfColumns;
    private String[] bookedSeats;

    public ShowSeatViewModel(int noOfRows, int noOfColumns, String[] bookedSeats) {
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        this.bookedSeats = bookedSeats;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public String[] getBookedSeats() {
        return bookedSeats;
    }
}
