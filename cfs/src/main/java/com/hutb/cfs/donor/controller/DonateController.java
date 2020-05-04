package com.hutb.cfs.donor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.donor.entity.PageSplitProject;
import com.hutb.cfs.donor.service.impl.DefaultDonateService;
import com.hutb.cfs.foundation.entity.Project;

@Controller
@RequestMapping(value = "/donor", produces = "text/plain;charset=utf-8")
public class DonateController {

	@Autowired
	private DefaultDonateService donateService;
	
	@RequestMapping("/getAllProject")
	@ResponseBody
	public String getAllProject(int currnetPage){
		Map<String, Object> result = new HashMap<String, Object>();
		PageSplitProject psp = new PageSplitProject();
		List<Project> list = donateService.getAllProject(System.currentTimeMillis());
		psp.setList(list);
		
		
		return JSON.toJSONString(result);
	}
}
