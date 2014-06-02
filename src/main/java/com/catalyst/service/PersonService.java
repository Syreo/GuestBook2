package com.catalyst.service;

import com.catalyst.model.Person;

import java.util.List;

public interface PersonService {

    void savePerson(Person person);

    List<Person> findAllPerson();

    Person findByEmail(String email);

}
