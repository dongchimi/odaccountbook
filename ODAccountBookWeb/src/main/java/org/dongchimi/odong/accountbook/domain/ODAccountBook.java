package org.dongchimi.odong.accountbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="TB_ODACCOUNT_BOOK")
public class ODAccountBook {
	
	/** 기본 월 기준일 */
	@Transient
	private static final int USER_BASE_DAY = 1;
	
	@Id
	@GeneratedValue
	private Long oId;
	
	@Column
	private String name;
	
	/** 기준일 */
	@Column
	private int baseDay;
	
	/** 가계부 권한 */
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ODAccountBookAuth.class)
	@JsonBackReference
	private List<ODAccountBookAuth> auths = new ArrayList<ODAccountBookAuth>(1);
	
	// 자산
//	@OneToMany(cascade = CascadeType.ALL, targetEntity = Asset.class)
//	@JoinColumn(name="card_oid")
//	private List<Asset> assets;
	
	// 카드
//	@OneToMany(cascade = CascadeType.ALL, targetEntity = Card.class)
//	@JoinColumn(name="card_oid")
//	private List<Card> cards;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ODAccountBookLog.class)
	@JsonManagedReference
	private List<ODAccountBookLog> logs;
	
	public ODAccountBook() {}
	
	public ODAccountBook(String name) {
		baseDay = USER_BASE_DAY;
		this.name = name;
	}
	public Long getoId() {
		return oId;
	}
	public void setoId(Long oId) {
		this.oId = oId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addAuth(ODAccountBookAuth auth) {
		auths.add(auth);
	}
	public List<ODAccountBookAuth> getAuths() {
		return auths;
	}
	public void setAuths(List<ODAccountBookAuth> auths) {
		this.auths = auths;
	}

	public int getBaseDay() {
		return baseDay;
	}

	public void setBaseDay(int baseDay) {
		this.baseDay = baseDay;
	}
}
