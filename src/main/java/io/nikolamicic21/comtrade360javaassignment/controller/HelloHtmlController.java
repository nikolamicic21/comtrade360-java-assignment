package io.nikolamicic21.comtrade360javaassignment.controller;

import io.nikolamicic21.comtrade360javaassignment.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HelloHtmlController {

    private final TranslationService translationService;

    @GetMapping("/hello")
    public String getHelloWorld(
            @RequestParam(name = "lang", defaultValue = "en") String lang,
            Model model
    ) {
        model.addAttribute(
                "helloMessage",
                this.translationService.getHelloWorldTranslation(lang)
        );

        return "hello-world";
    }

    @GetMapping("/secure/hello")
    public String getSecureHello() {
        return "redirect:/hello";
    }

}
