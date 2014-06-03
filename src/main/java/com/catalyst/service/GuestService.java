package com.catalyst.service;

import java.util.List;

import com.catalyst.model.User;

public interface GuestService {

  void addGuest(User user);


  List<User> getAllGuests();

}
