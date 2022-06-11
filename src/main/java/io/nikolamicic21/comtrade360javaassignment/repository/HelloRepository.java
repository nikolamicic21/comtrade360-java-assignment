package io.nikolamicic21.comtrade360javaassignment.repository;

import io.nikolamicic21.comtrade360javaassignment.model.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Long> {

    Optional<Hello> findByLanguage(String language);

}
