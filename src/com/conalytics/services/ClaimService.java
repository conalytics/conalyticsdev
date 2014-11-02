package com.conalytics.services;

import java.util.List;

import com.conalytics.domain.Claim;

public interface ClaimService {
	
	public void insertClaim(Claim claim);

	public void deleteClaim(Double claimId);

	public void updateClaim(Claim claim);
	
	public  List<Claim> getClaimList();
	
	public Claim getClaimbyId(Double id);
}
