package com.springboot.rest.exercise.treasuryDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.exercise.treasuryDemo.dao.AccountDAO;
import com.springboot.rest.exercise.treasuryDemo.entity.Account;
import com.springboot.rest.exercise.treasuryDemo.service.AccountService;;

@RestController
@RequestMapping("/api")
public class AccountRestController {
	//use the service
	private AccountService accountService;
	
	// inject account dao
	@Autowired
	public AccountRestController(AccountService theAccountDAO) {
		accountService = theAccountDAO;
	}
	
	// expose /account and return list of clients
	@GetMapping("/accounts")
	public List<Account> findAll(){
		return accountService.findAll();
	}
	
	// get one account
	@GetMapping("/accounts/{accountId}")
	public Account getAccount(@PathVariable int accountId) {
		Account theAccount = accountService.findById(accountId);
		
		if(theAccount == null) {
			throw new RuntimeException("Account id not fountd");
		}
		
		return theAccount;
	}
	
	// add acount
	@PostMapping("/accounts")
	public Account addAccount(@RequestBody Account theAccount) {
		theAccount.setId(0);
		accountService.save(theAccount);
		
		return theAccount;
	}
	
	// update account
	@PutMapping("/accounts")
	public Account updateAccount(@RequestBody Account theAccount) {
		accountService.save(theAccount);
		return theAccount;
	}
	
	// delete account
	@DeleteMapping("/accounts/{accountId}")
	public String deleteAccount(@PathVariable int accountId) {
		Account tempAccount = accountService.findById(accountId);
		
		if(tempAccount == null) {
			throw new RuntimeException("Account not found");
		}
		
		accountService.deleteById(accountId);
		return accountId + " was deleted";
		
	}
}
