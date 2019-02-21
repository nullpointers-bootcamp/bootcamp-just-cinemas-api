package spicinemas.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.dto.BookingResponse;
import spicinemas.api.model.Language;
import spicinemas.api.service.LanguageService;

import java.util.List;

@RestController
@Api(description = "Controller for getting languages")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @RequestMapping(value = "/languages",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Api for getting languages", response = BookingResponse.class)
    public List<Language> get() {
        return languageService.getLanguage();
    }
}
