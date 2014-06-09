package com.catalyst.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.catalyst.model.Guest;
import com.catalyst.service.GuestService;

@Controller
@ManagedBean
@ViewScoped
public class GuestController implements Serializable{

  @Autowired
  private GuestService guestService;

  private static final long serialVersionUID = 1L;
  List<Guest> guestList;
  private String name;
  private String address;
  private String qty;
  private String email;
  private int version;
  private int id;
  /**
   * adds a guest to the database
   */
  public String addGuest() {
    Guest guest = new Guest();
    guest.setAddress(address);
    guest.setEmail(email);
    guest.setName(name);
    guest.setQty(qty);
    String response = guestService.addGuest(guest);
    FacesMessage msg = new FacesMessage(response);
    FacesContext.getCurrentInstance().addMessage(null, msg);

    return "guestList";
  }
  


  /**
   * gets all guests
   * 
   * @return
   */
  public List<Guest> getAllGuests() {
	  //Checks to see if the guestlist is null or out of date
	  if(guestList == null || !(guestList.size() == guestService.getAllGuests().size())){
    guestList = new ArrayList<Guest>();
    guestList = guestService.getAllGuests();
	  }
    return guestList;

  }
  
  private void updateGuestBean(Guest guest){
	  
	  setName(guest.getName());
	  setId(guest.getId());
	  setAddress(guest.getAddress());
	  setEmail(guest.getEmail());
	  setQty(guest.getQty());
//	  setVersion(guest.getVersion());
  }
  
  public void updateGuest(RowEditEvent event){
	  Guest guest = new Guest();
	  guest.setId(((Guest)event.getObject()).getId());
	  guest.setAddress(((Guest)event.getObject()).getAddress());
	  guest.setEmail(((Guest)event.getObject()).getEmail());
	  guest.setName(((Guest)event.getObject()).getName());
	  guest.setQty(((Guest)event.getObject()).getQty());
	  String response = guestService.updateGuest(guest);
//	  updateGuestBean(guest);
	  FacesMessage msg = new FacesMessage(response);
      FacesContext.getCurrentInstance().addMessage(null, msg);
	  
	  
  }
  
  public void resetGuest(){
	  setName(null);
	  setId(0);
	  setAddress(null);
	  setEmail(null);
	  setQty(null);
	  setVersion(0);
  }
  
  public void deleteGuest(Guest guest){
	  
	  String response = guestService.deleteGuest(guest);
	  FacesMessage msg = new FacesMessage(response);
      FacesContext.getCurrentInstance().addMessage(null, msg);
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

  public List<Guest> getGuestList() {
    return guestList;
  }

  public void setGuestList(List<Guest> guestList) {
    this.guestList = guestList;
  }



/**
 * @return the version
 */
public int getVersion() {
	return version;
}



/**
 * @param version the version to set
 */
public void setVersion(int version) {
	this.version = version;
}



/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}



/**
 * @return the id
 */
public int getId() {
	return id;
}



/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}








}
