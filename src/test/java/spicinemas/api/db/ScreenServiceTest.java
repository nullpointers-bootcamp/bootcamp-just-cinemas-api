package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.model.db.DBScreen;
import spicinemas.api.service.ScreenService;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ScreenServiceTest {

    @Mock
    ScreenRepository screenRepository;

    @InjectMocks
    ScreenService service;

    @Test
    public void shouldReturnScreenInformationBasedOnScreenId() throws ScreenNotFoundException {
        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenById(1)).thenReturn(screen);
        DBScreen actualScreen = service.getScreen(1);
        Assert.assertEquals("no of rows should be 10", 10, actualScreen.getNumberOfRows());
    }

    @Test(expected = ScreenNotFoundException.class)
    public void shouldThrowScreenNotFoundExceptionWhenScreenInformationNotFound() throws ScreenNotFoundException {
        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenById(1)).thenReturn(null);
        service.getScreen(1);
    }

    @Test
    public void shouldReturnScreenInformationBasedOnShowId() throws ScreenNotFoundException {
        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenByShowId(18)).thenReturn(screen);
        DBScreen actualScreen = service.getScreenByShowId(18);
        Assert.assertEquals("no of rows should be 10", 10, actualScreen.getNumberOfRows());

    }

    @Test(expected = ScreenNotFoundException.class)
    public void shouldThrowScreenNotFoundExceptionWhenScreenInformationNotFoundForAShowId() throws ScreenNotFoundException {
        DBScreen screen = new DBScreen();
        screen.setId(1);
        screen.setName("Screen 1");
        screen.setNumberOfColumns(50);
        screen.setNumberOfRows(10);
        screen.setTheatreId(1);
        when(screenRepository.getScreenByShowId(1)).thenReturn(screen);
        service.getScreenByShowId(18);
    }
}
