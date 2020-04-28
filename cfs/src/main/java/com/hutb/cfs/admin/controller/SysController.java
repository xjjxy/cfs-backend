package com.hutb.cfs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.admin.service.impl.DefaultAdminService;

@Controller
@RequestMapping("/sys")
@CrossOrigin
public class SysController {

	@Autowired
	private WalletDaoImpl walletDao;

	@Autowired
	private DefaultAdminService adminService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, String username, String password, String role) {
		System.out.println("username:" + username + ",password:" + password + ",role:" + role);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		if ("0".equals(role)) {
			return "forward:../donor/login";
		} else if ("1".equals(role)) {
			return "redirect:../foundation/login";
		} else {
			return "forward:admin/login";
		}
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

	@RequestMapping("/admin/login")
	@ResponseBody
	public String adminLogin(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		System.out.println(request.getSession().getAttribute("username"));
		System.out.println(request.getSession().getAttribute("password"));

		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");

		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin = adminService.getAdmin(admin);
		if (null != admin) {
			result.put("user", admin);
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
}
