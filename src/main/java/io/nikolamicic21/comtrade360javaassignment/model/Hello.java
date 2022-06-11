package io.nikolamicic21.comtrade360javaassignment.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "language")
    private String language;

    public Hello(@NonNull String message, @NonNull String language) {
        this.message = message;
        this.language = language;
    }
}
