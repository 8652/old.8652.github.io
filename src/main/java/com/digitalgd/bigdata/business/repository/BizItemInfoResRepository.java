package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.BizItemInfoRes;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BizItemInfoRes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BizItemInfoResRepository extends JpaRepository<BizItemInfoRes, Long> {
}
