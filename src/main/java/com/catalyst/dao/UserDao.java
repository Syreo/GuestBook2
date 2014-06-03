package com.catalyst.dao;

import java.util.List;

import com.catalyst.model.User;



public interface UserDao {


  boolean persist(User user);

  List<User> getAllGuests();


}
