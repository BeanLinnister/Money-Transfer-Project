package org.benlin.moneytransfer.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.benlin.moneytransfer.model.Account;
import org.benlin.moneytransfer.service.AccountService;

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
	
	AccountService accountService = new AccountService();
	
	@GET
	public List<Account> getAccounts() {
		return accountService.getAllAccounts();
	}
	
	@GET
	@Path("/{accountId}")
	public Account getAccount(@PathParam("accountId") long accountId) {
		return accountService.getAccount(accountId);
	}
	
	@POST
	public Account addAccount(Account account) {
		return accountService.addAccount(account);
	}
	
	@PUT
	@Path("/{accountId}")
	public Account updateAccount(@PathParam("accountId") long accountId, Account account) {
		account.setAccountId(accountId);
		return accountService.updateAccount(account);
	}
	
	@PUT
	@Path("/{accountId}/withdraw/{amount}")
	public Account withdraw(@PathParam("accountId") long accountId, @PathParam("amount") double amount) {
		Account account = accountService.getAccount(accountId);
		accountService.withdraw(account, amount);
		return accountService.updateAccount(account);
	}
	
	@PUT
	@Path("/{accountId}/deposit/{amount}")
	public Account deposit(@PathParam("accountId") long accountId, @PathParam("amount") double amount) {
		Account account = accountService.getAccount(accountId);
		accountService.deposit(account, amount);
		return accountService.updateAccount(account);
	}
	
	/*
	 * transfer amount from account 1 to account 2
	 * need to handle if you can't withdraw the amount
	 */
	@PUT
	@Path("/transfer/{accountId1}/{accountId2}/{amount}")
	public List<Account> transfer(@PathParam("accountId1") long accountId1, @PathParam("accountId2") long accountId2, @PathParam("amount") double amount) {
		Account account1 = accountService.getAccount(accountId1);
		Account account2 = accountService.getAccount(accountId2);
		if(accountService.withdraw(account1, amount) != null) {
			accountService.deposit(account2, amount);
			accountService.updateAccount(account1);
			accountService.updateAccount(account2);

		}
		ArrayList<Account> list = new ArrayList<Account>();
		list.add(account1);
		list.add(account2);
		return list;
		
		
		
		
		
	}
	
	
	@DELETE
	@Path("/{accountId}")
	public void deleteAccount(@PathParam("accountId") long accountId) {
		accountService.removeAccount(accountId);
	}
	

}
