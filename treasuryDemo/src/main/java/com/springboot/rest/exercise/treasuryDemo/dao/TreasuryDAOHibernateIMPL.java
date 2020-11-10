package com.springboot.rest.exercise.treasuryDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.exercise.treasuryDemo.entity.Treasury;

@Repository
public class TreasuryDAOHibernateIMPL implements TreasuryDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public TreasuryDAOHibernateIMPL(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Treasury> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Treasury> theQuery = currentSession.createQuery("from Treasury", Treasury.class);
		
		// execut query and get result list
		List<Treasury> treasuries = theQuery.getResultList();
		
		// return the results
		return treasuries;
	}

}
