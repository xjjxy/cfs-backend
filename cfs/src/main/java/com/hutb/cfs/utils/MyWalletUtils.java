package com.hutb.cfs.utils;

import java.io.File;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.utils.Numeric;

public class MyWalletUtils {
	private static String walletFilePath = "D:";

	public static String CreateWallet(String privateKey, String password) throws Exception {
		ECKeyPair ecKeyPair = ECKeyPair.create(Numeric.toBigInt(privateKey));
		String walletFileName = null;
		walletFileName = WalletUtils.generateWalletFile(password, ecKeyPair, new File(walletFilePath), false);
		String hash = null;
		File file = new File(walletFilePath + "/" + walletFileName);
		hash = IpfsUtils.upload(file);
		
		return hash;
	}

	public static Credentials getCredentials(String password, String hash) throws Exception {
		String walletFileName = "D:\\" + hash + ".json";
		IpfsUtils.download(walletFileName, hash);
		File file = new File(walletFileName);
		Credentials credentials = null;
		credentials = WalletUtils.loadCredentials(password, file);
		file.delete();
		return credentials;
	}
}
