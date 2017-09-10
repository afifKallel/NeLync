package com.neoLync.model;

import java.util.Date;

public class Account {
	private int numAccount;
	private float balance;
	private Date creationDate;
	private  Client owner;
			
	public Account(int numAccount, float balance, Date creationDate, Client owner) {		
		this.numAccount = numAccount;
		this.balance = balance;
		this.creationDate = creationDate;
		this.owner = owner;
	}
	public int getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(int numAccount) {
		this.numAccount = numAccount;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public String toString() {
		return "numero compte: " + numAccount + 
	"solde: "+balance+
	"Date de creation :" + creationDate ; 	
		
	}

}
