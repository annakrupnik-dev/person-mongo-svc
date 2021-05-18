package com.example.person.service.impl;

import com.example.person.db.data.Person;
import com.example.person.db.data.PersonDataWrapper;
import com.example.person.db.repository.mongodb.PersonRepository;
import com.example.person.exception.ResourceNotFoundException;
import com.example.person.service.PersonService;
import com.example.person.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Lazy
@Service
@NoArgsConstructor
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public PersonDataWrapper getAllPersons() {
        List<Person> persons = personRepository.findAll();
        PersonDataWrapper personDataWrapper = new PersonDataWrapper();
        personDataWrapper.setPersons(persons);
        return personDataWrapper;
    }

    @Override
    public Person getPersonById(String personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }

    @Override
    public Person getPersonByPersonId(Long personId) {
        return personRepository.findByPersonId(personId)
                .orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }

    @Override
    public Person updatePerson(Long personId, Person inputData) {

        return personRepository.findByPersonId(personId).map(person -> {
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
            person.setPersonId(sequenceGeneratorService.generateSequence(Person.SEQUENCE_NAME));
            return personRepository.save(person);
    }

    @Override
    public boolean deletePerson(Long personId) {
        return personRepository.findByPersonId(personId).map(person -> {
            personRepository.delete(person);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + "not found"));
    }
}
