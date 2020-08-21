package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.BigInterfaceBiz;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BigInterfaceBiz entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BigInterfaceBizRepository extends JpaRepository<BigInterfaceBiz, Long> {
}
