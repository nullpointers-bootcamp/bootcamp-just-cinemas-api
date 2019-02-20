package spicinemas.api.model;

import java.util.List;

public class Screen {
    private String name;
    private int numberOfRows;
    private int numberOfColumns;
    private List<Show> shows;

    public Screen(String name, int numberOfRows, int numberOfColumns, List<Show> shows) {
        this.name = name;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.shows = shows;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public List<Show> getShows() {
        return shows;
    }
}





