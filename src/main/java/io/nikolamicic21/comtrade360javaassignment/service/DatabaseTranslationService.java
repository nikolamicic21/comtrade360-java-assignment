package io.nikolamicic21.comtrade360javaassignment.service;

import io.nikolamicic21.comtrade360javaassignment.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db")
@RequiredArgsConstructor
public class DatabaseTranslationService implements TranslationService {

    private final HelloRepository helloRepository;

    @Override
    public String getHelloWorldTranslation(String lang) {
        return this.helloRepository.findByLanguage(lang).get().getMessage();
    }
}
