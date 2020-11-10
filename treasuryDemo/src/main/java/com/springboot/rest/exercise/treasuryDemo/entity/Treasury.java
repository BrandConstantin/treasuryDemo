package com.springboot.rest.exercise.treasuryDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treasury")
public class Treasury {
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="currency")
	private double currency;
	@Column(name="balance")
	private double balance;
	@Column(name="treasury")
	private boolean treasury;
	
	// define constructors
	public Treasury() {}

	public Treasury(String name, double currency, double balance, boolean treasury) {
		this.name = name;
		this.currency = currency;
		this.balance = balance;
		this.treasury = treasury;
	}

	// define getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isTreasury() {
		return treasury;
	}

	public void setTreasury(boolean treasury) {
		this.treasury = treasury;
	}
	
	
	// 	define tostring
	@Override
	public String toString() {
		return "Treasury [id=" + id + ", name=" + name + ", currency=" + currency + ", balance=" + balance + ", treasury="
				+ treasury + "]";
	}
}
