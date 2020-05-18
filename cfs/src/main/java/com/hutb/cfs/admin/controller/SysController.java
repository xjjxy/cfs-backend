package com.hutb.cfs.admin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.admin.service.impl.DefaultLoginLogService;

@Controller
@RequestMapping(value = "/sys",produces = "text/plain;charset=utf-8")
//@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "",methods = {})
public class SysController {

	@Autowired
	private WalletDaoImpl walletDao;

	
	
	@Autowired
	private DefaultLoginLogService loginLogService;

	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, String username, String password, String role) {
		System.out.println("username:" + username + ",password:" + password + ",role:" + role);
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		String result;
		String user_type;
		if ("0".equals(role)) {
			result = "forward:../donor/login";
			user_type = "捐赠者";
		} else if ("1".equals(role)) {
			result = "redirect:../foundation/login";
			user_type = "基金会";
		} else {
			result = "forward:../admin/login";
			user_type = "管理员";
		}
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
		LoginLog log = new LoginLog();
		String login_date = df.format(date);
		log.setLogin_date(login_date);
		log.setUser_type(user_type);
		log.setUsername(username);
		loginLogService.loginLog(log);
		return result;
	}

	@RequestMapping("/createWallet")
	public String createWallet(HttpServletRequest request, int id, String wallet_address, String privateKey,
			String password, String role) {
		System.out.println("id:" + id + ",wallet_address:" + wallet_address + ",privateKey:" + privateKey + ",password:"
				+ password + ",role:" + role);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("wallet_address", wallet_address);
		session.setAttribute("privateKey", privateKey);
		session.setAttribute("password", password);
		if ("0".equals(role)) {
			return "forward:../donor/createWallet";
		} else if ("1".equals(role)) {
			return "redirect:../foundation/createWallet";
		} else {
			return "";
		}
	}

	@RequestMapping("/walletInfo")
	@ResponseBody
	public String walletInfo(String uuid) {
		Map<String, Object> result = new HashMap<String, Object>();
		Wallet wallet = new Wallet();
		System.out.println("receive--uuid:"+uuid);
		if(null ==uuid){
			result.put("type", "0");
		}else{
			String _wallet_address = walletDao.getWalletAddress(uuid);
			String hash = walletDao.getWalletHash(uuid);
			String balance = walletDao.getBlance(_wallet_address);
			wallet.setHash(hash);
			wallet.setWallet_address(_wallet_address);
			wallet.setBalance(balance);
			result.put("type", "1");
			result.put("wallet", wallet);
		}
		return JSON.toJSONString(result);
	}
	
	

}
