package com.hutb.cfs.foundation.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.foundation.service.impl.DefaultFoundationService;
import com.hutb.cfs.foundation.service.impl.DefaultProjectService;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping(value="/foundation",produces = "text/plain;charset=utf-8")
//@CrossOrigin
public class FoundationController {

	@Autowired
	private DefaultProjectService projectService;
	
	
	@Autowired
	private DefaultFoundationService foundationService;
	
	@Autowired
	private WalletDaoImpl walletDao;
	
	@Autowired
	private DetailDaoImpl detailDao;
	
	@RequestMapping(value = "/getFoundationStatistic")
	@ResponseBody
	public String getFoundationStatistic(int foundation_id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Project> list = projectService.getAllMyProject(foundation_id);
		if (null != list) {
			result.put("type", "1");
			long donateCount = 0;
			long donateAmount = 0;
			for (Project p : list) {
				// 从以太坊获取金额数据
				Project pFromEth = detailDao.getDetail(p.getId());
				p.setNow_amount(pFromEth.getNow_amount());
				System.out.println("pFromEth" + pFromEth);
				donateCount += p.getDonate_count();
				donateAmount += p.getNow_amount();
			}
			result.put("projectCount", list.size());
			result.put("donateCount", donateCount);
			result.put("donateAmount", donateAmount);
		} else {
			result.put("type", "0");
		}
		System.out.println("result:" + result);
		return JSON.toJSONString(result);
	}
	
	
	
	@RequestMapping(value="/getFoundation")
	@ResponseBody
	public String getFoundation(int foundation_id) throws UnsupportedEncodingException{
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("get foundation_id:"+foundation_id);
		Foundation f = foundationService.getFoundation(foundation_id);
		if(null != f){
//			f.setName(new String(f.getName().getBytes("utf-8"),"gbk"));
			result.put("type", "1");
			result.put("foundation", f);
		}else{
			result.put("type", "0");
		}
		System.out.println("get from mysql f:"+f);
		
		return JSON.toJSONString(result);
	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(String username, String password, String tel) {
		Map<String, Object> result = new HashMap<String, Object>();

		System.out.println("username:" + username + ",password:" + password + ",tel:" + tel);
		
		FoundationUser fu = new FoundationUser();
		fu.setUsername(username);
		fu.setPassword(password);
		fu.setTel(tel);
		
		if(foundationService.addFoundationUser(fu) == 1){
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
		
		String role = (String) request.getSession().getAttribute("role");
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		
		System.out.println("username:" + username + ",password:" + password);
		
		FoundationUser fu = foundationService.getFoundationUser(username, password,role);
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
		if(foundationService.addWalletUUID(uuid, id) == 1){
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
	public String addFoundation(int id,String foundationName,@RequestPart("licenseFile") MultipartFile licenseFile) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("receive foundationName:"+foundationName+",licenseFile"+licenseFile.getName());
		String license = "";
		try {
			license = IpfsUtils.upload(licenseFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//name,license,level,modify_date,certification,audit_status
		Foundation f = new Foundation();
		f.setName(foundationName);
		f.setLicense(license);
		long modify_date = System.currentTimeMillis();
		f.setModify_date(modify_date);
		f.setCertification("0");//0 申请 1修改
		f.setAudit_status("0");// 0审核中 1通过 2未通过
		if(foundationService.addFoundation(f) == 1){
			if(foundationService.addFouondationId(f.getId(), id) == 1){
				result.put("type", "1");
				result.put("foundation_id", f.getId());
			}else{
				result.put("type", "0");
			}
		}else{
			result.put("type", "0");
		}
		System.out.println("result:"+result);
		return JSON.toJSONString(result);
	}

}
