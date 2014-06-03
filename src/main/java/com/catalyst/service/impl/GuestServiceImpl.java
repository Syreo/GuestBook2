package com.catalyst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.dao.UserDao;
import com.catalyst.model.User;
import com.catalyst.service.GuestService;

@Service("guestService")
@Transactional(propagation = Propagation.REQUIRED)
public class GuestServiceImpl implements GuestService {


  @Autowired
  private UserDao userDao;

  public void addGuest(User user) {

    userDao.persist(user);

  }

  /**
   * 
   * @return
   */

  public List<User> getAllGuests() {

    return userDao.getAllGuests();

  }

}
