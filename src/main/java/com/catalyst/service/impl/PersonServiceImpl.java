package com.catalyst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.dao.PersonDao;
import com.catalyst.model.Person;
import com.catalyst.service.PersonService;

@Service("personService")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonDao personDao;

  public void savePerson(Person person) {
    personDao.create(person);
  }

  public List<Person> findAllPerson() {
    return personDao.findAll();
  }

  public Person findByEmail(String email) {
    return personDao.findByEmail(email);
  }

}
