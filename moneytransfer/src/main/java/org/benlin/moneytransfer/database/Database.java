package org.benlin.moneytransfer.database;

import java.util.HashMap;
import java.util.Map;

import org.benlin.moneytransfer.model.Account;
import org.benlin.moneytransfer.model.User;

public class Database {
	
	private static Map<Long, Account> accounts = new HashMap<>();
	private static Map<String, User> users = new HashMap<>();
	
	public static Map<Long, Account> getAccounts(){
		return accounts;
	}
	
	public static Map<String, User> getUsers(){
		return users;
	}
	
	

}
