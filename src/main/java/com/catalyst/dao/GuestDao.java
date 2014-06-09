package com.catalyst.dao;

import java.util.List;

import com.catalyst.model.Guest;



public interface GuestDao {


  String persist(Guest guest);

  List<Guest> getAllGuests();

  Guest getGuestById(String id);
  
  String updateGuest(Guest guest);
  
  String deleteGuest(Guest guest);

}
