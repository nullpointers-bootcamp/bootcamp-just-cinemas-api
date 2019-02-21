package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.controller.LanguageController;
import spicinemas.api.model.Language;
import spicinemas.api.service.LanguageService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LanguageControllerTest {

    @Mock
    LanguageService languageService;

    @InjectMocks
    LanguageController languageController;

    @Test
    public void shouldReturnAllLanguagesWhenAvailable() {
        List<Language> languageList = new ArrayList<>();
        languageList.add(new Language(1, "English"));
        languageList.add(new Language(2, "Tamil"));

        when(languageService.getLanguage()).thenReturn(languageList);

        Assert.assertArrayEquals(languageList.toArray(),languageController.get().toArray());
    }

    @Test
    public void shouldNotReturnAllLanguagesWhenItsNotAvailable() {

        when(languageService.getLanguage()).thenReturn(new ArrayList<>());

        Assert.assertArrayEquals(new ArrayList<>().toArray(),languageController.get().toArray());
    }
}
