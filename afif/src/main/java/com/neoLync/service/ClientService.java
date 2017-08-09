package com.neoLync.service;

import com.neoLync.dao.PersistenceMock;
import com.neoLync.model.Account;
import com.neoLync.model.Client;

public class ClientService {
	
	public void addClient(Client client) {
		PersistenceMock.clientList.add(client);		
	}
	
	public void deleteClient(String clientId ) {
		Client client = PersistenceMock.getOwnerById(clientId);
		if (client != null) {
			PersistenceMock.clientList.remove(client);
		}
	}
	
	public void linkAccount(Client client, Account account) {
		client.getAccounts().add(account);
		account.setOwner(client);
	}
	
	public int getAcocuntBalanceSumByclient(Client client) {
		int sum = 0;
		for (Account account : client.getAccounts()) {
			sum += account.getBalance();
		}
		return sum;
	}
	
	
	

}
