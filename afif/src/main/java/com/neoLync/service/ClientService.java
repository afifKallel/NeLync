package com.neoLync.service;

import com.neoLync.dao.PersistenceMock;
import com.neoLync.model.Account;
import com.neoLync.model.Client;

public class ClientService {
	/**
	 * methode pour ajouter un client
	 * @param client
	 */
	public void addClient(Client client) {
		PersistenceMock.clientList.add(client);		
	}
	
	
	/**
	 * methode pour supprimer un client
	 * @param client
	 */		
	public void deleteClient(Client client ) {		
				PersistenceMock.clientList.remove(client);		
		}	
	
	
	/**
	 * methode pour attribuer un compte à un client
	 * @param client 
	 * @param account
	 */
	public void linkAccount(Client client, Account account) {
		client.getAccounts().add(account);
		account.setOwner(client);
	}
	/**
	 * methode pour calculer la somme des soldes des comptes
	 * @param client
	 * @return
	 */
	public int getAcocuntsSum(Client client) {
		int sum = 0;
		for (Account account : client.getAccounts()) {
			sum += account.getBalance();
		}
		return sum;
	}
	
	/**
	 * methode pour afficher les clients
	 */

	public void readClients() {
		for (Client client : PersistenceMock.clientList) {
			System.out.println(client);
		}
		
	}
	
	
	

}
