package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.SystemLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SystemLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
}
