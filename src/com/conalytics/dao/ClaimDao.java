package com.conalytics.dao;

import java.util.List;



import com.conalytics.domain.Claim;

public interface ClaimDao {
	public void insertClaim(Claim claim);

	public void updateClaim(Claim claim);

	public void deleteClaim(Double id);

	public List<Claim> getClaimList();

	public Claim getClaimbyId(Double id);

}
