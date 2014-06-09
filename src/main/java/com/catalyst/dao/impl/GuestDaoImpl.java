package com.catalyst.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.dao.GuestDao;
import com.catalyst.model.Guest;

@Repository("guestDao")
public class GuestDaoImpl implements GuestDao {

  @PersistenceContext(unitName = "GuestBookPU")
  private EntityManager em;

//  @Autowired
//  private SessionFactory sessionFactory;
  
  /**
   * sets the entity manager
   * 
   * @param em
   */
  public void setEm(EntityManager em) {
    this.em = em;
  }

  /**
   * persists a guest
   * 
   * @param guest
   */
  @Transactional
  public String persist(Guest guest) {
    String response = "";
    try {
      em.persist(guest);
      response = "Successfully Added Guest";

    } catch (Exception e) {
      response = "Could not add guest";

    }
    return response;
  }

  @Transactional
  public List<Guest> getAllGuests() {
    List<Guest> guestList = new ArrayList<Guest>();
    Query query = em.createNamedQuery("getAllGuests");
    guestList = query.getResultList();

    return guestList;


  }
  
  @Transactional
  public String updateGuest(Guest guest){
	  String response = "";
	  try{
//		  guest = (Guest) getSessionFactory().getCurrentSession().merge(guest);
	  em.merge(guest); 
	  response = "Guest Updated";
	  }catch(Exception e){
		  response = "Error updating guest";
	  }
	  
	  return response;
  }
  
  @Transactional
  public String deleteGuest(Guest guest){
	  String response = "";
	  Query query = em.createNamedQuery("deleteGuestById");
	  try{
			query.setParameter("id", guest.getId()).executeUpdate();
			response = "Guest Deleted Successfully";
	  }catch(Exception e){
		  response = "Guest could not be deleted";
	  }
			return response;
  }
  
  @Transactional
  public Guest getGuestById(String id){
	  Guest guest = new Guest();
	  Query query = em.createNamedQuery("getGuestById");
		query.setParameter("id", id);
		try {
			guest = (Guest) query.getSingleResult();

		} catch (RuntimeException e) {

		}
	  
	  return guest;
  }
  
//  
//  public SessionFactory getSessionFactory() {
//      return sessionFactory;
//  }
//
//  /**
//   * Set Hibernate Session Factory
//   *
//   * @param sessionFactory SessionFactory - Hibernate Session Factory
//   */
//  public void setSessionFactory(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//  }

}
