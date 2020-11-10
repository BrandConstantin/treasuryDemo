package com.springboot.rest.exercise.treasuryDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.exercise.treasuryDemo.dao.ClientDAO;
import com.springboot.rest.exercise.treasuryDemo.entity.Client;

@RestController
@RequestMapping("/api")
public class ClientRestController {
	private ClientDAO clientDAO;
	
	// inject client dao
	@Autowired
	public ClientRestController(ClientDAO theClientDAO) {
		clientDAO = theClientDAO;
	}
	
	// expose /client and return list of clients
	@GetMapping("/clients")
	public List<Client> findAll(){
		return clientDAO.findAll();
	}
}
