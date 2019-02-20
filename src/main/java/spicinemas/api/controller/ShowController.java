package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.dto.ShowInformation;
import spicinemas.api.exception.SeatsFullForShowException;
import spicinemas.api.model.ShowSeatViewModel;
import spicinemas.api.service.ShowService;

import java.text.ParseException;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @RequestMapping(value = "/shows/show-information",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowInformation> getShowsByMovieAndDate(@RequestParam String date, @RequestParam int movieId) throws ParseException {
        return showService.getShowsByDateAndMovieId(date, movieId);
    }

    @RequestMapping(value = "/shows/{id}/seats",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowSeatViewModel getSeatsByShow(@PathVariable("id")int id) throws SeatsFullForShowException {
        return showService.getShowSeatInformation(id);
    }
}
