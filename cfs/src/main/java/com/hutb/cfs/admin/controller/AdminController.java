package com.hutb.cfs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.DetailDaoImpl;
import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.AuditLog;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.admin.entity.Statistic;
import com.hutb.cfs.admin.service.impl.DefaultAdminService;
import com.hutb.cfs.admin.service.impl.DefaultAuditLogService;
import com.hutb.cfs.admin.service.impl.DefaultLoginLogService;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.Project;

@Controller
@RequestMapping(value = "/admin", produces = "text/plain;charset=utf-8")
public class AdminController {
	@Autowired
	private DetailDaoImpl detailDao;

	@Autowired
	private DefaultAdminService adminService;
	
	@Autowired
	private DefaultAuditLogService auditLogService;
	
	@Autowired
	private DefaultLoginLogService loginLogService;
	
	
	@RequestMapping("/getStatistic")
	@ResponseBody
	public String getStatistic(){
		Map<String, Object> result = new HashMap<String, Object>();
		Statistic statistic = adminService.getStatistic();
		if(null != statistic){
			result.put("type", "1");
			result.put("statistic",statistic);
		}else{
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	
	@RequestMapping("/getAuditLog")
	@ResponseBody
	public String getAuditinLog(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<AuditLog> list = auditLogService.getAudti_Log();
		if(null != list){
			result.put("type", "1");
			result.put("list", list);
		}else{
			
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	
	@RequestMapping("/getLoginLog")
	@ResponseBody
	public String getLoginLog(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<LoginLog> list = loginLogService.getLoginLog();
		if(null != list){
			result.put("type", "1");
			result.put("list", list);
		}else{
			
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping("/getIsHProject")
	@ResponseBody
	public String getIsHProject(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Project> list = adminService.getIsHProject();
		if (null != list) {
			System.out.println("list:"+list);
			result.put("type", "1");
			for (Project p : list) {
				// 从以太坊获取金额数据
				Project pFromEth = detailDao.getDetail(p.getId());
				p.setTarget_amount(pFromEth.getTarget_amount());
				p.setNow_amount(pFromEth.getNow_amount());
				p.setLast_amount(pFromEth.getLast_amount());
				p.setWallet_address(pFromEth.getWallet_address());
				System.out.println("pFromEth" + pFromEth);
			}
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	
	@RequestMapping(value = "/handleProject", method = RequestMethod.POST)
	@ResponseBody
	public String handleProject(Project p,String username){
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("project:"+p);
		if(1 == adminService.handleProject(p)){
			AuditLog log = new AuditLog();
			log.setAudit_type("募捐项目审核");
			log.setAudit_operator(username);
			log.setAudit_result("1".equals(p.getAudit_status()) ? "通过" : ("2".equals(p.getAudit_status()) ? "不通过" : "重新审核"));
			log.setAudit_time(System.currentTimeMillis());
			System.out.println("auditLog:"+log);
			auditLogService.addAudit_Log(log);
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	

	@RequestMapping(value = "/getNHProject", method = RequestMethod.GET)
	@ResponseBody
	public String getAllProject() {
		Map<String, Object> result = new HashMap<String, Object>();

		List<Project> list = adminService.geNHProject();
		if (null != list) {
			System.out.println("list:" + list);
			result.put("type", "1");
			for (Project p : list) {
				// 从以太坊获取金额数据
				Project pFromEth = detailDao.getDetail(p.getId());
				p.setTarget_amount(pFromEth.getTarget_amount());
				p.setNow_amount(pFromEth.getNow_amount());
				p.setLast_amount(pFromEth.getLast_amount());
				p.setWallet_address(pFromEth.getWallet_address());
				System.out.println("pFromEth" + pFromEth);
			}
			result.put("list", list);
		} else {
			result.put("type", "0");
		}

		return JSON.toJSONString(result);
	}

	@RequestMapping(value = "/handleFoundation", method = RequestMethod.POST)
	@ResponseBody
	public String handleFoundation(String id, String level, String audit_status,String username) {
		System.out.println("level:" + level + ",audit_status:" + audit_status + ",id:" + id);
		Map<String, Object> result = new HashMap<String, Object>();
		Foundation f = new Foundation();
		f.setAudit_status(audit_status);
		f.setLevel(Integer.valueOf(level));
		f.setId(Integer.valueOf(id));
		f.setModify_date(System.currentTimeMillis());
		if (adminService.handleFoundation(f) == 1) {
			AuditLog log = new AuditLog();
			log.setAudit_type("基金会审核");
			log.setAudit_operator(username);
			log.setAudit_result("1".equals(audit_status) ? "通过" : ("2".equals(audit_status) ? "不通过" : "重新审核"));
			log.setAudit_time(System.currentTimeMillis());
			System.out.println("auditLog:"+log);
			auditLogService.addAudit_Log(log);
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getNHFoundation")
	@ResponseBody
	public String getNHFoundation() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Foundation> list = adminService.getNHFoundation();
		if (null != list) {
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		for (Foundation f : list) {
			System.out.println(f);
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getIsHFoundation")
	@ResponseBody
	public String getIsHFoundation() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Foundation> list = adminService.getIsHFoundation();
		if (null != list) {
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		for (Foundation f : list) {
			System.out.println(f);
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/login")
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
