package com.neoLync.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String idClient;
	private String firstName;
	private String lastName;
	private int age;
	private String adress;
	private String phone;
	private List <Account> accounts;
	
	
	public Client(String idClient, String firstName, String lastName, int age, String adress, String phone) {
		
		this.idClient = idClient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.adress = adress;
		this.phone = phone;
		this.accounts = new ArrayList<Account>();
	}
	
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String toString() {
		String accountString = "" ;	
		if (accounts != null) {
			for (Account account : accounts) {
				accountString +="\n "+account.toString()+ "\n";
			}
		}
		return ("id : "+ idClient+
				" nom prenom:" +firstName+lastName+
				" age : "+ age+
				" adresse:"+ adress+
				" telephone : "+phone + "\n comptes \n") +accountString;
	}
	
			
	

}
