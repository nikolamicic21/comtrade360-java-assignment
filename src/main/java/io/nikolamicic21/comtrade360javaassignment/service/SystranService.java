package io.nikolamicic21.comtrade360javaassignment.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Profile("external")
public class SystranService implements TranslationService {

    private final RestTemplate restTemplate;

    public SystranService(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${app.systran.api-key}") String apiKey
    ) {
        this.restTemplate = restTemplateBuilder
                .rootUri("https://api-translate.systran.net")
                .defaultHeader("Authorization", "Key " + apiKey)
                .build();
    }

    @Override
    public String getHelloWorldTranslation(String lang) {
        return this.restTemplate.postForObject(
                        "/translation/text/translate?target=" + lang + "&input=Hello World",
                        null,
                        TranslationResponse.class
                ).getOutputs().stream()
                .findFirst()
                .get()
                .output;
    }

    @Data
    static class TranslationResponse {

        private List<OutputResponse> outputs;

        @Data
        static class OutputResponse {

            private String output;

        }

    }

}
