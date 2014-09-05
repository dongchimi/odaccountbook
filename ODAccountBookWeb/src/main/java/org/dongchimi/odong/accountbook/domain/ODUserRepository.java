package org.dongchimi.odong.accountbook.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ODUserRepository extends JpaRepository<ODUser, Long> {
	public ODUser findByEmail(@Param("id") String id);
}