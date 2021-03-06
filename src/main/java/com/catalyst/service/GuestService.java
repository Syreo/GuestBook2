package com.catalyst.service;

import java.util.List;

import com.catalyst.model.Guest;

public interface GuestService {

  String addGuest(Guest guest);


  List<Guest> getAllGuests();
  
  String updateGuest(Guest guest);
  
  String deleteGuest(Guest guest);

}
