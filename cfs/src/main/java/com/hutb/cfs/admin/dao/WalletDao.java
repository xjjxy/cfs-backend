package com.hutb.cfs.admin.dao;

public interface WalletDao {

	String createWallet(String wallet_address,String privateKey,String password);
	
	String getWalletPassword(String uuid);
	
	
	String getWalletAddress(String uuid);
	
	
	String getWalletHash(String uuid);
	
	String getBlance(String _address);
}
