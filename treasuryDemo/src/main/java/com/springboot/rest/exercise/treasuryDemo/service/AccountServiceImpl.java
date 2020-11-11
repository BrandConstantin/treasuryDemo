package com.springboot.rest.exercise.treasuryDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.exercise.treasuryDemo.dao.AccountDAO;
import com.springboot.rest.exercise.treasuryDemo.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	@Autowired
	public AccountServiceImpl(AccountDAO theAccountDAO) {
		accountDAO = theAccountDAO;
	}
	
	@Override
	@Transactional
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}

	@Override
	@Transactional
	public Account findById(int theId) {
		// TODO Auto-generated method stub
		return accountDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Account theClient) {
		// TODO Auto-generated method stub
		accountDAO.save(theClient);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void transfer(Account balance) {
		// TODO Auto-generated method stub
		accountDAO.transfer(balance);
	}

}
