package com.example.person.db.repository.mongodb;

import com.example.person.db.data.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByName (String name);
    Optional<Person> findByPersonId(Long personId);
}
