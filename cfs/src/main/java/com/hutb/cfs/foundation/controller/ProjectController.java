package com.hutb.cfs.foundation.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.foundation.service.impl.DefaultFoundationService;
import com.hutb.cfs.foundation.service.impl.DefaultProjectService;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping(value="/foundation",produces = "text/plain;charset=utf-8")
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
	@RequestMapping(value="/addProject", method = RequestMethod.POST)
	@ResponseBody
	public String addProject(Project p,String bTime,String eTime,@RequestPart("showImg") MultipartFile showImg) throws Exception{
		System.out.println(showImg);
		Map<String,Object> result = new HashMap<String,Object>();
		SimpleDateFormat format =   new SimpleDateFormat("yyyy年MM月dd日");
		long bt = format.parse(bTime).getTime();
		p.setBegin_time(bt);
		//加一天
		long et = format.parse(eTime).getTime() + 86400000;
		p.setEnd_time(et);
		p.setImg(IpfsUtils.upload(showImg));
		p.setDescription(IpfsUtils.upload(p.getDescription()));
		System.out.println("p:"+p);
		String foundation_name = projectService.getFoundationName(p.getFoundation_id());
		p.setFoundation_name(foundation_name);
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
	@RequestMapping(value="/getAllMyProject")
	@ResponseBody
	public String getAllProject(int foundation_id){
		Map<String,Object> result = new HashMap<String,Object>();
		List<Project> list = projectService.getAllMyProject(foundation_id);
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
