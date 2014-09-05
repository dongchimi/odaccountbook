package org.dongchimi.odong.accountbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="TB_ODUSER")
public class ODUser {
	
	@Id
	@GeneratedValue
	private Long oId;
	
	// 사용자 Email
	@Column(nullable=true)
	private String email;
	
	// 이름
	@Column(nullable=true)
	private String name;
	
	// 패스워드
	@Column
	private String password;
	
	// 가계부권한
	@OneToMany(cascade = CascadeType.ALL, targetEntity = ODAccountBookAuth.class)
	@JsonManagedReference
	private List<ODAccountBookAuth> accountBookAuths = new ArrayList<ODAccountBookAuth>(1);
	
	public ODUser() {}
	
	public ODUser(String email, String password) {
		this.email = email;
		this.password = password;
		
		addNewAccountBookAuth();
	}
	
	public void addNewAccountBookAuth() {
		ODAccountBook book = new ODAccountBook("기본가계부");
		ODAccountBookAuth newAuth = ODAccountBookAuth.createReadWriteAccountBookAuth(this, book);
		newAuth.setDefaultBookAuth(true);
		accountBookAuths.add(newAuth);
	}
	
	public Long getDefaultBookOid() {
		for(ODAccountBookAuth auth : accountBookAuths) {
			if (auth.isDefaultBookAuth()) {
				return auth.getRelatedBook().getoId();
			}
		}
		return null;
	}
	
	public ODAccountBook getDefaultBook() {
		for(ODAccountBookAuth auth : accountBookAuths) {
			if (auth.isDefaultBookAuth()) {
				return auth.getRelatedBook();
			}
		}
		return null;
	}
	

	public ODAccountBook getAccountBookByOid(Long bookOid) {
		for(ODAccountBookAuth auth : accountBookAuths) {
			if (auth.getRelatedBook().getoId().equals(bookOid)) {
				return auth.getRelatedBook();
			}
		}
		return null;
	}
	
	
	/**
	 * 지출
	 * @param when
	 * @param where
	 * @param what
	 * @param howmuch
	 */
//	public void out(String when, PaymentMethod where, String what, int howmuch) {
//		where.out(when, what, howmuch, name);
//	}
//	
//	public void in(String when, Asset where, String what, int howmuch) {
//		where.in(when, what, howmuch, name);
//	}
//	
//	public void transfer(String when, Asset from, Asset to, int howmuch) {
//		from.out(when, buildTranferName(to), howmuch, name);
//		to.in(when, buildTranferName(from), howmuch, name);
//	}
	
	private String buildTranferName(Asset asset) {
		return "이체 -> " + asset.getNickName();
	}
	
	public boolean equaslsPassword(String password) {
		return StringUtils.trimAllWhitespace(this.password).equals(StringUtils.trimAllWhitespace(password));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equalsByEmail(String otherEmail) {
		return this.email.equals(otherEmail);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public List<ODAccountBookAuth> getAccountBookAuths() {
		return accountBookAuths;
	}

	public void setAccountBookAuths(List<ODAccountBookAuth> accountBookAuths) {
		this.accountBookAuths = accountBookAuths;
	}

}
