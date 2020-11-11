package com.springboot.rest.exercise.treasuryDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.exercise.treasuryDemo.dao.AccountDAO;
import com.springboot.rest.exercise.treasuryDemo.entity.Account;;

@RestController
@RequestMapping("/api")
public class AccountRestController {
	private AccountDAO accountDAO;
	
	// inject account dao
	@Autowired
	public AccountRestController(AccountDAO theAccountDAO) {
		accountDAO = theAccountDAO;
	}
	
	// expose /account and return list of clients
	@GetMapping("/accounts")
	public List<Account> findAll(){
		return accountDAO.findAll();
	}
}
