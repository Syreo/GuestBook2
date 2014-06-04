package com.catalyst;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.catalyst.model.User;
import com.catalyst.service.GuestService;

@Controller
@ManagedBean
@Scope("request")
public class GuestController {

  @Autowired
  private GuestService guestService;

  // @ManagedProperty(value = "#{person}")
  // private Person person;

  // @ManagedProperty(value = "#{user}")
  // private User user;
  //
  // public GuestController() {
  // user = new User();
  // }

  List<User> guestList;
  private String name;
  private String address;
  private String qty;
  private String email;


  /**
   * adds a guest to the database
   */
  public void addGuest() {
    User user = new User();
    user.setAddress(address);
    user.setEmail(email);
    user.setName(name);
    user.setQty(qty);
    guestService.addGuest(user);


  }

  /**
   * gets all guests
   * 
   * @return
   */
  // @RequestMapping(value = "/GetAllGuests", produces = "application/json", method =
  // RequestMethod.GET)
  public List<User> getAllGuests() {
    guestList = new ArrayList<User>();
    guestList = guestService.getAllGuests();
    // Response response = new Response();
    // response.setResponse();
    return guestList;

  }


  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getAddress() {
    return address;
  }



  public void setAddress(String address) {
    this.address = address;
  }



  public String getQty() {
    return qty;
  }



  public void setQty(String qty) {
    this.qty = qty;
  }



  public String getEmail() {
    return email;
  }



  public void setEmail(String email) {
    this.email = email;
  }



  /**
   * @return the guestService
   */
  public GuestService getGuestService() {
    return guestService;
  }



  /**
   * @param guestService the guestService to set
   */
  public void setGuestService(GuestService guestService) {
    this.guestService = guestService;
  }

  public List<User> getGuestList() {
    return guestList;
  }

  public void setGuestList(List<User> guestList) {
    this.guestList = guestList;
  }

}
