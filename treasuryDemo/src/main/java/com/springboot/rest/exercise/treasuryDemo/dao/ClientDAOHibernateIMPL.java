package com.springboot.rest.exercise.treasuryDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.exercise.treasuryDemo.entity.Client;

@Repository
public class ClientDAOHibernateIMPL implements ClientDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public ClientDAOHibernateIMPL(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Client> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);
		
		// execut query and get result list
		List<Client> clients = theQuery.getResultList();
		
		// return the results
		return clients;
	}

}
