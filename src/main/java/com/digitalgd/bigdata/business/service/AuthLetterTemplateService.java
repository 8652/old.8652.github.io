package com.digitalgd.bigdata.business.service;

import com.digitalgd.bigdata.business.domain.AuthLetterTemplate;
import com.digitalgd.bigdata.business.repository.AuthLetterTemplateRepository;
import com.digitalgd.bigdata.business.service.dto.AuthLetterTemplateDTO;
import com.digitalgd.bigdata.business.service.mapper.AuthLetterTemplateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AuthLetterTemplate}.
 */
@Service
@Transactional
public class AuthLetterTemplateService {

    private final Logger log = LoggerFactory.getLogger(AuthLetterTemplateService.class);

    private final AuthLetterTemplateRepository authLetterTemplateRepository;

    private final AuthLetterTemplateMapper authLetterTemplateMapper;

    public AuthLetterTemplateService(AuthLetterTemplateRepository authLetterTemplateRepository, AuthLetterTemplateMapper authLetterTemplateMapper) {
        this.authLetterTemplateRepository = authLetterTemplateRepository;
        this.authLetterTemplateMapper = authLetterTemplateMapper;
    }

    /**
     * Save a authLetterTemplate.
     *
     * @param authLetterTemplateDTO the entity to save.
     * @return the persisted entity.
     */
    public AuthLetterTemplateDTO save(AuthLetterTemplateDTO authLetterTemplateDTO) {
        log.debug("Request to save AuthLetterTemplate : {}", authLetterTemplateDTO);
        AuthLetterTemplate authLetterTemplate = authLetterTemplateMapper.toEntity(authLetterTemplateDTO);
        authLetterTemplate = authLetterTemplateRepository.save(authLetterTemplate);
        return authLetterTemplateMapper.toDto(authLetterTemplate);
    }

    /**
     * Get all the authLetterTemplates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthLetterTemplateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AuthLetterTemplates");
        return authLetterTemplateRepository.findAll(pageable)
            .map(authLetterTemplateMapper::toDto);
    }


    /**
     * Get one authLetterTemplate by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AuthLetterTemplateDTO> findOne(Long id) {
        log.debug("Request to get AuthLetterTemplate : {}", id);
        return authLetterTemplateRepository.findById(id)
            .map(authLetterTemplateMapper::toDto);
    }

    /**
     * Delete the authLetterTemplate by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AuthLetterTemplate : {}", id);
        authLetterTemplateRepository.deleteById(id);
    }
}
