package org.dongchimi.odong.accountbook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.StringUtils;

@Entity(name = "TB_ODUSER")
public class ODUser {

    @Id
    @GeneratedValue
    private Long oid;

    // 사용자 Email
    @Column(nullable = true)
    private String email;

    // 이름
    @Column(nullable = true)
    private String name;

    // 패스워드
    @Column
    private String password;

    public ODUser() {
    }

    public ODUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * 지출
     * 
     * @param when
     * @param where
     * @param what
     * @param howmuch
     */
    // public void out(String when, PaymentMethod where, String what, int
    // howmuch) {
    // where.out(when, what, howmuch, name);
    // }
    //
    // public void in(String when, Asset where, String what, int howmuch) {
    // where.in(when, what, howmuch, name);
    // }
    //
    // public void transfer(String when, Asset from, Asset to, int howmuch) {
    // from.out(when, buildTranferName(to), howmuch, name);
    // to.in(when, buildTranferName(from), howmuch, name);
    // }
    //
    // private String buildTranferName(Asset asset) {
    // return "이체 -> " + asset.getNickName();
    // }

    public boolean equaslsPassword(String password) {
        return StringUtils.trimAllWhitespace(this.password).equals(
                StringUtils.trimAllWhitespace(password));
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

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

}
