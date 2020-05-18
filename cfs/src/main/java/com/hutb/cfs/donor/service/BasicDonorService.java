package com.hutb.cfs.donor.service;

import java.util.List;

import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.donor.entity.Donor;

public interface BasicDonorService {

	public int addDonor(Donor donor);
	
	public Donor getDonor(String username,String password,String role);
	
	public int addWalletUUID(String uuid,int id);
	
	public List<Donation> getDonatedProject(int donor_id);
	
	public List<Donation> getProjectDonate(int project_id);
	
	public List<Donation> getAllDonation(int currentIndex,int pageSize);
	
	public int checkUsername(String username);
}
