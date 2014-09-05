package org.dongchimi.odong.accountbook.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="TB_ODACCOUNT_BOOK_AUTH")
public class ODAccountBookAuth {
	
	@Id
	@GeneratedValue
	private Long oid;
	
    @ManyToOne
    @JsonBackReference
	private ODUser user;
    
    // 기본 가계부 권한 여부
    private boolean isDefaultBookAuth;
	
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ODAccountBook.class)
    @JsonManagedReference
	private ODAccountBook relatedBook;
	
    @Enumerated(EnumType.STRING)
	private AuthType authType;
	
	public static ODAccountBookAuth createReadWriteAccountBookAuth(ODUser user, ODAccountBook book) {
		ODAccountBookAuth auth = new ODAccountBookAuth();
		auth.setUser(user);
		auth.setRelatedBook(book);
		auth.authType = AuthType.READ_WRITE;
		book.addAuth(auth);
		return auth;
	}
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public ODUser getUser() {
		return user;
	}

	public void setUser(ODUser user) {
		this.user = user;
	}

	public ODAccountBook getRelatedBook() {
		return relatedBook;
	}

	public void setRelatedBook(ODAccountBook relatedBook) {
		this.relatedBook = relatedBook;
	}

	public AuthType getAuthType() {
		return authType;
	}

	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}

	public boolean isDefaultBookAuth() {
		return isDefaultBookAuth;
	}

	public void setDefaultBookAuth(boolean isDefaultBookAuth) {
		this.isDefaultBookAuth = isDefaultBookAuth;
	}
}
