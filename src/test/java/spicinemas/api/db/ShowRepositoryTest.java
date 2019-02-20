package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.db.DBShow;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {

    @Autowired
    private ShowRepository showRepository;

    @Test
    public void shouldReturnShowsForGivenDateAndMovieId() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Month.FEBRUARY.getValue(), 14);
        Date date = calendar.getTime();
        List<DBShow> shows = showRepository.getShowsByDateAndMovieId(date, 1);
        Assert.assertEquals("Total no of shows should be 3", 1, shows.size());
    }

    @Test
    public void shouldReturnShowsForId() {
        DBShow show = showRepository.getShowdById(18);
        Assert.assertEquals("Show should be of id 1", 18, show.getId());
    }

}
