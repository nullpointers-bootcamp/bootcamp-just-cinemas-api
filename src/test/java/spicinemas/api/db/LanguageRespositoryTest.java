package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.type.Language;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LanguageRespositoryTest {

    @Autowired
    LanguageRepository repository;

    @Autowired
    DSLContext dslContext;

    @Before
    public void initalize() {
        dslContext.delete(DSL.table("LANGUAGE")).execute();
    }

    @Test
    public void shouldNotReturnAllLanguagesWhenItsNotAvailable() {
        List<spicinemas.api.model.Language> languageList = repository.getLanguage();

        Assert.assertEquals("should return 0 languages", 0, languageList.size());
    }

    @Test
    public void shouldReturnAllLanguagesWhenAvailable() {
        dslContext.insertInto(DSL.table("LANGUAGE"), DSL.field("id"), DSL.field("name"))
                .values(1, "English")
                .values(2, "Tamil")
                .values(3, "Telugu")
                .values(4, "Hindi")
                .values(5, "Malayalam")
                .values(6, "Kannada")
                .execute();

        List<spicinemas.api.model.Language> languageList = repository.getLanguage();

        Assert.assertEquals("should return 6 languages", 6, languageList.size());
        Assert.assertEquals("English Language should be available", "English", languageList.get(0).getName());
    }
}
