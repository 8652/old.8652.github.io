package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.AuthLetterRecord;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AuthLetterRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthLetterRecordRepository extends JpaRepository<AuthLetterRecord, Long> {
}
