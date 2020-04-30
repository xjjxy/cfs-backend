package com.hutb.cfs.foundation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.foundation.service.impl.DefaultFoundationService;
import com.hutb.cfs.foundation.service.impl.DefaultProjectService;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping(value="/project",produces = "text/plain;charset=utf-8")
public class ProjectController {

	@Autowired
	private DefaultProjectService projectService;
	
	@Autowired
	private DetailDaoImpl detailDao;
	
	@Autowired
	private WalletDaoImpl walletDao;
	
	@Autowired
	private DefaultFoundationService foundationService;
	
	
	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addProject")
	@ResponseBody
	public String addProject(Project p) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		System.out.println("p:"+p);
		p.setDescription(IpfsUtils.upload(p.getDescription()));
		
		int re = projectService.addProject(p);
		if(0 != re){
			System.out.println("id:"+p.getId());
			int project_id = p.getId();
			String uuid = foundationService.getUUID(p.getFoundation_id());
			System.out.println("get from fu uuid:"+uuid);
			String wallet_address = walletDao.getWalletAddress(uuid);
			System.out.println("get from eth wallet_address:"+wallet_address);
			
			//添加金额数据到以太坊
			detailDao.createDetail(wallet_address, p.getTarget_amount(), project_id);
			result.put("type", "1");
		}else{
			result.put("type", "0");
		}
		
		
		return JSON.toJSONString(result);
	}
	
	
	/**
	 * 
	 * @param foundation_id
	 * @return
	 */
	@RequestMapping(value="/getAllProject")
	@ResponseBody
	public String getAllProject(int foundation_id){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Project> list = projectService.getAllProject(foundation_id);
		if(null != list){
			result.put("type", "1");
			for(Project p : list){
				//从以太坊获取金额数据
				Project pFromEth = detailDao.getDetail(p.getId());
				p.setTarget_amount(pFromEth.getTarget_amount());
				p.setNow_amount(pFromEth.getNow_amount());
				p.setLast_amount(pFromEth.getLast_amount());
				p.setWallet_address(pFromEth.getWallet_address());
				System.out.println("pFromEth"+pFromEth);
			}
			result.put("list", list);
		}else{
			result.put("type", "0");
		}
		System.out.println("result:"+result);
		
		return JSON.toJSONString(result);
	}
	
	
	
}
