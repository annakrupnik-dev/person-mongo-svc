package com.example.person.service.impl;

import com.example.person.db.data.Person;
import com.example.person.db.data.PersonDataWrapper;
import com.example.person.db.repository.mongodb.PersonRepository;
import com.example.person.exception.ResourceNotFoundException;
import com.example.person.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public PersonDataWrapper getAllPersons() {
        List<Person> persons = personRepository.findAll();
        PersonDataWrapper personDataWrapper = new PersonDataWrapper();
        personDataWrapper.setPersons(persons);
        return personDataWrapper;
    }

    @Override
    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }

    @Override
    public Person updatePerson(Integer personId, Person inputData) {

        return personRepository.findById(personId).map(person -> {
            person.setName(inputData.getName());
            person.setHeight(inputData.getHeight());
            person.setGender(inputData.getGender());
            person.setWeight(inputData.getWeight());
            person.setAge(inputData.getAge());
            return personRepository.save(person);
        }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }

    @Override
    public Person createPerson(Person person) {
            return personRepository.insert(person);
    }

    @Override
    public boolean deletePerson(Integer personId) {
        return personRepository.findById(personId).map(person -> {
            personRepository.delete(person);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }
}
