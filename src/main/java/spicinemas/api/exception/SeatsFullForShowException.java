package spicinemas.api.exception;

public class SeatsFullForShowException extends Exception {
    public SeatsFullForShowException(String message) {
        super(message);
    }
}
