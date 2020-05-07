package com.hutb.cfs.admin.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import com.hutb.cfs.admin.dao.WalletDao;
import com.hutb.cfs.admin.entity.SysBean;
import com.hutb.cfs.solidity.Wallet;
import com.hutb.cfs.utils.MyWalletUtils;

@Component
@PropertySource("classpath:contractAddress.properties")
public class WalletDaoImpl implements WalletDao {

	Web3j web3j = Web3j.build(new HttpService());
	@Autowired
	private  SysBean sysBean;
	
	@Value("${Wallet}")
	private String walletContract;
	
	@Value("${Detail}")
	private String detailContract;
	
	private Wallet wallet = null;
	
	@Override
	public String createWallet(String wallet_address,String privateKey,String password){
		if(wallet == null){
			wallet = getWalletContract();
		}
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		String hash = "";
		try {
			hash = MyWalletUtils.CreateWallet(privateKey, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("create hash:"+hash);
		
		try {
			wallet.createWallet(wallet_address, hash, password, uuid).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uuid;
	}
	
	

	@Override
	public String getWalletPassword(String uuid) {
		// TODO Auto-generated method stub
		if(wallet == null){
			wallet = getWalletContract();
		}
		try {
			String password = wallet.getWalletPassword(uuid).send();
			System.out.println("dao -- get password:"+password);
			return password;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	@Override
	public String getWalletAddress(String uuid) {
		// TODO Auto-generated method stub
		if(wallet == null){
			wallet = getWalletContract();
		}
		try {
			String address = wallet.getWalletAddress(uuid).send();
			System.out.println("dao-- get address:"+address);
			return address;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	@Override
	public String getWalletHash(String uuid) {
		if(wallet == null){
			wallet = getWalletContract();
		}
		// TODO Auto-generated method stub
		try {
			String hash = wallet.getWalletHash(uuid).send();
			System.out.println("dao--get hash :"+hash);
			return hash;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	


	@Override
	public String getBlance(String _address) {
		if(wallet == null){
			wallet = getWalletContract();
		}
		// TODO Auto-generated method stub
		BigDecimal balance = null;
	        try {
	            BigInteger count  = web3j.ethGetBalance(_address,DefaultBlockParameterName.LATEST).send().getBalance();
	            balance = Convert.fromWei(BigDecimal.valueOf(count.doubleValue()), Convert.Unit.ETHER);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "0";
	        }
		return balance.toString();
	}
	
	private Wallet getWalletContract(){
		
		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials(sysBean.getPassword(), sysBean.getHash());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Wallet wallet = Wallet.load(walletContract, web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		return wallet;
	}


	
}
