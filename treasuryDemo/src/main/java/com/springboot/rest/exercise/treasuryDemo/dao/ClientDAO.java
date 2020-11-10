package com.springboot.rest.exercise.treasuryDemo.dao;

import java.util.List;

import com.springboot.rest.exercise.treasuryDemo.entity.Client;

public interface ClientDAO {
	public List<Client> findAll();
}
