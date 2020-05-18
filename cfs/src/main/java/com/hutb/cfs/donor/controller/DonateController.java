package com.hutb.cfs.donor.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.donor.service.impl.DefaultDonateService;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping(value = "/donor", produces = "text/plain;charset=utf-8")
public class DonateController {

	@Autowired
	private DefaultDonateService donateService;

	@Autowired
	private DetailDaoImpl detailDao;

	@Autowired
	private WalletDaoImpl walletDao;

	@RequestMapping("/donate")
	@ResponseBody
	public String donate(Donation donation,String wallet_password,String uuid,boolean anonymous){
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("params wallet_password:"+wallet_password+",Donation:"+donation+",anonymous:"+anonymous);
		String address = walletDao.getWalletAddress(uuid);
		Double balance = Double.valueOf(walletDao.getBlance(address));
		String password = walletDao.getWalletPassword(uuid);
		String hash = walletDao.getWalletHash(uuid);
		if(balance < donation.getDonate_amount()){
			result.put("type", "2");
		}else if(!password.equals(wallet_password)){
			result.put("type", "3");
		}else{
			Wallet wallet = new Wallet();
			wallet.setPassword(wallet_password);
			wallet.setHash(hash);
			if(1 == detailDao.donate(donation.getProject_id(), donation.getDonate_amount(), wallet)){
				System.out.println("捐赠成功");
				result.put("type", "1");
			}else{
				result.put("type", "4");
			}
			if(anonymous){
				donation.setDonor_name(replaceNameX(donation.getDonor_name()));
			}
			donation.setDonate_time(System.currentTimeMillis());
			donateService.addDonation(donation);
			donateService.updateDonateCount(donation.getProject_id());
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getProjectDetail")
	@ResponseBody
	public String getProjectDetail(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		Project project = donateService.getProjectDetail(id);
		if (null != project) {
			try {
				project.setDescription(IpfsUtils.download(project.getDescription()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("id:"+id);
			System.out.println("project.getId():"+project.getId());
			Project pFromEth = detailDao.getDetail(project.getId());
			System.out.println("pFromEth:"+pFromEth);
			project.setTarget_amount(pFromEth.getTarget_amount());
			project.setNow_amount(pFromEth.getNow_amount());
			project.setLast_amount(pFromEth.getLast_amount());
			project.setWallet_address(pFromEth.getWallet_address());
			System.out.println("project:" + project);
			result.put("type", "1");
			result.put("project", project);
			// 获取评论 获取项目进度

		} else {
			result.put("type", "0");
		}

		return JSON.toJSONString(result);
	}

	@RequestMapping("/getAllProjectBasicInfo")
	@ResponseBody
	public String getAllProjectBasicInfo(int currentPage, int pageSize,String project_name) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("currentPage:" + currentPage + ",pageSize:" + pageSize+",project_name:"+project_name);
		long now = System.currentTimeMillis();
		// System.out.println("now:"+now);
		int currentIndex = pageSize * (currentPage - 1);
		List<Project> list = donateService.getAllProjectBasicInfo(now, currentIndex, pageSize,"%"+project_name+"%");
		if (null != list) {
			// for(Project p : list){
			// System.out.println("name:"+p.getFoundation_name());
			// try {
			// p.setDescription(IpfsUtils.download(p.getDescription()));
			//// System.out.println("description:"+p.getDescription());
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			int totalCount = list.size();
			result.put("type", "1");
			result.put("totalCount", totalCount);
			result.put("list", list);
		} else {
			result.put("type", "0");
		}

		return JSON.toJSONString(result);
	}

	public String replaceNameX(String str){
		String custName = str;
		int len = custName.length();
		
		String reg = ".{1}";
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		int i = 0;
		while(m.find()){
			i++;
			if(i == len || i == 1){
				continue;
			}
			m.appendReplacement(sb, "*");
		}
		m.appendTail(sb);
		return sb.toString();
	}

}
