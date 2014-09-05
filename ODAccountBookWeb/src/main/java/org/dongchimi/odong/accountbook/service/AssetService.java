package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.ODUser;

public class AssetService {
	
	private List<ODUser> users; 
	
	// 임시로..
	public void makeMock(List<ODUser> users) {
		this.users = users;
	}
	
	public List<Asset> findAssetsByUser(String userId) {
//		List<Asset> allAsset = new ArrayList<Asset>();
//		for (ODUser user : users) {
//			if ( user.equalsByEmail(userId)) {
//				allAsset.addAll( user.getAssets() );
//			}
//			else {
//				allAsset.addAll( user.getAssetOfCoOwner(userId) );
//			}
//		}
//		return allAsset;
		
		return null;
	}
}
