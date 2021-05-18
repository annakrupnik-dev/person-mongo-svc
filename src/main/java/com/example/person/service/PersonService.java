package com.example.person.service;


import com.example.person.db.data.Person;
import com.example.person.db.data.PersonDataWrapper;

public interface PersonService {
    PersonDataWrapper getAllPersons();
    Person getPersonById(String personId);
    Person updatePerson(Long personId, Person inputData);
    Person createPerson(Person person);
    boolean deletePerson(Long personId);
    Person getPersonByPersonId(Long personId);
}