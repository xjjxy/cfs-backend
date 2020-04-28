package com.hutb.cfs.test;

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
		String address = "0xa81A49aC5fDD0Bd1d83dD8fa60AE602eCa3ef103";
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
	    }

}
