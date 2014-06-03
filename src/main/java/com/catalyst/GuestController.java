package com.catalyst;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catalyst.model.User;
import com.catalyst.service.GuestService;
import com.catalyst.utils.Response;

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
  @RequestMapping(value = "/GetAllGuests", produces = "application/json", method = RequestMethod.GET)
  public Response getAllGuests() {

    Response response = new Response();
    response.setResponse(guestService.getAllGuests());
    return response;

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

}
