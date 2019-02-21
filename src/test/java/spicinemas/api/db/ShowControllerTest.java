package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.controller.ShowController;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.exception.SeatsFullForShowException;
import spicinemas.api.model.ShowSeatViewModel;
import spicinemas.api.service.ShowService;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowControllerTest {

    @Mock
    ShowService showService;

    @InjectMocks
    ShowController showController;

    @Test
    public void shouldReturnSeatInformationForAShow() throws SeatsFullForShowException, ScreenNotFoundException {
        ShowSeatViewModel seatViewModel = new ShowSeatViewModel(10,10,new String[]{"A1"});
        when(showController.getSeatsByShow(Mockito.anyInt())).thenReturn(seatViewModel);
        ShowSeatViewModel showSeatViewModel = showController.getSeatsByShow(18);
        Assert.assertEquals(10,showSeatViewModel.getNoOfRows());
    }

}
