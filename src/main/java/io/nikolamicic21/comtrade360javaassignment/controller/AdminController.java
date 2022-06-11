package io.nikolamicic21.comtrade360javaassignment.controller;

import io.nikolamicic21.comtrade360javaassignment.model.Hello;
import io.nikolamicic21.comtrade360javaassignment.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HelloRepository helloRepository;

    @GetMapping
    public String getLanguagesForm() {
        return "languages-form";
    }

    @PostMapping
    public String postLanguageForm(Hello hello) {
        this.helloRepository.save(hello);
        return "redirect:/admin";
    }

}
