package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.db.DBShow;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    DSLContext dslContext;

    @Before
    public void initialize()
    {
        dslContext.delete(DSL.table("TRANSACTION_SEATS")).execute();
        dslContext.delete(DSL.table("TRANSACTION")).execute();
    }
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

    @Test
    public void shouldReturnZeroSeatsWhenNoTicketsAreBookedForShow()
    {
        List<String> bookedSeats=showRepository.getSeatsBookedByShowId(18);
        Assert.assertArrayEquals("should return 3 seats for show id 18", new String[0],bookedSeats.toArray());
    }

    @Test
    public void shouldReturnSeatsBookedForShowWhenSeatsAreBooked()
    {
        dslContext.insertInto(DSL.table("TRANSACTION"), DSL.field("ID"),DSL.field("EMAIL_ID")
                ,DSL.field("BOOKING_REF_NUMBER"),DSL.field("SHOW_ID"),
                DSL.field("PAYMENT_TYPE"),DSL.field("IS_CANCELLED"))
                .values(1,"sam@tht.com","SAM132",18,"CASH",false)
                .values(2,"mas@tht.com","MAS132",18,"CASH",false)
                .execute();
        dslContext.insertInto(DSL.table("TRANSACTION_SEATS"), DSL.field("TRANSACTION_ID"),DSL.field("SEAT_NUMBER"))
                .values(1,"A1")
                .values(2,"B1")
                .execute();
        List<String> bookedSeats=showRepository.getSeatsBookedByShowId(18);
        List<String> expectedSeats = new ArrayList<>();
        expectedSeats.add("A1");
        expectedSeats.add("B1");
        Assert.assertArrayEquals("should return 3 seats for show id 18",expectedSeats.toArray(),bookedSeats.toArray());
    }

}
