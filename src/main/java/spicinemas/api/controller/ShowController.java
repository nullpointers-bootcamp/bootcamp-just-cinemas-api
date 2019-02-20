package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.dto.ShowInformation;
import spicinemas.api.service.ShowService;

import java.text.ParseException;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    ShowService movieService;

    @RequestMapping(value = "/shows/show-information",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowInformation> getShowsByMovieAndDate(@RequestParam String date, @RequestParam int movieId) throws ParseException {
        return movieService.getShowsByDateAndMovieId(date, movieId);
    }

}
