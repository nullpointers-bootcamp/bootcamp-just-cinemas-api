package spicinemas.api.model.db;

import spicinemas.api.type.Language;

public class DBLanguage {

    private int id;
    private Language name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Language getName() {
        return name;
    }

    public void setName(Language name) {
        this.name = name;
    }
}
