package com.example.person.db.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonDataWrapper {

    private List<Person> persons = new ArrayList<>();
}
