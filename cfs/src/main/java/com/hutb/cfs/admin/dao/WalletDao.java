package com.hutb.cfs.admin.dao;

public interface WalletDao {

	public String createWallet(String wallet_address,String privateKey,String password);
	
	public String getWalletPassword(String uuid);
	
	
	public String getWalletAddress(String uuid);
	
	
	public String getWalletHash(String uuid);
	
	public String getBlance(String _address);
}
