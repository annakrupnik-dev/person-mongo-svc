package com.example.person.service;


import com.example.person.db.data.Person;
import com.example.person.db.data.PersonDataWrapper;

public interface PersonService {
    PersonDataWrapper getAllPersons();
    Person getPersonById(Integer personId);
    Person updatePerson(Integer personId, Person inputData);
    Person createPerson(Person person);
    boolean deletePerson(Integer personId);
}