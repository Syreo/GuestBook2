package com.catalyst.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.dao.UserDao;
import com.catalyst.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName = "GuestBookPU")
	private EntityManager em;

	/**
	 * sets the entity manager
	 * 
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * persists a user
	 * 
	 * @param user
	 */
	@Transactional
	public boolean persist(User user) {
		boolean isSuccessful = true;
		try {
			em.persist(user);

		} catch (Exception e) {
			isSuccessful = false;

		}
		return isSuccessful;
	}

}
