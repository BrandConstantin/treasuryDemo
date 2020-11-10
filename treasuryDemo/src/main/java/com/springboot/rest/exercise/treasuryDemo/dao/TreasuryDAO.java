package com.springboot.rest.exercise.treasuryDemo.dao;
import java.util.List;
import com.springboot.rest.exercise.treasuryDemo.entity.Treasury;

public interface TreasuryDAO {
	public List<Treasury> findAll();
}
