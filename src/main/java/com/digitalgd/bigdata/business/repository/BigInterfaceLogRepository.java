package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.BigInterfaceLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BigInterfaceLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BigInterfaceLogRepository extends JpaRepository<BigInterfaceLog, Long> {
}
