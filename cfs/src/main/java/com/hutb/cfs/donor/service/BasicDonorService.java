package com.hutb.cfs.donor.service;

import com.hutb.cfs.donor.entity.Donor;

public interface BasicDonorService {

	int addDonor(Donor donor);
	
	Donor getDonor(String username,String password);
	
	int addWalletUUID(String uuid,int id);
}
