package com.springboot.rest.exercise.treasuryDemo.dao;

import java.util.List;

import com.springboot.rest.exercise.treasuryDemo.entity.Account;

public interface AccountDAO {
	public List<Account> findAll();
	public Account findById(int theId);
	public void save(Account theClient);
	public void deleteById(int theId);
	public void transfer(Account balance);
}
