package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.PairContract;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PairContract entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PairContractRepository extends JpaRepository<PairContract, Long> {
}
