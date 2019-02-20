package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.ScreenRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.db.TheatreRepository;
import spicinemas.api.dto.ShowInformation;
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

    public List<ShowInformation> getShowsByDateAndMovieId(String date, int movieId) throws ParseException {
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
            showInformation.setScreenId(screen.getId());
            showInformation.setScreenName(screen.getName());
            DBTheatre theatre = theatreRepository.getTheatreById(screen.getTheatreId());
            showInformation.setTheatreId(theatre.getId());
            showInformation.setTheatreName(theatre.getName());
            showInformationList.add(showInformation);
        }
        return showInformationList;

    }
}
