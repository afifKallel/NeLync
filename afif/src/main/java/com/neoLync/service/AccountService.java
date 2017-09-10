package com.neoLync.service;

import com.neoLync.dao.PersistenceMock;
import com.neoLync.model.Account;
import com.neoLync.model.Client;

public class AccountService {

	/**
	 * methode pour ajouter un compte
	 * @param account
	 */
	public void addAccount(Account account) {
		PersistenceMock.accountList.add(account);
	}
	
	/**
	 * methode pour supprimer un compte
	 * @param account
	 */	
	public void deleteAccount(Account account) {		
			PersistenceMock.accountList.remove(account);		
	}
	
	/**
	 * methode pour alimenter un compte
	 * @param account
	 */	
	public void deposit (int numAccount,float amount) {
		
		Account account = PersistenceMock.getAccoutByNumAccount(numAccount);
		if (account != null) {
			account.setBalance(account.getBalance() + amount);
		}
	}
	
	/**
	 * methode pour retirer du compte
	 * @param numAccount
	 * @param amount
	 */
	public void widhdraw (int numAccount,float amount) {
		
		Account account = PersistenceMock.getAccoutByNumAccount(numAccount);
		if (account != null) {
			account.setBalance(account.getBalance() - amount);
		}
	}
	
	/**
	 * methode pour afficher les comptes
	 */
	
	public void readAccounts() {
		for (Account account : PersistenceMock.accountList) {
			System.out.println(account);
		}
	}
	
	
}
