package com.hutb.cfs.admin.entity;

public class Wallet {

	private String wallet_address;
	private String hash;
	private String password;
	private String balance;
	private String uuid;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getWallet_address() {
		return wallet_address;
	}
	public void setWallet_address(String wallet_address) {
		this.wallet_address = wallet_address;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Wallet [wallet_address=" + wallet_address + ", hash=" + hash + ", password=" + password + ", balance="
				+ balance + ", uuid=" + uuid + "]";
	}
	
	
}
