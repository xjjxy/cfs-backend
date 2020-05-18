package com.hutb.cfs.admin.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import com.hutb.cfs.admin.dao.DetailDao;
import com.hutb.cfs.admin.entity.SysBean;
import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.foundation.entity.Phase;
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
	public int donate(int project_id, int donate_amount, Wallet wallet) {
		// TODO Auto-generated method stub
		Detail detail2 = getDetailContract(wallet);
		BigDecimal _donate_amount = Convert.toWei(BigDecimal.valueOf(donate_amount), Convert.Unit.ETHER);
		BigInteger da = BigInteger.valueOf(_donate_amount.longValue());
		System.out.println("donation amount:" + da);
		System.out.println();
		try {
			detail2.donation(BigInteger.valueOf(project_id), da).sendAsync();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Project getDetail(int project_id) {
		// TODO Auto-generated method stub
		if (detail == null) {
			detail = getDetailContractByAdmin();
		}

		Project p = null;
		try {
			p = new Project();
			String wallet_address = detail.getDetail(BigInteger.valueOf(project_id)).send().component1();
			long target_amount = Convert
					.fromWei(detail.getDetail(BigInteger.valueOf(project_id)).send().component2().toString(),
							Convert.Unit.ETHER)
					.longValue();
			long now_amount = Convert
					.fromWei(detail.getDetail(BigInteger.valueOf(project_id)).send().component3().toString(),
							Convert.Unit.ETHER)
					.longValue();
			long last_amount = Convert
					.fromWei(detail.getDetail(BigInteger.valueOf(project_id)).send().component4().toString(),
							Convert.Unit.ETHER)
					.longValue();
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

		if (detail == null) {
			detail = getDetailContractByAdmin();
		}
		try {
			BigInteger ta = Convert.toWei(BigDecimal.valueOf(target_amount), Convert.Unit.ETHER).toBigInteger();
			// System.out.println("存入以太坊--target_amount:"+ta);
			detail.createDetail(wallet_address, ta, BigInteger.valueOf(project_id)).send();
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

	private Detail getDetailContract(Wallet wallet) {

		Credentials credentials = null;
		try {
			credentials = MyWalletUtils.getCredentials(wallet.getPassword(), wallet.getHash());
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

	@Override
	public void addPhase(int project_id, Phase phase) {
		// TODO Auto-generated method stub
		if (detail == null) {
			detail = getDetailContractByAdmin();
		}
		BigInteger spend = Convert.toWei(BigDecimal.valueOf(phase.getPhase_spend()), Convert.Unit.ETHER).toBigInteger();
		System.out.println("spend:" + spend);
		try {
			detail.createPhase(BigInteger.valueOf(project_id), String.valueOf(phase.getPhase_time()),
					phase.getPhase_title(), phase.getPhase_description(), spend).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Phase getPhase(int index, int project_id) {
		// TODO Auto-generated method stub
		if (detail == null) {
			detail = getDetailContractByAdmin();
		}
		Phase phase = new Phase();
		try {
			String phase_time = detail.getPhase(BigInteger.valueOf(project_id), BigInteger.valueOf(index)).send()
					.component1();
			String phase_title = detail.getPhase(BigInteger.valueOf(project_id), BigInteger.valueOf(index)).send()
					.component2();
			String phase_description = detail.getPhase(BigInteger.valueOf(project_id), BigInteger.valueOf(index)).send()
					.component3();
			BigInteger psd = detail.getPhase(BigInteger.valueOf(project_id), BigInteger.valueOf(index)).send()
					.component4();
			int phase_spend = Convert.fromWei(psd.toString(), Convert.Unit.ETHER).intValue();
			System.out.println("get from eth phase_time:"+phase_time);
			phase.setPhase_time(Long.valueOf(phase_time));
			phase.setPhase_title(phase_title);
			phase.setPhase_description(phase_description);
			phase.setPhase_spend(phase_spend);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phase;
	}

	@Override
	public int getPhaseSize(int project_id) {
		// TODO Auto-generated method stub
		if (detail == null) {
			detail = getDetailContractByAdmin();
		}
		int phaseSize = 0;
		try {
			phaseSize = detail.getPhaseSize(BigInteger.valueOf(project_id)).send().intValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phaseSize;
	}

}
