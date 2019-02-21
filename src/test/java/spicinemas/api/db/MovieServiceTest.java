package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Movie;
import spicinemas.api.model.db.DBMovie;
import spicinemas.api.service.MovieService;
import spicinemas.api.type.Language;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @Mock
    LanguageRepository languageRepository;

    @InjectMocks
    MovieService movieService;

    @Test
    public void shouldReturnMoviebyId() {
        when(movieRepository.getMovieById(Mockito.anyLong())).thenReturn(new DBMovie(1l,"Toy story 4","RDX, Dolby Atmos, SUB",MovieListingType.NOW_SHOWING,new spicinemas.api.model.Language(1,"English"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(1, Language.English);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        long id = 1;
        Movie movie = movieService.getMovieById(id);
        Assert.assertEquals("The movie name should be ", "Toy story 4", movie.getName());

    }

    @Test
    public void shouldReturnNowShowingMovies() {
        List<DBMovie> movies = new ArrayList<>();
        movies.add(new DBMovie(1l,"Toy story 4","RDX, Dolby Atmos, SUB",MovieListingType.NOW_SHOWING,new spicinemas.api.model.Language(1,"English"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        movies.add(new DBMovie(1l,"Toy story 3","RDX, Dolby Atmos, SUB",MovieListingType.NOW_SHOWING,new spicinemas.api.model.Language(1,"English"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        when(movieRepository.getNowShowingMovies()).thenReturn(movies);
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(1, Language.English);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        List<Movie> actualMovies = movieService.getNowShowingMovies();
        Assert.assertEquals("Should fetch now showing movies", 2, actualMovies.size());
    }

    @Test
    public void shouldReturnAllUpComingMovies() {
        List<DBMovie> movies = new ArrayList<>();
        movies.add(new DBMovie(1l,"Toy story 4","RDX, Dolby Atmos, SUB",MovieListingType.UPCOMING,new spicinemas.api.model.Language(1,"English"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        when(movieRepository.getUpcomingMovies()).thenReturn(movies);
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(1, Language.English);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        List<Movie> actualMovies = movieService.getUpComingMovies();
        Assert.assertEquals("Should fetch upcoming movies", 1, actualMovies.size());
    }

    @Test
    public void shouldNotReturnUpComingMoviesWhenThereAreNoUpComingMovies() {
        List<DBMovie> movies = new ArrayList<>();
        when(movieRepository.getUpcomingMovies()).thenReturn(movies);
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(1, Language.English);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        List<Movie> actualMovies = movieService.getUpComingMovies();
        Assert.assertEquals("Should fetch upcoming movies", 0, actualMovies.size());
    }

    @Test
    public void shouldReturnAllUpcomingMoviesByLanguage() {
        List<DBMovie> movies = new ArrayList<>();
        int id = 2;
        movies.add(new DBMovie(1l,"Toy story 4","RDX, Dolby Atmos, SUB",MovieListingType.UPCOMING,new spicinemas.api.model.Language(2,"Tamil"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        movies.add(new DBMovie(1l,"Toy story 4","RDX, Dolby Atmos, SUB",MovieListingType.UPCOMING,new spicinemas.api.model.Language(2,"Tamil"),"toystory","toystory1,toystory2","A man attempts to protect his family from enemies, gained in his time as a gangster. After he is released from prison on false charges, he resumes his post as gang leader and continues a long-held rivalry."));
        when(movieRepository.getUpcomingMoviesByLanguage(Mockito.anyInt())).thenReturn(movies);
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(2, Language.Tamil);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        List<Movie> actualMovies = movieService.getUpComingMoviesByLanguage(id);
        Assert.assertEquals("Should fetch upcoming movies", 2, actualMovies.size());
    }

    @Test
    public void shouldNotReturnUpComingMoviesWhenThereAreNoUpComingMoviesForTheGivenLanguage() {
        List<DBMovie> movies = new ArrayList<>();
        int id = 2;
        when(movieRepository.getUpcomingMoviesByLanguage(Mockito.anyInt())).thenReturn(movies);
        Map<Integer, Language> languageMap = new HashMap<>();
        languageMap.put(2, Language.Tamil);
        when(languageRepository.getLanguageMap()).thenReturn(languageMap);
        List<Movie> actualMovies = movieService.getUpComingMoviesByLanguage(id);
        Assert.assertEquals("Should fetch upcoming movies", 0, actualMovies.size());
    }


}
