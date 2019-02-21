package spicinemas.api.db;

import org.assertj.core.internal.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.dto.ShowInformation;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.exception.SeatsFullForShowException;
import spicinemas.api.model.ShowSeatViewModel;
import spicinemas.api.model.db.DBScreen;
import spicinemas.api.model.db.DBShow;
import spicinemas.api.model.db.DBTheatre;
import spicinemas.api.service.ShowService;

import java.sql.Time;
import java.text.ParseException;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowServiceTest {

    @Mock
    ShowRepository showRepository;
    @Mock
    TheatreRepository theatreRepository;
    @Mock
    ScreenRepository screenRepository;

    @InjectMocks
    ShowService showService;

    @Test
    public void shouldShow() throws ParseException {
        List<DBShow> shows = new ArrayList<>();
        DBShow show = new DBShow();
        show.setId(1);
        Calendar date = Calendar.getInstance();
        date.set(2019, Calendar.FEBRUARY, 14);
        show.setDate(date.getTime());
        show.setTime(new Time(date.getTime().getTime()));
        show.setMovieId(1);
        show.setScreenId(1);
        show.setId(1);
        shows.add(show);
        when(showRepository.getShowsByDateAndMovieId(any(Date.class), anyInt())).thenReturn(shows);

        DBTheatre theatre = new DBTheatre();
        theatre.setId(1);
        theatre.setName("PVR");
        when(theatreRepository.getTheatreById(1)).thenReturn(theatre);

        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenById(1)).thenReturn(screen);

        List<ShowInformation> actualShows = showService.getShowsByDateAndMovieId("2019-02-14", 1);
        Assert.assertEquals("Should fetch size 1", 1, actualShows.size());
    }

    @Test
    public void shouldReturnBookedSeatsInformationForAShow() throws SeatsFullForShowException, ScreenNotFoundException {
        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenByShowId(18)).thenReturn(screen);
        when(showRepository.getSeatsBookedByShowId(18)).thenReturn(Arrays.asList("A1","A2"));
        ShowSeatViewModel showSeatViewModel =showService.getShowSeatInformation(18);
        Assert.assertEquals(50,showSeatViewModel.getNoOfColumns());
        Assert.assertEquals(10,showSeatViewModel.getNoOfRows());
        Assert.assertEquals(new String[]{"A1","A2"},showSeatViewModel.getBookedSeats());

    }
}
