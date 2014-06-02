package com.catalyst.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.catalyst.dao.PersonDao;
import com.catalyst.model.Person;

@Repository("personDao")
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

  public Person findByName(String name) {
    TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByName", Person.class);
    return query.setParameter("name", name).getSingleResult();
  }

  public Person findByEmail(String email) {
    TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByEmail", Person.class);
    return query.setParameter("email", email).getSingleResult();
  }

  public Person create(Person t) {
    // TODO Auto-generated method stub
    return null;
  }

  public void delete(Object id) {
    // TODO Auto-generated method stub

  }

  public Person find(Object id) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Person> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  public Person update(Person t) {
    // TODO Auto-generated method stub
    return null;
  }

}
