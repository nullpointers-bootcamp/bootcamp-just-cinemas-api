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
import spicinemas.api.model.db.DBTheatre;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class TheatreRepositoryTest {

    @Autowired
    private TheatreRepository theatreRepository;

    @Test
    public void shouldReturnShowsForId() {
        DBTheatre dbTheatre = theatreRepository.getTheatreById(1);
        Assert.assertEquals("Theatre should be PVR", "PVR", dbTheatre.getName());
    }
}
