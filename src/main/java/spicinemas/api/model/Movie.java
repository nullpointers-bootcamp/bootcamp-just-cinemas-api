package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.Language;
import spicinemas.api.type.MovieListingType;

import java.util.List;

@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String slug;
    private String name;
    private String experiences;
    private MovieListingType listingType;
    private Language language;
    private String imageName;
    private List<String> stills;
    private String synopsis;

    public Movie(String name, String experiences, MovieListingType listingType) {
        this.name = name;
        this.experiences = experiences;
        this.listingType = listingType;
    }

    public Movie(String name, MovieListingType listingType, Language language) {
        this.name = name;
        this.listingType = listingType;
        this.language = language;
    }

    public Movie() {
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

    public List<String> getStills() {
        return stills;
    }

    public void setStills(List<String> stills) {
        this.stills = stills;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}