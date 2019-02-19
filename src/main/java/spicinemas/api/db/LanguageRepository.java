package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.DBLanguage;
import spicinemas.api.type.Language;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class LanguageRepository {

    @Autowired
    private DSLContext dsl;
    private Map<Integer, Language> languageMap;

    private Map<Integer, Language> getAllLanguagesAsMap() {
        List<DBLanguage> dbLanguages = dsl.select()
                .from(DSL.table("LANGUAGE"))
                .fetchInto(DBLanguage.class);
        Map<Integer, Language> languages = new HashMap<>(4);
        for (DBLanguage language : dbLanguages) {
            languages.put(language.getId(), language.getName());
        }
        return languages;
    }

    public Map<Integer, Language> getLanguageMap() {
        if (languageMap == null)
            languageMap = getAllLanguagesAsMap();
        return languageMap;
    }
}
