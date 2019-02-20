package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.ScreenRepository;
import spicinemas.api.exception.ScreenNotFoundException;
import spicinemas.api.model.db.DBScreen;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    public DBScreen getScreen(int id) throws ScreenNotFoundException {
        DBScreen screen = screenRepository.getScreenById(id);
        if (screen == null)
            throw new ScreenNotFoundException("Screen not found exception");
        return screen;
    }

    public DBScreen getScreenByShowId(int showId) throws ScreenNotFoundException {
        DBScreen screen = screenRepository.getScreenByShowId(showId);
        if (screen == null)
            throw new ScreenNotFoundException("Screen not found exception");
        return screen;
    }
}
