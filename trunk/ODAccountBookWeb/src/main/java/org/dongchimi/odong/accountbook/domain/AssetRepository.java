package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    public List<Asset> findByAccountBookOid(long accountBookOid);

}
