package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="TB_ODACCOUNT_BOOK_LOG")
public class ODAccountBookLog { // implements Comparable<ODAccountBookLog>

	@Id
	@GeneratedValue
	public Long oid;
	
	@ManyToOne
	@JsonBackReference
	private ODAccountBook relatedBook;
	
	// 언제
	private String whenDate;
	// 무엇을 
	private String what;
	// 얼마나
	private int howmuch;
	// 어떻게
	private HowType how;
	// 누가
	private String who;
	// 잔액
	private int balance;
	
	
//	public ODAccountBookLog(String when, String what, int howmuch, HowType how, String who, int balance, PaymentMethod paymentMethod) {
//		this.whenDate = when;
//		this.what = what;
//		this.howmuch = howmuch;
//		this.how = how;
//		this.who = who;
//		this.balance = balance;
//		this.paymentMethod = paymentMethod;
//	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(whenDate).append(", ").append(what)
					  .append(", ").append(howmuch)
					  .append(", ").append(how)
					  .append(", ").append(who)
					  .append(", ").append(balance);
					  //.append(", ").append(paymentMethod);
		return b.toString();
	}
	public HowType getHow() {
		return how;
	}
	public void setHow(HowType how) {
		this.how = how;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}

	public int getHowmuch() {
		return howmuch;
	}

	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
//	@Override
	public int compareTo(ODAccountBookLog o) {
		long currentDate = 0 ;
		long otherDate = 0 ;
		try {
			currentDate = Long.valueOf(this.whenDate);
			otherDate = Long.valueOf(o.whenDate);
		} catch (NumberFormatException e) { 
			// ignore
		}
		
		if (currentDate > otherDate) return 1;
		if (currentDate < otherDate) return -1;
		return 0;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getWhenDate() {
		return whenDate;
	}

	public void setWhenDate(String whenDate) {
		this.whenDate = whenDate;
	}
}
