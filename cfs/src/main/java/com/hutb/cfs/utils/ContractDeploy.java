package com.hutb.cfs.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Properties;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import com.hutb.cfs.solidity.Detail;
import com.hutb.cfs.solidity.Wallet;

public class ContractDeploy {

	public static void main(String[] args) throws Exception {
		Web3j web3 = Admin.build(new HttpService());
		// String hash =
		// MyWalletUtils.CreateWallet("36e0a7cf0a8050037ef228d559807c36dfc49f6caf9669ca6aff3db24b63c0c3",
		// "admin");
		// Credentials credentials = MyWalletUtils.getCredentials("admin",
		// hash);
		// BigInteger gasPrice =
		// web3.ethGasPrice().sendAsync().get().getGasPrice();
		// User bushu = User.deploy(web3, credentials, new
		// StaticGasProvider(gasPrice,BigInteger.valueOf(6721975))).send();
		// Properties prop = new Properties();
		// InputStream in =
		// ClassLoader.getSystemResourceAsStream("contractAddress.properties");
		//// InputStream in = new
		// FileInputStream("classpath:contractAddress.properties");
		// prop.load(in);
		// in.close();
		//// prop.clear();
		// prop.remove("User");
		// prop.setProperty("User", bushu.getContractAddress());
		// OutputStream out = new
		// FileOutputStream(ClassLoader.getSystemResource("contractAddress.properties").getPath(),true);
		//// OutputStream out = new
		// FileOutputStream("classpath:contractAddress.properties",true);
		// OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		// prop.store(osw, "#");
		// System.out.println(ClassLoader.getSystemResource("contractAddress.properties").getPath());
		// System.out.println(prop.getProperty("User"));
		// out.close();
		// osw.close();

//		Properties prop = new Properties();
//		InputStream in = ClassLoader.getSystemResourceAsStream("admin.properties");
//		prop.load(in);
//		System.out.println("privateKey:" + prop.getProperty("admin.privateKey"));
//		System.out.println("privateKeyLength:" + prop.getProperty("admin.privateKey").length());
//		String hash = MyWalletUtils.CreateWallet(prop.getProperty("admin.privateKey"),
//				prop.getProperty("admin.password"));
//		prop.setProperty("admin.hash", hash);
//		OutputStream out = new FileOutputStream(ClassLoader.getSystemResource("admin.properties").getPath(),
//				true);
//		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
//		prop.store(osw, "#");
		
		
		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials("admin"
					,"QmRHbpX5dq55dm6CwXh1twq7PMn4eve4TPED2KfbRiobV9");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		
		BigInteger gasPrice =
				web3.ethGasPrice().sendAsync().get().getGasPrice();
		Wallet bushu = Wallet.deploy(web3, credentials, new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)))
				.send();
		
		Detail d = Detail.deploy(web3, credentials, new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)))
				.send();
		
		
		System.out.println("wallet:"+bushu.getContractAddress());
		System.out.println("detail:"+d.getContractAddress());
		Properties prop = new Properties();
//		InputStream in = ClassLoader.getSystemResourceAsStream("contractAddress.properties");
		InputStream in = new FileInputStream("src/main/resources/contractAddress.properties");
		prop.load(in);
		prop.setProperty("Wallet", bushu.getContractAddress());
		prop.setProperty("Detail", d.getContractAddress());
		
		OutputStream out = new FileOutputStream("src/main/resources/contractAddress.properties",
				true);
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		prop.store(osw, "#");
		
		in.close();
		out.close();
	}
}
