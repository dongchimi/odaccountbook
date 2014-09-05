package org.dongchimi.odong.accountbook.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="TB_ASSET")
public class Asset {
	
	@Id
	@GeneratedValue
	private Long oid;
	
	// 이름
	@Column(nullable=true)
	private String name;
	
	// 별칭
	@Column(nullable=true)
	private String nickName;
	
	// 잔액
	@Column(nullable=true)
	private int balance;
	
	// 가계부
	@OneToOne(cascade = CascadeType.ALL, targetEntity = ODAccountBook.class)
	private ODAccountBook relatedBook;
	
	// 연관된 체크카드
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Card.class)
    @JoinColumn(name="card_oid")
	private Card relatedCard;
	
	public Asset() {}
	
	public Asset(String name, String nickName) {
		this.name = name;
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void out(String when, String what, int howmuch, String who) {
		this.balance -= howmuch;
	}

	public void in(String when, String what, int howmuch, String who) {
		this.balance += howmuch;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ODAccountBook getRelatedBook() {
		return relatedBook;
	}

	public void setRelatedBook(ODAccountBook relatedBook) {
		this.relatedBook = relatedBook;
	}

	public Card getRelatedCard() {
		return relatedCard;
	}

	public void setRelatedCard(Card relatedCard) {
		this.relatedCard = relatedCard;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}
}
