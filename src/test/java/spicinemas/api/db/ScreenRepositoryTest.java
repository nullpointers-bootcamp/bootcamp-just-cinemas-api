package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.db.DBScreen;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ScreenRepositoryTest {

    @Autowired
    private ScreenRepository screenRepository;

    @Test
    public void shouldReturnScreenForId() {
        DBScreen screen = screenRepository.getScreenById(1);
        Assert.assertEquals("Screen should be of id 1", "Screen 1", screen.getName());
    }

    @Test
    public void shouldNotReturnScreenInformationForWhenScreenNotFound() {
        DBScreen screen = screenRepository.getScreenById(100);
        Assert.assertEquals("Screen should be null", null, screen);
    }

    @Test
    public void shouldReturnScreenInformationBasedOnShowId() {
        DBScreen screen = screenRepository.getScreenByShowId(18);
        Assert.assertEquals("Screen should be of id 1", "Screen 1", screen.getName());
    }

}
