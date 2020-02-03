package org.benlin.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.benlin.moneytransfer.database.Database;
import org.benlin.moneytransfer.exception.DataNotFoundException;
import org.benlin.moneytransfer.exception.OverdraftException;
import org.benlin.moneytransfer.model.Account;

public class AccountService {
	
	private Map<Long, Account> accounts =  Database.getAccounts();
	
	public AccountService() {
		accounts.put(1L, new Account(1L, "Ben Lin", 100.0));
//		accounts.put(2L, new Account(2L, "John Smith", 200.0));
	}

	public List<Account> getAllAccounts(){
		return new ArrayList<Account>(accounts.values());

	}
	
	public Account getAccount(long accountId) {
		Account account = accounts.get(accountId);
		if (account == null) {
			throw new DataNotFoundException("Account with id " + accountId + " not found");
		}
		else {
			return account;
		}
	}
	
	public Account addAccount(Account account) {
		account.setAccountId(accounts.size()+1);
		accounts.put(account.getAccountId(), account);
		return account;
	}
	
	public Account updateAccount(Account account) {
		if(account.getAccountId() <= 0) {
			return null;
		}
		
		accounts.put(account.getAccountId(), account);
		return account;
	}
	
	/*
	 * Handle the error better
	 */
	public Account withdraw(Account account, double amount) {
		if(account.getAccountId() <= 0 || amount < 0) {
			return null;
		}
		
		double newBalance = account.getBalance() - amount;
		if(newBalance >= 0) {
			account.setBalance(newBalance);
			return updateAccount(account);
		}
		else {
			throw new OverdraftException(amount + " exceeds " + account.getOwner() + "'s account balance");
		}
	}
	
	public Account deposit(Account account, double amount) {
		if(account.getAccountId() <= 0 || amount < 0) {
			return null;
		}
		
		account.setBalance(account.getBalance() + amount);
		return updateAccount(account);
	}
	
	public Account removeAccount(long accountId) {
		return accounts.remove(accountId);
	}
	
	
}
