package com.conalytics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conalytics.dao.ClaimDao;
import com.conalytics.domain.Claim;


public class ClaimServiceImpl implements ClaimService {

	
	@Autowired
	ClaimDao claimDao;
	
	public void insertClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimDao.insertClaim(claim);
	}


	@Override
	public List<Claim> getClaimList() {
		// TODO Auto-generated method stub
		
		return claimDao.getClaimList();
	}
	
	@Override
	public void deleteClaim(Double claimid) {
		// TODO Auto-generated method stub
		claimDao.deleteClaim(claimid);
	}


	@Override
	public void updateClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimDao.updateClaim(claim);
	}


	public Claim getClaimbyId(Double id)
	{
		
		return claimDao.getClaimbyId(id);
	}


	
}
