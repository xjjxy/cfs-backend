package com.hutb.cfs.admin.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:admin.properties")
public class SysBean {

//	@Value("${admin.privateKey}")
//	private String privateKey;
	
	@Value("${admin.password}")
	private String password;
	
	public SysBean(){
		System.out.println("Admin");
	}
	
	@Value("${admin.hash}")
	private String hash;
//	public String getPrivateKey() {
//		return privateKey;
//	}
//
//	public void setPrivateKey(String privateKey) {
//		this.privateKey = privateKey;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
