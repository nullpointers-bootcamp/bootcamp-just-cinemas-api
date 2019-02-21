package spicinemas.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.dto.ShowInformation;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.exception.SeatsFullForShowException;
import spicinemas.api.model.ShowSeatViewModel;
import spicinemas.api.service.ShowService;

import java.text.ParseException;
import java.util.List;

@RestController
@Api(description = "Controller for operations related to shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @RequestMapping(value = "/shows/show-information",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting shows by movie id and date", response = ShowInformation.class, responseContainer = "List")
    public List<ShowInformation> getShowsByMovieAndDate(@RequestParam String date, @RequestParam int movieId) throws ParseException {
        return showService.getShowsByDateAndMovieId(date, movieId);
    }

    @RequestMapping(value = "/shows/{id}/seats",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting seats by show id", response = ShowSeatViewModel.class)
    public ShowSeatViewModel getSeatsByShow(@PathVariable("id") int id) throws SeatsFullForShowException, ScreenNotFoundException {
        return showService.getShowSeatInformation(id);
    }
}
