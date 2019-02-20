package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.dto.BookingRequest;
import spicinemas.api.dto.BookingResponse;
import spicinemas.api.service.BookingService;

@RestController(value="/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse getShowsByMovieAndDate(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}
