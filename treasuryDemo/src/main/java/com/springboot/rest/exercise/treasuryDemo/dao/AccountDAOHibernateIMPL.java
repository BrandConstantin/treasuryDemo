package com.springboot.rest.exercise.treasuryDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.exercise.treasuryDemo.entity.Account;

@Repository
public class AccountDAOHibernateIMPL implements AccountDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public AccountDAOHibernateIMPL(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Account> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Account> theQuery = currentSession.createQuery("from Account", Account.class);
		
		// execut query and get result list
		List<Account> accounts = theQuery.getResultList();
		
		// return the results
		return accounts;
	}

	@Override
	public Account findById(int theId) {
		// generate the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// the the account
		Account theAccount = currentSession.get(Account.class, theId);
		
		// return the account
		return theAccount;
	}

	@Override
	public void save(Account theAccount) {
		// generate the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save account
		currentSession.saveOrUpdate(theAccount);
		
	}

	@Override
	public void deleteById(int theId) {
		// generate the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Client where id=:clientId");
		theQuery.setParameter("clientId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public void transfer(Account balance) {
		// generate the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("update Client set balance=:balance");
		theQuery.setParameter("balance", balance);
		
		theQuery.executeUpdate();
		
	}

}
