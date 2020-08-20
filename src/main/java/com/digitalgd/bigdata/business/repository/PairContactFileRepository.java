package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.PairContactFile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PairContactFile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PairContactFileRepository extends JpaRepository<PairContactFile, Long> {
}
