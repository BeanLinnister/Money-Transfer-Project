package org.benlin.moneytransfer.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	
	private long accountId;
	private String owner;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(long accountId, String owner, double balance) {
		this.accountId = accountId;
		this.owner = owner;
		this.balance = balance;
	}
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
