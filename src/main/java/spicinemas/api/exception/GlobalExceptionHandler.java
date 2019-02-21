package spicinemas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ScreenNotFoundException.class)
    public ResponseEntity<Error> notFoundException(final ScreenNotFoundException e) {
        return handleError(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<Error> handleError(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new Error(logRef, message, httpStatus), httpStatus);
    }

    @ExceptionHandler(SeatsFullForShowException.class)
    public ResponseEntity<Error> assertionException(final SeatsFullForShowException e) {
        return handleError(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> assertionException(final Exception e) {
        return handleError(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    }
}