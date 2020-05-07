package com.hutb.cfs.test;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import com.hutb.cfs.solidity.Detail;
import com.hutb.cfs.utils.MyWalletUtils;

public class DonationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Web3j web3j = Web3j.build(new HttpService());
		String password = "123456";
		String hash = "QmNXuc2uJ19xamz66UuMKxijEbRCeVaE9ujrFj7z1pCDmD";
		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials(password, hash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Detail detail = Detail.load("0x2f7335cab967b612a2fcc9344dbac5094ff3d2a9", web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		System.out.println(detail.getContractAddress());
		detail.donation(BigInteger.valueOf(37), BigInteger.valueOf(1000000000000000000L)).sendAsync();
	}

}
