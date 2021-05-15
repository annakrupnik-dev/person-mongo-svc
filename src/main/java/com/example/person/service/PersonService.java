package com.example.person.service;


import com.example.person.db.data.Person;
import com.example.person.db.data.PersonDataWrapper;

public interface PersonService {
    PersonDataWrapper getAllPersons();
    Person getPersonById(String personId);
    Person updatePerson(String personId, Person inputData);
    Person createPerson(Person person);
    boolean deletePerson(String personId);
}