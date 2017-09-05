package com.neoLync.service;

import com.neoLync.dao.PersistenceMock;
import com.neoLync.model.Account;
import com.neoLync.model.Client;

public class AccountService {

	public void addAccount(Account account) {
		PersistenceMock.accountList.add(account);
	}
	
	public void deleteAccount(int numAccount) {
		Account account = PersistenceMock.getAccoutByNumAccount(numAccount);
		if (account != null) {
			PersistenceMock.accountList.remove(account);
		}
	}
	
	
	public void deposit (int numAccount,int amount) {
		
		Account account = PersistenceMock.getAccoutByNumAccount(numAccount);
		if (account != null) {
			account.setBalance(account.getBalance() + amount);
		}
	}
	
	public void widhdrawl (int numAccount,int amount) {
		
		Account account = PersistenceMock.getAccoutByNumAccount(numAccount);
		if (account != null) {
			account.setBalance(account.getBalance() - amount);
		}
	}
	
	public void readAccounts() {
		for (Account account : PersistenceMock.accountList) {
			System.out.println(account);
		}
	}
	
	
}
