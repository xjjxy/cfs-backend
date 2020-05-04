package com.hutb.cfs.donor.service;

import com.hutb.cfs.donor.entity.Donor;

public interface BasicDonorService {

	public int addDonor(Donor donor);
	
	public Donor getDonor(String username,String password,String role);
	
	public int addWalletUUID(String uuid,int id);
}
