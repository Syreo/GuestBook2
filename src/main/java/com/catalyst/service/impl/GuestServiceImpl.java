package com.catalyst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.dao.GuestDao;
import com.catalyst.model.Guest;
import com.catalyst.service.GuestService;

@Service("guestService")
@Transactional(propagation = Propagation.REQUIRED)
public class GuestServiceImpl implements GuestService {


  @Autowired
  private GuestDao guestDao;

  public String addGuest(Guest guest) {

    String response = guestDao.persist(guest);

    return response;
  }

  /**
   * 
   * @return
   */

  public List<Guest> getAllGuests() {

    return guestDao.getAllGuests();

  }
  
  public String updateGuest(Guest guest){
	  
	  String response = guestDao.updateGuest(guest);
	  
	return response;
  }
  
  
  public String deleteGuest(Guest guest){
	  String response = guestDao.deleteGuest(guest);
	  return response;
  }

}
