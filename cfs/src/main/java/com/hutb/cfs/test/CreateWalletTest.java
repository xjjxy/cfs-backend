package com.hutb.cfs.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Properties;
import java.util.UUID;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import com.hutb.cfs.solidity.Wallet;
import com.hutb.cfs.utils.MyWalletUtils;

public class CreateWalletTest {

	public static void main(String[] args) throws Exception {
		Web3j web3j = Web3j.build(new HttpService());
		// TODO Auto-generated method stub
		
		//QmRHbpX5dq55dm6CwXh1twq7PMn4eve4TPED2KfbRiobV9 admin walletpath
//		CreateWalletDaoImpl
		
		
		Properties prop = new Properties();
		InputStream in = ClassLoader.getSystemResourceAsStream("contractAddress.properties");
		prop.load(in);
		String walletAddress = prop.getProperty("Wallet");
		
		
		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials("admin"
					,"QmRHbpX5dq55dm6CwXh1twq7PMn4eve4TPED2KfbRiobV9");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Wallet wallet = Wallet.load(walletAddress, web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		String uuid = UUID.randomUUID().toString().replace("-", "");
		wallet.createWallet("0xa81A49aC5fDD0Bd1d83dD8fa60AE602eCa3ef103", 
				"QmRHbpX5dq55dm6CwXh1twq7PMn4eve4TPED2KfbRiobV9", "admin", uuid).send();
		System.out.println(uuid);
		
	}

}
