package com.hutb.cfs.foundation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.foundation.entity.FoundationUser;
import com.hutb.cfs.foundation.service.impl.DefaultFoundationUserService;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping("/foundation")
@CrossOrigin
public class FoundationController {

	@Autowired
	private DefaultFoundationUserService foundationUserService;
	
	@Autowired
	private WalletDaoImpl walletDao;

	@RequestMapping("/register")
	@ResponseBody
	public String register(String username, String password, String tel) {
		Map<String, Object> result = new HashMap<String, Object>();

		System.out.println("username:" + username + ",password:" + password + ",tel:" + tel);
		
		FoundationUser fu = new FoundationUser();
		fu.setUsername(username);
		fu.setPassword(password);
		fu.setTel(tel);
		
		if(foundationUserService.addFoundationUser(fu) == 1){
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

		System.out.println(request.getSession().getAttribute("username"));
		System.out.println(request.getSession().getAttribute("password"));
		
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		
		System.out.println("username:" + username + ",password:" + password);
		
		FoundationUser fu = foundationUserService.getFoundationUser(username, password);
		if(null != fu){
			result.put("user", fu);
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
		if(foundationUserService.addWalletUUID(uuid, id) == 1){
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
	
	@PostMapping("/addFoundation")
	@ResponseBody
	public String addFoundation(String name,@RequestPart("file") MultipartFile file){
		System.out.println("receive name:"+name+",file"+file);
		String license = "";
		try {
			license = IpfsUtils.upload(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
