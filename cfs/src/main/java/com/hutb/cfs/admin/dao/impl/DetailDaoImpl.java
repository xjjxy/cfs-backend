package com.hutb.cfs.admin.dao.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import com.hutb.cfs.admin.dao.DetailDao;
import com.hutb.cfs.admin.entity.SysBean;
import com.hutb.cfs.donor.entity.Donor;
import com.hutb.cfs.foundation.entity.FoundationUser;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.solidity.Detail;
import com.hutb.cfs.utils.MyWalletUtils;

@Component
@PropertySource("classpath:contractAddress.properties")
public class DetailDaoImpl implements DetailDao {
	
	
	Web3j web3j = Web3j.build(new HttpService());
	@Autowired
	private SysBean sysBean;


	@Value("${Detail}")
	private String detailContract;

	private Detail detail = null;

	

	@Override
	public Project getDetail(int project_id) {
		// TODO Auto-generated method stub
		if(detail == null){
			detail = getDetailContractByAdmin();
		}
		
		Project p = null;
		try {
			p = new Project();
			String wallet_address = detail.getDetail(BigInteger.valueOf(project_id)).send().component1();
			long target_amount = detail.getDetail(BigInteger.valueOf(project_id)).send().component2().longValue();
			long now_amount = detail.getDetail(BigInteger.valueOf(project_id)).send().component3().longValue();
			long last_amount = detail.getDetail(BigInteger.valueOf(project_id)).send().component4().longValue();
			p.setWallet_address(wallet_address);
			p.setTarget_amount(target_amount);
			p.setNow_amount(now_amount);
			p.setLast_amount(last_amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
	@Override
	public void createDetail(String wallet_address, long target_amount, int project_id) {
		// TODO Auto-generated method stub

		if(detail == null){
			detail = getDetailContractByAdmin();
		}
		try {
			detail.createDetail(wallet_address, BigInteger.valueOf(target_amount), BigInteger.valueOf(project_id)).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private Detail getDetailContractByAdmin() {

		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials(sysBean.getPassword(), sysBean.getHash());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Detail detail = Detail.load(detailContract, web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		return detail;
	}
	
	private Detail getDetailContract(FoundationUser fu) {

		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials(sysBean.getPassword(), sysBean.getHash());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Detail detail = Detail.load(detailContract, web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		return detail;
	}
	
	private Detail getDetailContract(Donor donor) {

		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials("wallet_password", "hash");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 获取证书失败
			e.printStackTrace();
		}
		BigInteger gasPrice = BigInteger.valueOf(2000000000);
		Detail detail = Detail.load(detailContract, web3j, credentials,
				new StaticGasProvider(gasPrice, BigInteger.valueOf(6721975)));
		return detail;
	}

}
