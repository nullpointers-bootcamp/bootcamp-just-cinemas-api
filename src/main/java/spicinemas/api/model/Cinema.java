package spicinemas.api.model;

import java.util.List;

public class Cinema {
  String name;
  List<Screen> screens;
  boolean isActive;

    public Cinema(String name, List<Screen> screens, boolean isActive) {
        this.name = name;
        this.screens = screens;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public boolean isActive() {
        return isActive;
    }
}
