package com.hutb.cfs.donor.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.donor.entity.Donor;
import com.hutb.cfs.donor.service.impl.DefaultBasicDonorService;

@Controller
@RequestMapping(value = "/donor", produces = "text/plain;charset=utf-8")
//@CrossOrigin
public class DonorController {

	@Autowired
	private DefaultBasicDonorService basicDonorService;
	
	@Autowired
	private WalletDaoImpl walletDao;
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(String name,String username,String password,String tel){
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println("name"+name+",username"+username+",password"+password+",tel"+tel);
		
		Donor donor = new Donor();
		donor.setName(name);
		donor.setUsername(username);
		donor.setPassword(password);
		donor.setTel(tel);
		if(basicDonorService.addDonor(donor) == 1){
			result.put("type", "1");
		}else{
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		
		String role = (String) request.getSession().getAttribute("role");
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		
		Donor donor = basicDonorService.getDonor(username, password,role);
		if(null != donor){
			System.out.println(donor.getUuid());
			result.put("user", donor);
			result.put("type", "1");
		}else{
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
		
	}
	
	@RequestMapping("/createWallet")
	@ResponseBody
	public String createWallet(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		int id = (int) request.getSession().getAttribute("id");
		String wallet_address = (String) request.getSession().getAttribute("wallet_address");
		String privateKey = (String) request.getSession().getAttribute("privateKey");
		String password = (String) request.getSession().getAttribute("password");
		
		String uuid = walletDao.createWallet(wallet_address, privateKey, password);
		System.out.println("create uuid:"+uuid);
		Wallet wallet = new Wallet();
		if(basicDonorService.addWalletUUID(uuid, id) == 1){
			String _wallet_address = walletDao.getWalletAddress(uuid);
			String hash = walletDao.getWalletHash(uuid);
			String balance = walletDao.getBlance(_wallet_address);
			wallet.setHash(hash);
			wallet.setWallet_address(_wallet_address);
			wallet.setBalance(balance);
			wallet.setUuid(uuid);
			result.put("type", "1");
			result.put("wallet", wallet);
		}else{
			result.put("type","0");
		}
		System.out.println(wallet);
		return JSON.toJSONString(result);
	}
	
}
