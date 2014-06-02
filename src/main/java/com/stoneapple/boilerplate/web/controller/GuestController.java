package com.stoneapple.boilerplate.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catalyst.dao.UserDao;
import com.catalyst.model.User;

@Component
@ViewScoped
@ManagedBean
public class GuestController {

  @Autowired
  private UserDao userDao;

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



  public void addGuest() {
    User user = new User();
    user.setAddress(address);
    user.setEmail(email);
    user.setName(name);
    user.setQty(qty);
    userDao.persist(user);


  }



  public UserDao getUserDao() {
    return userDao;
  }



  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
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

}
