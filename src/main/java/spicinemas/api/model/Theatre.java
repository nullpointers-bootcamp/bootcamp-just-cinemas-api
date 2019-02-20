package spicinemas.api.model;

import java.util.List;

public class Theatre {
    private int id;
    private String name;
    private boolean isActive;
    private List<Screen> screens;

    public Theatre(int id, String name, boolean isActive, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.screens = screens;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
