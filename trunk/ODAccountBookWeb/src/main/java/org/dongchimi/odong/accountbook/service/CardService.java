package org.dongchimi.odong.accountbook.service;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.ODUser;

public class CardService {

	private List<ODUser> users; 
	
	// 임시로..
	public void makeMock(List<ODUser> users) {
		this.users = users;
	}
	
	public List<Card> findCardsByUser(String userId) {
//		List<Card> allCard = new ArrayList<Card>();
//		for (ODUser user : users) {
//			if ( user.equalsByEmail(userId)) {
//				allCard.addAll( user.getCards() );
//			}
//			else {
//				allCard.addAll( user.getCardOfCoOwner(userId) );
//			}
//		}
//		return allCard;
		
		return null;
	}
}
