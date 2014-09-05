package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODUser;

public class HistoryService {
	
	private List<ODUser> users; 
	
	// 임시로..
	public void makeMock(List<ODUser> users) {
		this.users = users;
	}
	
	public List<ODAccountBookLog> findHistoryByMonth(String currentMonth, String userId) {
//		List<History> allHistories = new ArrayList<History>();
//		for (ODUser user : users) {
//			if ( user.equalsByEmail(userId)) {
//				allHistories.addAll( user.getAssetHistories() );
//			}
//			else {
//				allHistories.addAll( user.getAssetHistoriesOfCoOwner(userId) );
//			}
//		}
//		
//		List<History> allHistoriesByMonth = new ArrayList<History>();
//		for (History history : allHistories) {
//			String when = history.getWhenDate();
//			if (when.substring(0, 6).equals(currentMonth)) {
//				allHistoriesByMonth.add(history);
//			}
//		}
//		
//		Collections.sort(allHistoriesByMonth);
//		
//		return allHistoriesByMonth;
		
		return null;
	}
}
