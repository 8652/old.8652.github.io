package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.PairContractFile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PairContractFile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PairContractFileRepository extends JpaRepository<PairContractFile, Long> {
}
