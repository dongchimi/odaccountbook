package org.dongchimi.odong.accountbook.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ODAccountBookLogRepository extends JpaRepository<ODAccountBookLog, Long> {

    public List<ODAccountBookLog> findByWhenDateBetweenOrderByWhenDateDesc(String fromDate, String toDate);
	
}
