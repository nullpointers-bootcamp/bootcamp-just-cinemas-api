package spicinemas.api.exception;

import org.springframework.http.HttpStatus;

public class Error {
    private final String message;
    private final HttpStatus httpStatus;
    private final String logRef;

    public Error(String logRef, String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.logRef = logRef;

    }
}
