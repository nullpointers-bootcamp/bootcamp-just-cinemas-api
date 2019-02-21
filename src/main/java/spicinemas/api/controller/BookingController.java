package spicinemas.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.dto.BookingRequest;
import spicinemas.api.dto.BookingResponse;
import spicinemas.api.service.BookingService;

import javax.validation.Valid;

@RestController
@Api(description = "Controller for booking related operations")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/booking",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for booking tickets", response = BookingResponse.class)
    public BookingResponse getShowsByMovieAndDate(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}
