package spicinemas.api.model.db;

public class DBScreen {

    private int id;
    private String name;
    private int threatreId;
    private int numberOfRows;
    private int numberOfColumns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThreatreId() {
        return threatreId;
    }

    public void setThreatreId(int threatreId) {
        this.threatreId = threatreId;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }
}
