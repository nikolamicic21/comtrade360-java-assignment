package io.nikolamicic21.comtrade360javaassignment.controller;

import io.nikolamicic21.comtrade360javaassignment.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloRestController {

    private final TranslationService translationService;

    @GetMapping("/hello-rest")
    public String getHelloWorld(
            @RequestParam(name = "lang", defaultValue = "en") String lang
    ) {
        return this.translationService.getHelloWorldTranslation(lang);
    }

}
