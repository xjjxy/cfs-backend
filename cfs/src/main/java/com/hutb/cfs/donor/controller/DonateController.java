package com.hutb.cfs.donor.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
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
			Project pFromEth = detailDao.getDetail(project.getId());
			project.setTarget_amount(pFromEth.getTarget_amount());
			project.setNow_amount(pFromEth.getNow_amount());
			project.setLast_amount(pFromEth.getLast_amount());
			project.setWallet_address(pFromEth.getWallet_address());
			System.out.println("project:" + project);
			result.put("type", "1");
			result.put("project", project);
			//获取评论 获取项目进度
			
			
			
		}else{
			result.put("type", "0");
		}

		return JSON.toJSONString(result);
	}

	@RequestMapping("/getAllProjectBasicInfo")
	@ResponseBody
	public String getAllProjectBasicInfo(int currentPage, int pageSize) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("currentPage:" + currentPage + ",pageSize:" + pageSize);
		long now = System.currentTimeMillis();
		// System.out.println("now:"+now);
		int currentIndex = pageSize * (currentPage - 1);
		List<Project> list = donateService.getAllProjectBasicInfo(now, currentIndex, pageSize);
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
}
