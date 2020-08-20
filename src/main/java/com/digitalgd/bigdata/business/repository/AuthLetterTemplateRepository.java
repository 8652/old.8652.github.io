package com.digitalgd.bigdata.business.repository;

import com.digitalgd.bigdata.business.domain.AuthLetterTemplate;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AuthLetterTemplate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthLetterTemplateRepository extends JpaRepository<AuthLetterTemplate, Long> {
}
