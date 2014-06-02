package com.catalyst.dao;

import com.catalyst.model.Person;

public interface PersonDao extends GenericDao<Person> {

    Person findByName(String name);

    Person findByEmail(String email);

}
