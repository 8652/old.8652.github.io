package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.BigInterfaceList;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BigInterfaceList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BigInterfaceListRepository extends JpaRepository<BigInterfaceList, Long> {
}
