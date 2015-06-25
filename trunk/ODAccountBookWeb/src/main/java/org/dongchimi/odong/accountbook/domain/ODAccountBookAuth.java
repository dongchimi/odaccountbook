package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "TB_ODACCOUNT_BOOK_AUTH")
public class ODAccountBookAuth {

    @Id
    @GeneratedValue
    private Long oid;

    @Column
    private Long userOid;

    @Column
    private Long accountBookOid;

    @Enumerated(EnumType.STRING)
    private AuthType authType;

    // 기본 가계부 권한 여부
    @Transient
    private boolean isDefaultBookAuth;

    public static ODAccountBookAuth createReadWriteAccountBookAuth(Long userOid, Long accountBookOid) {
        ODAccountBookAuth auth = new ODAccountBookAuth();
        auth.setUserOid(userOid);
        auth.setAccountBookOid(accountBookOid);
        auth.authType = AuthType.READ_WRITE;
        // book.addAuth(auth);
        return auth;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getUserOid() {
        return userOid;
    }

    public void setUserOid(Long userOid) {
        this.userOid = userOid;
    }

    public Long getAccountBookOid() {
        return accountBookOid;
    }

    public void setAccountBookOid(Long accountBookOid) {
        this.accountBookOid = accountBookOid;
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
