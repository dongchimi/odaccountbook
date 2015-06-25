package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ODAccountBookAuthRepository extends JpaRepository<ODAccountBookAuth, Long> {

    public List<ODAccountBookAuth> findByUserOid(Long userOid);

}
