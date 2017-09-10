package neolync.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.neoLync.dao.PersistenceMock;
import com.neoLync.model.Account;
import com.neoLync.model.Client;
import com.neoLync.service.AccountService;
import com.neoLync.service.ClientService;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestApp {
	@BeforeClass
	    public static void test1AddClient() throws Exception {
		 ClientService clientService= new ClientService();		
		 System.out.println("******************* Adding Client s*****************");	 
	        Client client1 = new Client("C0001","nom1","prenom1",30,"","+33123456");
	        System.out.println(client1);
	        Client client2 = new Client("C0002","nom2","prenom2",30,"","+33123456");
	        System.out.println(client2);
	             
	        clientService.addClient(client1);
	        clientService.addClient(client2);
	        System.out.println("******************* Reading Clients List *****************");
	        clientService.readClients();
	        assertThat(PersistenceMock.clientList.size(), equalTo(2));
	        
	    	
	        
	    }
	 @Test
	 public void test2RemoveClient() throws Exception {
		 ClientService clientService= new ClientService();
		
	        Client client = PersistenceMock.clientList.get(1);
	        System.out.println("******************* Removing Clien2 *****************");	        
	        clientService.deleteClient(client);
	        System.out.println("******************* Reading New Clients List *****************");
	        clientService.readClients();
	        assertThat(PersistenceMock.clientList.size(), equalTo(1));
	    	
	        
	    }
	 
	 @BeforeClass
	 public static void test3CreateAccount() throws Exception {
		 	System.out.println("******************* Adding Accounts *****************");
		 	Account account1 = new Account(1001,100,null,null);		 	
	        System.out.println(account1);
	        Account account2 = new Account(1002,100,null,null);
	        System.out.println(account1);
	        Account account3 = new Account(1003,100,null,null);
	       AccountService accountService = new AccountService();
	              
	       accountService.addAccount(account1);
	       accountService.addAccount(account2);
	       accountService.addAccount(account3);
	        
	       System.out.println("******************* Reading Accounts *****************");
	        accountService.readAccounts();
	       
	        assertThat(PersistenceMock.accountList.size(), equalTo(3));
	    	
	        
	    }
	 
	@Test
	 public void test4DeleteAccount() throws Exception {
		    AccountService accountService= new AccountService();		
	        Account account = PersistenceMock.accountList.get(0);
	        System.out.println("******************* Removing Acount 1 *****************");	        
	        accountService.deleteAccount(account);
	        System.out.println("******************* Reading New Account List *****************");
	        accountService.readAccounts();
	        assertThat(PersistenceMock.accountList.size(), equalTo(2));  	
	        
	    }
	 
	@Test
	 public void test5DepositeMoney() throws Exception {
		    AccountService accountService= new AccountService();		
	        Account account = PersistenceMock.accountList.get(0);
	        
	        float oldBalance = account.getBalance();
	        float amount = 100;
	        
	        accountService.deposit(account.getNumAccount(), amount);
	        System.out.println("******************* Deposit  to Account *****************");
	        
	        assertThat(account.getBalance(), equalTo(200F));  	
	        
	    }
	 
	 
	@Test
	 public void test6WithdrawMoney() throws Exception {
		    AccountService accountService= new AccountService();		
	        Account account = PersistenceMock.accountList.get(0);
	        
	        float oldBalance = account.getBalance();
	        float amount = 100;
	        
	        accountService.widhdraw(account.getNumAccount(), amount);
	        System.out.println("******************* Withdraw from Account *****************");
	        
	        assertThat(account.getBalance(), equalTo( 100F));  	
	        
	    }
	 
	@Test
	 public void test7LinkAccount() throws Exception {
		 System.out.println("******************* Link Account *****************");
		 	ClientService clientService= new ClientService();			
	        Client client = PersistenceMock.clientList.get(0);
	        for(Account account : PersistenceMock.accountList ) {
	        	clientService.linkAccount(client, account);
	        }    	        
	        assertFalse(client.getAccounts().isEmpty());	
	        assertThat(client.getAccounts().size(),equalTo(2));  	
	    }
	 
	@Test
	 public void test8ClientTotalBalance() throws Exception {
		 System.out.println("******************* Total Account Balance *****************");
		 	ClientService clientService= new ClientService();			
	        Client client = PersistenceMock.clientList.get(0);	           	        
	        assertThat(clientService.getAcocuntsSum(client), equalTo(200));	        		        
	    }
	 
	 
	 


	 
}
