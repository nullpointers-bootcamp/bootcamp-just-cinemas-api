package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.ScreenRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.db.TheatreRepository;
import spicinemas.api.dto.ShowInformation;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.exception.SeatsFullForShowException;
import spicinemas.api.model.ShowSeatViewModel;
import spicinemas.api.model.db.DBScreen;
import spicinemas.api.model.db.DBShow;
import spicinemas.api.model.db.DBTheatre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ScreenRepository screenRepository;

    public List<ShowInformation> getShowsByDateAndMovieId(String date, int movieId) throws ParseException, ScreenNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<DBShow> dbShows = showRepository.getShowsByDateAndMovieId(sdf.parse(date), movieId);
        List<ShowInformation> showInformationList = new ArrayList<>();
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
        for (DBShow dbShow : dbShows) {
            ShowInformation showInformation = new ShowInformation();
            showInformation.setDate(date);
            showInformation.setTime(sdfTime.format(dbShow.getTime()));
            showInformation.setShowId(dbShow.getId());
            DBScreen screen = screenRepository.getScreenById(dbShow.getScreenId());
            if (screen == null)
                throw new ScreenNotFoundException("Screen could not be found");
            showInformation.setScreenId(screen.getId());
            showInformation.setScreenName(screen.getName());
            DBTheatre theatre = theatreRepository.getTheatreById(screen.getTheatreId());
            showInformation.setTheatreId(theatre.getId());
            showInformation.setTheatreName(theatre.getName());
            showInformationList.add(showInformation);
        }
        return showInformationList;

    }


    public ShowSeatViewModel getShowSeatInformation(int showId) throws SeatsFullForShowException, ScreenNotFoundException {
        List<String> bookedSeats = showRepository.getSeatsBookedByShowId(showId);
        DBScreen screen = screenRepository.getScreenByShowId(showId);
        if (screen == null)
            throw new ScreenNotFoundException("Screen could not be found");
        if (bookedSeats.size() == screen.getNumberOfColumns() * screen.getNumberOfRows())
            throw new SeatsFullForShowException("Seats are full for this show");
        return new ShowSeatViewModel(screen.getNumberOfRows(), screen.getNumberOfColumns(), bookedSeats.toArray(new String[0]));
    }
}
