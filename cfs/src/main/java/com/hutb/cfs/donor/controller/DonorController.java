package com.hutb.cfs.donor.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hutb.cfs.admin.dao.impl.WalletDaoImpl;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.donor.entity.Comment;
import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.donor.entity.Donor;
import com.hutb.cfs.donor.service.impl.DefaultBasicDonorService;
import com.hutb.cfs.donor.service.impl.DefaultCommentService;
import com.hutb.cfs.utils.IpfsUtils;

@Controller
@RequestMapping(value = "/donor", produces = "text/plain;charset=utf-8")
// @CrossOrigin
public class DonorController {

	@Autowired
	private DefaultBasicDonorService basicDonorService;

	@Autowired
	private DefaultCommentService commentService;

	@Autowired
	private WalletDaoImpl walletDao;

	@RequestMapping("/getAllDonation")
	@ResponseBody
	public String getAllDonation(int currentPage,int pageSize) {
		Map<String, Object> result = new HashMap<String, Object>();
		int currentIndex = pageSize * (currentPage - 1);
		List<Donation> list = basicDonorService.getAllDonation(currentIndex,pageSize);
		if (null != list) {
			result.put("type", "1");
			result.put("list", list);
			result.put("totalCount", list.size());
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getProjectDonate")
	@ResponseBody
	public String getProjectDonate(int project_id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Donation> list = basicDonorService.getProjectDonate(project_id);
		if (null != list) {
			System.out.println("project donate list:" + list);
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}

		return JSON.toJSONString(result);
	}

	@RequestMapping("/deleteComment")
	@ResponseBody
	public String deleteComment(int id) {
		System.out.println("id:" + id);
		Map<String, Object> result = new HashMap<String, Object>();
		if (1 == commentService.deleteComment(id)) {
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getCommentByCommentatorId")
	@ResponseBody
	public String getCommentByCommentatorId(int commentator_id) {
		System.out.println("commentator_id:" + commentator_id);
		Map<String, Object> result = new HashMap<String, Object>();
		List<Comment> list = commentService.getCommentByCommentatorId(commentator_id);
		System.out.println("commentList:" + list);
		if (null != list) {
			for (Comment comment : list) {
				try {
					comment.setComment(IpfsUtils.download(comment.getComment()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getCommentByProjectId")
	@ResponseBody
	public String getCommentByProjectId(int project_id) {
		System.out.println("project_id:" + project_id);
		Map<String, Object> result = new HashMap<String, Object>();
		List<Comment> list = commentService.getCommentByProjectId(project_id);
		System.out.println("commentList:" + list);
		if (null != list) {
			for (Comment comment : list) {
				try {
					comment.setComment(IpfsUtils.download(comment.getComment()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/addComment")
	@ResponseBody
	public String addComment(Comment comment) {
		Map<String, Object> result = new HashMap<String, Object>();
		comment.setComment_time(System.currentTimeMillis());
		try {
			comment.setComment(IpfsUtils.upload(comment.getComment()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("comment:"+comment);
		if (1 == commentService.addComment(comment)) {
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public String checkUsername(String username){
		System.out.println("username:"+username);
		Map<String, Object> result = new HashMap<String, Object>();
		int check = basicDonorService.checkUsername(username);
		result.put("type", "1");
		result.put("check", check);
		
		return JSON.toJSONString(result);
	}
	

	@RequestMapping("/register")
	@ResponseBody
	public String register(String name, String username, String password, String tel) {
		Map<String, Object> result = new HashMap<String, Object>();

		System.out.println("name" + name + ",username" + username + ",password" + password + ",tel" + tel);

		Donor donor = new Donor();
		donor.setName(name);
		donor.setUsername(username);
		donor.setPassword(password);
		donor.setTel(tel);
		if (basicDonorService.addDonor(donor) == 1) {
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		String role = (String) request.getSession().getAttribute("role");
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");

		Donor donor = basicDonorService.getDonor(username, password, role);
		if (null != donor) {
			System.out.println(donor.getUuid());
			result.put("user", donor);
			result.put("type", "1");
		} else {
			result.put("type", "0");
		}
		return JSON.toJSONString(result);

	}

	@RequestMapping("/createWallet")
	@ResponseBody
	public String createWallet(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		int id = (int) request.getSession().getAttribute("id");
		String wallet_address = (String) request.getSession().getAttribute("wallet_address");
		String privateKey = (String) request.getSession().getAttribute("privateKey");
		String password = (String) request.getSession().getAttribute("password");

		String uuid = walletDao.createWallet(wallet_address, privateKey, password);
		System.out.println("create uuid:" + uuid);
		Wallet wallet = new Wallet();
		if (basicDonorService.addWalletUUID(uuid, id) == 1) {
			String _wallet_address = walletDao.getWalletAddress(uuid);
			String hash = walletDao.getWalletHash(uuid);
			String balance = walletDao.getBlance(_wallet_address);
			wallet.setHash(hash);
			wallet.setWallet_address(_wallet_address);
			wallet.setBalance(balance);
			wallet.setUuid(uuid);
			result.put("type", "1");
			result.put("wallet", wallet);
		} else {
			result.put("type", "0");
		}
		System.out.println(wallet);
		return JSON.toJSONString(result);
	}

	@RequestMapping("/getDonatedProject")
	@ResponseBody
	public String getDonatedProject(int donor_id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Donation> list = basicDonorService.getDonatedProject(donor_id);
		if (null != list) {
			result.put("type", "1");
			result.put("list", list);
		} else {
			result.put("type", "0");
		}
		System.out.println("donatedProject:" + list);

		return JSON.toJSONString(result);
	}

}
