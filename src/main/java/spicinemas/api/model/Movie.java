package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;
@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String name;
    private String experiences;
    private MovieListingType listingType;
    private Language language;
    String imageName;
    String stills;
    String synopsis;


    public Movie(Long id, String name, String experiences, MovieListingType listingType, Language language, String imageName, String stills, String synopsis) {
        this.id = id;
        this.name = name;
        this.experiences = experiences;
        this.listingType = listingType;
        this.language = language;
        this.imageName = imageName;
        this.stills = stills;
        this.synopsis = synopsis;
    }


    public Language getLanguage() {
        return language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExperiences() {
        return experiences;
    }

    public MovieListingType getListingType() {
        return listingType;
    }

    public String getImageName() {
        return imageName;
    }

    public String getStills() {
        return stills;
    }

    public String getSynopsis() {
        return synopsis;
    }
}