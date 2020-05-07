package com.hutb.cfs.test;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

public class GetBalacneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Web3j web3j = Web3j.build(new HttpService());
		String address = "0x2f7335cab967b612a2fcc9344dbac5094ff3d2a9";
	        try {
	            BigInteger count  = web3j.ethGetBalance(address,DefaultBlockParameterName.LATEST).send().getBalance();
//	            count = count.divide(value);
//	            String str = count.toString();
	            BigDecimal banlance = Convert.fromWei(count.toString(), Convert.Unit.ETHER);
	            System.out.println(count);
	            System.out.println(banlance.toEngineeringString());
//	            web3j.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        File file = new File("src/main/resources/contractAddress.properties");
	        System.out.println(file.getAbsolutePath());
	    }

}
