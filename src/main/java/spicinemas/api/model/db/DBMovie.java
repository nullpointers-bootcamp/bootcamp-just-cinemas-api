package spicinemas.api.model.db;

import spicinemas.api.model.Language;
import spicinemas.api.type.MovieListingType;

public class DBMovie {

    private Long id;
    private String name;
    private String experiences;
    private MovieListingType listingType;
    private Language language;
    private String imageName;
    private String stills;
    private String synopsis;

    public DBMovie() {
    }

    public DBMovie(Long id, String name, String experiences, MovieListingType listingType, Language language, String imageName, String stills, String synopsis) {
        this.id = id;
        this.name = name;
        this.experiences = experiences;
        this.listingType = listingType;
        this.language = language;
        this.imageName = imageName;
        this.stills = stills;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public MovieListingType getListingType() {
        return listingType;
    }

    public void setListingType(MovieListingType listingType) {
        this.listingType = listingType;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getStills() {
        return stills;
    }

    public void setStills(String stills) {
        this.stills = stills;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
