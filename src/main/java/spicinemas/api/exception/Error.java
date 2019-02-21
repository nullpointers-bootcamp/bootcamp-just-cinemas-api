package spicinemas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Error {

    private String message;
    private HttpStatus httpStatus;
    private String logRef;

    public Error(String logRef, String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.logRef = logRef;
    }

    public Error() {}
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getLogRef() {
        return logRef;
    }
}
