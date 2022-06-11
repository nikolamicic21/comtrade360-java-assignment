package io.nikolamicic21.comtrade360javaassignment.config;

import io.nikolamicic21.comtrade360javaassignment.model.Hello;
import io.nikolamicic21.comtrade360javaassignment.repository.HelloRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Configuration(proxyBeanMethods = false)
public class ApplicationConfiguration {

    @Bean
    @Profile("db")
    public ApplicationRunner applicationRunner(HelloRepository helloRepository) {
        return args -> {
            final var helloMessagesCount = helloRepository.count();
            if (helloMessagesCount == 0) {
                final var helloMessages = Set.of(
                        new Hello("Hello World", "en"),
                        new Hello("Zdravo svete", "sr"),
                        new Hello("你好世界", "zh"),
                        new Hello("Bonjour le monde", "fr"),
                        new Hello("Hallo Welt", "de"),
                        new Hello("Γειά σου Κόσμε", "el"),
                        new Hello("नमस्ते दुनिया", "hi"),
                        new Hello("Ciao mondo", "it"),
                        new Hello("こんにちは世界", "ja"),
                        new Hello("salve mundi", "la")
                );
                helloRepository.saveAll(helloMessages);
            }
        };
    }

}
