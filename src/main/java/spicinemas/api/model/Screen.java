package spicinemas.api.model;

import java.util.List;

public class Screen {
    String name;
    String screenExperience;
    String isActive;
    List<Show> shows;

   public Screen(String name, String screenExperience, String isActive, List<Show> shows) {
        this.name = name;
        this.screenExperience = screenExperience;
        this.isActive = isActive;
        this.shows = shows;
    }

    public String getName() {
        return name;
    }

    public String getScreenExperience() {
        return screenExperience;
    }

    public String getIsActive() {
        return isActive;
    }

    public List<Show> getShows() {
        return shows;
    }
}





