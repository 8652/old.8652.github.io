package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.BizItem;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BizItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BizItemRepository extends JpaRepository<BizItem, Long> {
}
