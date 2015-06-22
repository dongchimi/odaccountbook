package org.dongchimi.odong.account;

import java.util.List;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.Card;
import org.dongchimi.odong.accountbook.domain.ODAccountBookLog;
import org.dongchimi.odong.accountbook.domain.ODUser;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.dongchimi.odong.accountbook.service.CardService;
import org.dongchimi.odong.accountbook.service.HistoryService;
import org.dongchimi.odong.accountbook.service.ODUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSenario {
	
	@Autowired
	ODUserService odUserService;
	
	@Test
	public void domainSenario() {
//		List<ODUser> users = buildTestSenarioUsers();
//		for (ODUser user : users) {
//			System.out.println(user);
//		}
	}
	
	private List<ODUser> buildTestSenarioUsers() {
//		ODUser dongkyu = new ODUser("dongkyu", "동규", 31);
//		ODUser wonmi = new ODUser("wonmi", "원미", 31);
//
//		Asset hanaBank1 = new Asset("하나은행", "동규월급");
//		hanaBank1.addCoOwner(wonmi);
//		dongkyu.addAsset(hanaBank1);
//
//		Asset hanaBank2 = new Asset("하나은행", "원미월급");
//		wonmi.addAsset(hanaBank2);
//		hanaBank2.addCoOwner(dongkyu);
//		
//		// 1. 동규는 3/31일 월급 5백만원을 하나은행으로 받았다.
//		dongkyu.in("20140331", hanaBank1, "월급", 5000000);
//		
//		// 2. 원미는 3/31일 월급 4백만원을 하나은행으로 받았다.
//		wonmi.in("20140331", hanaBank2, "월급", 4000000);
//		
//		// 3. 원미는 3/31일 동규월급과 원미월급을 오동(신한은행) 계좌로 이체하였다.
//		Asset odongBank = new Asset("신한은행", "오동");
//		dongkyu.addAsset(odongBank);
//		
//		wonmi.transfer("20140331", hanaBank1, odongBank, 5000000);
//		wonmi.transfer("20140331", hanaBank2, odongBank, 4000000);
//		
//		// 4. 원미는 적금 300만원을 가입했다.
//		Asset installmentDepositBank2 = new Asset("신한은행적금", "적금2");
//		wonmi.addAsset(installmentDepositBank2);
//		wonmi.transfer("20140331", odongBank, installmentDepositBank2, 3000000);
//		
//		// 5. 원미는 4/30일 동규에게 20만원 용돈을 주었다.
//		Asset pocketMoneyBank = new Asset("신한은행", "동규용돈");
//		dongkyu.addAsset(pocketMoneyBank);
//		wonmi.transfer("20140430", odongBank, pocketMoneyBank, 200000);
//		
//		// 6. 원미는 4/30일 적금 120만원을 이체하였다.
//		Asset installmentDepositBank1 = new Asset("신한은행", "적금1");
//		dongkyu.addAsset(installmentDepositBank1);
//		wonmi.transfer("20140430", odongBank, installmentDepositBank1, 1200000);
//		
//		// 7. 원미는 4/30일 엄마에게 30만원을 이체하였다.
//		wonmi.out("20140430", odongBank, "엄마용돈", 300000);
//		
//		// 8. 동규는 5/28일 용돈체크카드로 3,500원 점심을 먹었다.
//		Card pocketMoneyCard = Card.newCheckCard("신한체크카드", "동규용돈카드", pocketMoneyBank);
//		dongkyu.addCard(pocketMoneyCard);
//		dongkyu.out("20140528", pocketMoneyCard, "점심", 3500);
//		
//		// 9. 원미는 5/31일 원미에게 20만원 용돈을 주었다.
//		Asset wonmiPocketMoneyBank = new Asset("신한은행", "원미용돈");
//		wonmi.addAsset(wonmiPocketMoneyBank);
//		wonmi.transfer("20140531", odongBank, wonmiPocketMoneyBank, 200000);
//		
//		// 10. 원미는 5/31일 용돈계좌에서 현금으로 10만원 인출하였다.
//		Asset wallet = new Asset("현금", "원미지갑");
//		wonmi.addAsset(wallet);
//		wonmi.transfer("20140531", wonmiPocketMoneyBank, wallet, 100000);
//		
//		// 11. 원미는 5/31일 현금으로 4,500원으로 점심을 먹었다.
//		wonmi.out("20140531", wallet, "점심", 4500);
//		
//		// 12. 원미는 5/27일 원미신용카드로 머리를 했다. (90,000원)
//		Card wonmiCreditCard = Card.newCreditCard("신한신용카드", "원미신용카드", pocketMoneyBank, 10);
//		wonmi.addCard(wonmiCreditCard);
//		wonmi.out("20140527", wonmiCreditCard, "미용실", 90000);
//		
//		// 13. 원미는 5/26일 3,000,000원 적금이 만기되어 3,015,449을 받았다.
//		wonmi.in("20140526", installmentDepositBank2, "적금3백이자", 15449);
//		wonmi.transfer("20140526", installmentDepositBank2, odongBank, 3015449);
//		
//		// 14. 동규는 5/27일 등록된 자동이체를 이용하여 도시가스 요금 47,280원을 지출하였다.
//		dongkyu.out("20140527", odongBank, "도시가스-자동이체", 47280);
//		
//		// 15. 동규는 5/28일 원미신용카드로 주유를 50030원 하고, 400원 할인 받았다.
//		//dongkyu.out();
//		
//		List<ODUser> users = new ArrayList<ODUser>();
//		users.add(dongkyu);
//		users.add(wonmi);
		return null;
	}
	
	/** 월별 목록 조회 */
//	@Test
	public void testSearchHistoryByDate() {
		HistoryService historyService = new HistoryService();
		historyService.makeMock(buildTestSenarioUsers());
		String currentMonth = "201403";
		List<ODAccountBookLog> foundHistories = historyService.findHistoryByMonth(currentMonth, "dongkyu");
		// 출력
		for ( ODAccountBookLog history : foundHistories) {
			System.out.println(history);
		}
		System.out.println();
		foundHistories = historyService.findHistoryByMonth(currentMonth, "wonmi");
		// 출력
		for ( ODAccountBookLog history : foundHistories) {
			System.out.println(history);
		}
	}
	
	/** 자산별 목록 조회 */
//	@Test
//	public void testSearchAssetByUser() {
//		AssetService assetService = new AssetService();
//		assetService.makeMock(buildTestSenarioUsers());
//		List<Asset> foundAssets = assetService.findAssetsByUser("dongkyu");
//		// 출력
//		for ( Asset asset : foundAssets) {
//			System.out.println(asset.getNickName() + ", " + asset.getName() + ", " + asset.getBalance());
//		}
//		System.out.println();
//		foundAssets = assetService.findAssetsByUser("wonmi");
//		// 출력
//		for ( Asset asset : foundAssets) {
//			System.out.println(asset.getNickName() + ", " + asset.getName() + ", " + asset.getBalance());
//		}
//	}
	
	/** 카드별 목록 조회 */
//	@Test
	public void testSearchCardByUser() {
		CardService cardService = new CardService();
		cardService.makeMock(buildTestSenarioUsers());
		List<Card> foundCards = cardService.findCardsByUser("dongkyu");
		// 출력
		for ( Card card : foundCards) {
			System.out.println(card.getNickName() + ", " + card.getCompanyName() + ", " + card.getCreditCardCharge());
		}
		System.out.println();
		foundCards = cardService.findCardsByUser("wonmi");
		// 출력
		for ( Card card : foundCards) {
			System.out.println(card.getNickName() + ", " + card.getCompanyName());
		}
	}
	
//	@Test
	public void testRegisterNGetODUser() {
		
	}
}
