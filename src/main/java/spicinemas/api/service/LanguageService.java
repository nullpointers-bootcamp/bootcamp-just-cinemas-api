package spicinemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.LanguageRepository;
import spicinemas.api.model.Language;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public List<Language> getLanguage() {
        return languageRepository.getLanguage();
    }
}
